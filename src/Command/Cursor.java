package Command;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cursor {
    private int x = 0;
    private int y = 0;
    private final int rows = 8;
    private final int columns = 8;
    private final int[][] pixels = new int[rows][columns];
    private final GridPane gridPane = new GridPane();

    public Cursor() {
        initializeGrid();
    }

    private void initializeGrid() {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                Rectangle rectangle = createRectangle();
                gridPane.add(rectangle, column, row);
            }
        }
        updateCursor();
    }

    private Rectangle createRectangle() {
        Rectangle rectangle = new Rectangle(60, 55);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        return rectangle;
    }

    public void moveCursor(int dx, int dy) {
        int newX = x + dx;
        int newY = y + dy;
        if (isWithinBounds(newX, newY)) {
            x = newX;
            y = newY;
        }
        updateCursor();
    }

    private boolean isWithinBounds(int x, int y) {
        return x >= 0 && y >= 0 && x < rows && y < columns;
    }

    public void togglePixel() {
        pixels[x][y] = 1 - pixels[x][y]; // Toggle between 0 and 1
        updateCell(x, y);
    }

    private void updateCursor() {
        for (Node node : gridPane.getChildren()) {
            if (node instanceof Rectangle rectangle) {
                rectangle.setStroke(Color.BLACK);
            }
        }

        Rectangle currentRectangle = (Rectangle) gridPane.getChildren().get(y * columns + x);
        currentRectangle.setStroke(Color.RED);
    }

    private void updateCell(int x, int y) {
        Rectangle rectangle = (Rectangle) gridPane.getChildren().get(y * columns + x);
        rectangle.setFill(pixels[x][y] == 1 ? Color.BLACK : Color.WHITE);
    }

    public void generateCode() {
        StringBuilder sb = new StringBuilder("int[][] pixelArt = {\n");
        for (int[] row : pixels) {
            sb.append("    {");
            for (int col : row) {
                sb.append(col).append(", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append("},\n");
        }
        sb.setLength(sb.length() - 2);
        sb.append("\n};");
        System.out.println(sb);
    }

    public GridPane getGridPane() {
        return gridPane;
    }
}
