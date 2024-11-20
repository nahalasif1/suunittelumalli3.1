package Flyweight;

import java.util.Random;

public class WildernessMap extends Map {
    private static final Tile[] WILDERNESS_TILES = {
            new TileClass("S", "swamp"),
            new TileClass("W", "water"),
            new TileClass("F", "forest")
    };

    public WildernessMap(int rows, int columns) {
        super(rows, columns);
    }

    @Override
    protected Tile createTile() {
        return WILDERNESS_TILES[new Random().nextInt(WILDERNESS_TILES.length)];
    }
}
