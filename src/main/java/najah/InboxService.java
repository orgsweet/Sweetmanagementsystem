package najah;

import java.util.List;
import java.util.ArrayList;

public class InboxService {
    // Simulate a list to store messages
    private List<Message> messageStore = new ArrayList<>();

    public List<Message> getInbox(String userEmail) {
        // Filter messages by recipient email
        List<Message> inboxMessages = new ArrayList<>();
        for (Message message : messageStore) {
            if (message.getRecipientEmail().equals(userEmail)) {
                inboxMessages.add(message);
            }
        }
        return inboxMessages;
    }

    /**
     * Simulate receiving a new message and adding it to the message store.
     *
     * @param message The message to be received.
     * @return The received message.
     */
    public Message receiveMessage(Message message) {
        if (message != null) {
            messageStore.add(message); // Store the received message
        }
        return message;
    }
}
