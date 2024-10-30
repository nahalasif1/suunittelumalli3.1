package Memento;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;

public class Gui extends Application {

    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;

    // Add the main method here
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {

        controller = new Controller(this);
        Insets insets = new Insets(10, 10, 10, 10);

        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        checkBox = new CheckBox("Tap here!");
        checkBox.setPadding(insets);

        HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setSpacing(10);
        hBox.setMargin(colorBox1.getRectangle(), insets);
        hBox.setMargin(colorBox2.getRectangle(), insets);
        hBox.setMargin(colorBox3.getRectangle(), insets);

        Button historyButton = new Button("History");
        historyButton.setOnAction(event -> openHistoryWindow());

        Label label = new Label("Press Ctrl-Z to undo, Ctrl-Y to redo.");
        label.setPadding(insets);

        VBox vBox = new VBox(hBox, checkBox, label, historyButton);

        checkBox.setOnAction(event -> {
            controller.setIsSelected(checkBox.isSelected());
        });

        Scene scene = new Scene(vBox);
        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                controller.undo();
            } else if (event.isControlDown() && event.getCode() == KeyCode.Y) {
                controller.redo();
            }
        });

        stage.setScene(scene);
        stage.setTitle("Memento Pattern ");
        stage.show();
    }

    public void openHistoryWindow() {
        Stage historyStage = new Stage();
        ListView<String> listView = new ListView<>();
        for (IMemento memento : controller.getHistory()) {
            listView.getItems().add("Saved at: " + memento.getSavedTime());
        }
        listView.setOnMouseClicked(event -> {
            int index = listView.getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                IMemento selectedState = controller.getHistory().get(index);
                controller.restoreState(selectedState);
            }
        });
        Scene historyScene = new Scene(listView, 300, 400);
        historyStage.setScene(historyScene);
        historyStage.setTitle("History");
        historyStage.show();
    }

    public void updateGui() {
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());
    }
}