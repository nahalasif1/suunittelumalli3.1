package Facade;

public class Main {
    public static void main(String[] args) {
        ApiFacade apiFacade = new ApiFacade();

        // Example 1: Fetch a random Chuck Norris joke
        try {
            String joke = apiFacade.getAttributeValueFromJson(
                    "https://api.chucknorris.io/jokes/random", "value");
            System.out.println("Random Chuck Norris Joke: " + joke);
        } catch (Exception e) {
            System.err.println("Error fetching joke: " + e.getMessage());
        }

        // Example 2: Fetch the base currency from a foreign exchange rates API
        try {
            String baseCurrency = apiFacade.getAttributeValueFromJson(
                    "https://api.exchangerate-api.com/v4/latest/USD", "base");
            System.out.println("Base Currency: " + baseCurrency);
        } catch (Exception e) {
            System.err.println("Error fetching base currency: " + e.getMessage());
        }
    }
}
