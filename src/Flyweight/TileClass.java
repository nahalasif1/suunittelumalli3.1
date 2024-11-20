package Flyweight;

public class TileClass implements Tile {
    private final String character;
    private final String type;

    public TileClass(String character, String type) {
        this.character = character;
        this.type = type;
    }

    @Override
    public String getCharacter() {
        return character;
    }

    @Override
    public String getType() {
        return type;
    }
}
