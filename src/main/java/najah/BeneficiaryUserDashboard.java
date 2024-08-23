package najah;

import java.util.ArrayList;
import java.util.List;

public class BeneficiaryUserDashboard {
    private String email;
    private String dessertTitle;
    private String dessertDescription;
    private String dessertImage;
    private boolean isEmailUpdated;
    private boolean isDessertPosted;
    private List<String> posts; // List to manage posts
    private List<String> feedback; // List to manage feedback

    public BeneficiaryUserDashboard() {
        // Initialize lists
        posts = new ArrayList<>();
        feedback = new ArrayList<>();
    }

    // Update the email address
    public boolean updateEmail(String newEmail) {
        if (newEmail == null || newEmail.isEmpty()) {
            return false; // Ensure email is not null or empty
        }
        this.email = newEmail;
        this.isEmailUpdated = true;
        return this.isEmailUpdated;
    }

    // Save account details
    public boolean saveAccountDetails() {
        // Simulate saving account details
        return isEmailUpdated;
    }

    // Create a new dessert post
    public void createDessertPost(String title, String description) {
        this.dessertTitle = title;
        this.dessertDescription = description;
    }

    // Upload an image for the dessert
    public boolean uploadImage(String image) {
        this.dessertImage = image;
        return true; // Assuming image upload is successful
    }

    // Post the dessert creation
    public boolean postDessert() {
        if (dessertTitle != null && dessertDescription != null && dessertImage != null) {
            this.isDessertPosted = true;
            // Add the post to the list of posts
            posts.add(dessertTitle + ": " + dessertDescription);
        }
        return this.isDessertPosted;
    }

    // Access content management section
    public void accessContentManagement() {
        System.out.println("Accessing content management...");
        // Placeholder for further content management actions
    }

    // View all posts
    public List<String> viewMyPosts() {
        return new ArrayList<>(posts);
    }

    // Simulate login process
    public boolean login(String username, String password) {
        return "beneficiaryUsername".equals(username) && "beneficiaryPassword".equals(password);
    }

    // Delete a specific post
    public void deletePost(String postTitle) {
        posts.removeIf(post -> post.startsWith(postTitle));
    }

    // Edit a specific post
    public void editPost(String oldTitle, String newTitle) {
        for (int i = 0; i < posts.size(); i++) {
            String post = posts.get(i);
            if (post.startsWith(oldTitle)) {
                posts.set(i, post.replaceFirst(oldTitle, newTitle));
                break;
            }
        }
    }

    // Navigate to feedback section
    public void navigateToFeedbackSection() {
        System.out.println("Navigating to feedback section...");
        // Placeholder for further actions in the feedback section
    }

    // View received feedback
    public List<String> viewReceivedFeedback() {
        return new ArrayList<>(feedback);
    }

    // Respond to a specific feedback
    public boolean respondToFeedback(String feedbackID, String response) {
        for (int i = 0; i < feedback.size(); i++) {
            if (feedback.get(i).contains(feedbackID)) {
                feedback.set(i, feedback.get(i) + " - Response: " + response);
                System.out.println("Responded to feedback: " + feedbackID);
                return true;
            }
        }
        System.out.println("Feedback not found: " + feedbackID);
        return false;
    }

    // Check if feedback section is accessible
    public boolean isFeedbackSectionAccessible() {
        return !feedback.isEmpty(); // Accessible if there is feedback to view
    }

    // Get the list of posts
    public List<String> getPosts() {
        return new ArrayList<>(posts);
    }

    // Review financial reports (Note: May not be relevant for Beneficiary User)
    public boolean reviewFinancialReports() {
        System.out.println("Reviewing financial reports...");
        return true; // Placeholder, assuming the review is always successful
    }

    // View user statistics (Note: May not be relevant for Beneficiary User)
    public String viewUserStatistics() {
        return "Total users: 100, Active users: 50";
    }

    // View financial reports (Note: May not be relevant for Beneficiary User)
    public String viewFinancialReports() {
        return "Profit: $5,000, Loss: $500";
    }

    // View user feedback (Note: May not be relevant for Beneficiary User)
    public String viewUserFeedback() {
        return String.join("\n", feedback);
    }
}
