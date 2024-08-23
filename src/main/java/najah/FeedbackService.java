package najah;

import java.util.HashMap;
import java.util.Map;

public class FeedbackService {
    
    private Map<String, String> feedbackStorage = new HashMap<>();
    
    public void navigateToFeedbackSection() {
        System.out.println("Navigating to the User Feedback section...");
    }

    public void viewFeedback() {
        if (feedbackStorage.isEmpty()) {
            System.out.println("No feedback available.");
        } else {
            System.out.println("Displaying all feedback:");
            feedbackStorage.forEach((id, feedback) -> System.out.println("Feedback ID: " + id + ", Feedback: " + feedback));
        }
    }

    public void addFeedback(String feedbackId, String feedbackMessage) {
        feedbackStorage.put(feedbackId, feedbackMessage);
        System.out.println("Feedback added: " + feedbackMessage);
    }

    public void respondToFeedback(String feedbackId, String response) {
        if (feedbackStorage.containsKey(feedbackId)) {
            System.out.println("Responding to feedback ID: " + feedbackId);
            System.out.println("Response: " + response);
            // Here, you could extend this to store responses, notify users, etc.
        } else {
            System.out.println("Feedback ID not found.");
        }
    }

    public void deleteFeedback(String feedbackId) {
        if (feedbackStorage.remove(feedbackId) != null) {
            System.out.println("Feedback ID: " + feedbackId + " deleted.");
        } else {
            System.out.println("Feedback ID not found.");
        }
    }
}
