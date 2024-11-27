package Mediator;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class ChatController {

    private final String username;
    private final ChatMediator mediator;
    private final TextArea chatDisplay;

    public ChatController(String username, ChatMediator mediator, TextArea chatDisplay) {
        this.username = username;
        this.mediator = mediator;
        this.chatDisplay = chatDisplay;
        mediator.registerClient(username, this);
    }

    // Method to send a message via the mediator
    public void sendMessage(String recipient, String message) {
        mediator.sendMessage(username, recipient, message);
    }

    // Method to receive a message and display it
    public void receiveMessage(String sender, String message) {
        Platform.runLater(() -> chatDisplay.appendText(sender + " -> Me: " + message + "\n"));
    }
}
