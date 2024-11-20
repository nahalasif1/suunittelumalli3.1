package Flyweight;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game extends Application {
    private static final int ROWS = 10;
    private static final int COLUMNS = 10;
    private static final int TILE_SIZE = 50;

    @Override
    public void start(Stage stage) {
        TileGraphicFactory factory = new TileGraphicFactory();
        Map cityMap = MapFactory.createMap("city", ROWS, COLUMNS);
        Map wildernessMap = MapFactory.createMap("wilderness", ROWS, COLUMNS);

        Canvas canvas = new Canvas(COLUMNS * TILE_SIZE, ROWS * TILE_SIZE * 2 + 20);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        renderMap(gc, cityMap, factory, 0);
        drawDivider(gc, ROWS * TILE_SIZE);
        renderMap(gc, wildernessMap, factory, ROWS * TILE_SIZE + 20);

        StackPane root = new StackPane(canvas);
        stage.setScene(new Scene(root));
        stage.setTitle("Flyweight Pattern Map Example");
        stage.show();
    }

    private void renderMap(GraphicsContext gc, Map map, TileGraphicFactory factory, int yOffset) {
        gc.save();
        gc.translate(0, yOffset);
        map.render(gc, factory);
        gc.restore();
    }

    private void drawDivider(GraphicsContext gc, int yOffset) {
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeLine(0, yOffset, COLUMNS * TILE_SIZE, yOffset);
    }
}
