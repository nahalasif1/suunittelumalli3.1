package Flyweight;

import java.util.Random;

class CityMap extends Map {
    private static final Tile[] CITY_TILES = {
            new TileClass("R", "road"),
            new TileClass("F", "forest"),
            new TileClass("B", "building")
    };

    public CityMap(int rows, int columns) {
        super(rows, columns);
    }

    @Override
    protected Tile createTile() {
        return CITY_TILES[new Random().nextInt(CITY_TILES.length)];
    }
}

