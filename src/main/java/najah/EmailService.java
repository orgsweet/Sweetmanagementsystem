package najah;

import java.util.HashMap;
import java.util.Map;

public class EmailService {
    private Map<String, EmailNotification> notifications = new HashMap<>();
    private Map<String, SpecialRequest> specialRequests = new HashMap<>();
    private Map<String, Message> inbox = new HashMap<>(); // For storing messages

    public EmailNotification getLatestNotification(String userEmail) {
        // Retrieve the latest notification for the given email
        return notifications.get(userEmail);
    }

    public boolean sendEmailNotification(SpecialRequest specialRequest) {
        // Simulate sending an email notification
        // Store the special request notification
        EmailNotification notification = new EmailNotification(
            specialRequest.getUserEmail(),
            "Special Request Received",
            "Details about the special request: " + specialRequest.getDetails()
        );
        notifications.put(specialRequest.getUserEmail(), notification);
        
        // Simulate storing the special request
        specialRequests.put(specialRequest.getRequestId(), specialRequest);
        
        System.out.println("Email sent to " + specialRequest.getUserEmail() + ": " + notification.getMessage());
        return true; // Assume sending is always successful
    }

    public boolean receiveSpecialRequest(SpecialRequest specialRequest) {
        // Simulate receiving a special request
        specialRequests.put(specialRequest.getRequestId(), specialRequest);
        System.out.println("Special request received: " + specialRequest.getDetails());
        return true; // Assume receiving is always successful
    }

    public boolean sendMessage(String recipientEmail, String subject, String body) {
        // Simulate sending a message
        Message message = new Message(recipientEmail, subject, body, subject);
        inbox.put(recipientEmail, message);
        System.out.println("Message sent to " + recipientEmail + " with subject: " + subject);
        return true; // Assume sending is always successful
    }

    public Message receiveMessage(String senderEmail, String subject) {
        // Simulate receiving a message
        for (Message message : inbox.values()) {
            if (message.getSender().equals(senderEmail) && message.getSubject().equals(subject)) {
                return message;
            }
        }
        return null; // No message found
    }
}
