package Mediator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ChatApp extends Application {

    private final ChatMediator chatMediator = new ChatMediator();

    @Override
    public void start(Stage primaryStage) {
        // Create individual client windows
        createChatWindow("User1");
        createChatWindow("User2");
        createChatWindow("User3");
    }

    private void createChatWindow(String username) {
        Stage stage = new Stage();
        stage.setTitle("Chat - " + username);

        // Chat Area (Display)
        TextArea chatDisplay = new TextArea();
        chatDisplay.setEditable(false);
        chatDisplay.setWrapText(true);

        // Input Fields
        TextField recipientField = new TextField();
        recipientField.setPromptText("Recipient");

        TextField messageField = new TextField();
        messageField.setPromptText("Enter message");

        // Send Button
        Button sendButton = new Button("Send");

        // Create the controller for this client
        ChatController chatController = new ChatController(username, chatMediator, chatDisplay);

        // Define send button action
        sendButton.setOnAction(event -> {
            String recipient = recipientField.getText().trim();
            String message = messageField.getText().trim();

            if (!recipient.isEmpty() && !message.isEmpty()) {
                chatController.sendMessage(recipient, message);
                chatDisplay.appendText("Me -> " + recipient + ": " + message + "\n");
                messageField.clear();
            }
        });

        // Layout configuration
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10));
        layout.setHgap(10);
        layout.setVgap(10);

        layout.add(new Label("Chat Window:"), 0, 0, 2, 1);
        layout.add(chatDisplay, 0, 1, 2, 1);
        layout.add(new Label("Recipient:"), 0, 2);
        layout.add(recipientField, 1, 2);
        layout.add(new Label("Message:"), 0, 3);
        layout.add(messageField, 1, 3);
        layout.add(sendButton, 1, 4);

        // Create and show the window
        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
