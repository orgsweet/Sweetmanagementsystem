package najah;

public class MessageService {

    /**
     * Simulates sending a message.
     *
     * @param message The message to be sent.
     * @return true if the message was successfully sent, false otherwise.
     */
    public boolean sendMessage(Message message) {
        // Simulate sending message logic here
        System.out.println("Sending message:");
        System.out.println("From: " + message.getSender());
        System.out.println("To: " + message.getRecipient());
        System.out.println("Subject: " + message.getSubject());
        System.out.println("Body: " + message.getBody());
        return true; // Assume the message was sent successfully
    }

    /**
     * Simulates receiving a message.
     *
     * @param sender The sender of the message.
     * @param subject The subject of the message.
     * @return A Message object with the provided sender and subject.
     */
    public Message receiveMessage(String sender, String subject) {
        // Simulate receiving a message with a fixed body for simplicity
        return new Message(sender, "store_owner@example.com", subject, "Order Status update");
    }

    /**
     * Simulates checking if a message was sent.
     *
     * @return true if a message was sent, false otherwise.
     */
    public boolean wasMessageSent() {
        // Mock method to confirm that a message was sent
        return true; // Assume a message was sent
    }
}
