package Command;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GUI extends Application {
    @Override
    public void start(Stage stage) {
        Cursor editor = new Cursor();

        BorderPane root = new BorderPane();
        root.setCenter(editor.getGridPane());

        Button generateButton = new Button("Create Code");
        generateButton.setOnAction(e -> new GenerateCodeCommand(editor).execute());
        root.setBottom(generateButton);

        Scene scene = new Scene(root, 500, 500);
        addKeyEventHandlers(scene, editor);

        stage.setScene(scene);
        stage.setTitle("Pixel Art Editor");
        stage.show();
    }

    private void addKeyEventHandlers(Scene scene, Cursor editor) {
        scene.setOnKeyPressed(event -> {
            KeyCode code = event.getCode();
            Command command = switch (code) {
                case UP -> new MoveCursorUpCommand(editor);
                case DOWN -> new MoveCursorDownCommand(editor);
                case LEFT -> new MoveCursorLeftCommand(editor);
                case RIGHT -> new MoveCursorRightCommand(editor);
                case SPACE -> new TogglePixelCommand(editor);
                default -> null;
            };
            if (command != null) command.execute();
        });
    }
}
