package Flyweight;

public class MapFactory {
    public static Map createMap(String type, int rows, int cols) {
        return switch (type.toLowerCase()) {
            case "city" -> new CityMap(rows, cols);
            case "wilderness" -> new WildernessMap(rows, cols);
            default -> throw new IllegalArgumentException("Invalid map type: " + type);
        };
    }
}
