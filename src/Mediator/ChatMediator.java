package Mediator;

import java.util.HashMap;
import java.util.Map;

public class ChatMediator {

    private final Map<String, ChatController> clients = new HashMap<>();

    // Register a client with the mediator
    public void registerClient(String username, ChatController controller) {
        clients.put(username, controller);
    }

    // Send a message from one client to another
    public void sendMessage(String sender, String recipient, String message) {
        ChatController recipientController = clients.get(recipient);
        if (recipientController != null) {
            recipientController.receiveMessage(sender, message);
        } else {
            System.out.println("Recipient not found: " + recipient);
        }
    }
}
