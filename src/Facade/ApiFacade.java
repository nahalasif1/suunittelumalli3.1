package Facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ApiFacade {

    /**
     * Fetches the value of a specified attribute from the JSON response of a given API.
     *
     * @param urlString The API URL.
     * @param attributeName The JSON attribute whose value is to be retrieved.
     * @return The value of the specified attribute as a String.
     * @throws IOException If the HTTP request fails or the URL is invalid.
     * @throws IllegalArgumentException If the specified attribute is not found in the JSON response.
     */
    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IOException, IllegalArgumentException {
        // Step 1: Make HTTP GET request
        String jsonResponse = getJsonFromApi(urlString);

        // Step 2: Parse JSON response and extract the attribute value
        return extractAttributeFromJson(jsonResponse, attributeName);
    }

    private String getJsonFromApi(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        } finally {
            connection.disconnect();
        }
    }

    private String extractAttributeFromJson(String json, String attributeName) throws IllegalArgumentException {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);

            if (!jsonObject.containsKey(attributeName)) {
                throw new IllegalArgumentException("Attribute '" + attributeName + "' not found in JSON response.");
            }

            return jsonObject.get(attributeName).toString();
        } catch (ParseException e) {
            throw new IllegalArgumentException("Failed to parse JSON response.", e);
        }
    }
}
