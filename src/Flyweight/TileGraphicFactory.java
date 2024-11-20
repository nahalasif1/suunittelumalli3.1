package Flyweight;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {
    private final Map<String, Image> tileGraphics = new HashMap<>();

    public Image getTileGraphic(String type) {
        return tileGraphics.computeIfAbsent(type, this::loadGraphicForType);
    }

    private Image loadGraphicForType(String type) {
        String imagePath = switch (type) {
            case "swamp" -> "/kuvat/swamp.jpeg";
            case "water" -> "/kuvat/water.png";
            case "road" -> "/kuvat/road.png";
            case "forest" -> "/kuvat/forest.png";
            case "building" -> "/kuvat/building.png";
            default -> throw new IllegalArgumentException("Unknown tile type: " + type);
        };
        return new Image(getClass().getResourceAsStream(imagePath));
    }
}
