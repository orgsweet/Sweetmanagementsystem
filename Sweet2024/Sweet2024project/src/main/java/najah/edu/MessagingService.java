package najah.edu;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class MessagingService {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@(.+)$", 
        Pattern.CASE_INSENSITIVE
    );

    // Simulate a simple in-memory message storage
    private Map<String, String> inbox = new HashMap<>();
    private boolean specialRequestReceived = false;

    public boolean sendMessage(String email, String subject, String body) {
        if (isValidEmail(email)) {
            // Simulate sending the message
            System.out.println("Sending message to: " + email);
            System.out.println("Subject: " + subject);
            System.out.println("Body: " + body);
            return true; // Assume the message is sent successfully
        } else {
            System.out.println("Invalid email address: " + email);
            return false; // Email was not sent due to invalid email address
        }
    }

    public String receiveMessage(String sender, String subject) {
        // Simulate receiving a message
        String message = "From: " + sender + ", Subject: " + subject;
        inbox.put(subject, message);
        return message;
    }

    public boolean checkForSpecialRequest() {
        // Simulate checking for a special request
        // In reality, this could involve more complex logic
        specialRequestReceived = true; // For simulation purposes, assume a special request is received
        return specialRequestReceived;
    }

    private boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    // For potential future use
    public char[] viewMessages() {
        // Implementation for viewing messages if needed
        return null;
    }
}
