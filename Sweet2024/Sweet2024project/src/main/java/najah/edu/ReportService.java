package najah.edu;

import java.util.HashMap;
import java.util.Map;

public class ReportService {

    private Map<String, Integer> userStatistics;
    private double totalProfit;
    private Map<String, User> userList; // Manage user details
    private Map<String, String> notifications; // Manage notifications for users
    private Map<String, Boolean> userStatus; // Track user activity status

    public ReportService() {
        // Initialize with some mock data
        userStatistics = new HashMap<>();
        userStatistics.put("Nablus", 100);
        userStatistics.put("Jenin", 50);
        userStatistics.put("Ramallah", 70);
        userStatistics.put("Gaza", 120);

        totalProfit = 5000.00;

        // Initialize user list, notifications, and user status
        userList = new HashMap<>();
        notifications = new HashMap<>();
        userStatus = new HashMap<>();
    }

    // Generates a profit report
    public String generateProfitReport() {
        return String.format("Profit Report: Total profit is $%.2f.", totalProfit);
    }

    // Generates user statistics by city
    public Map<String, Integer> generateUserStatisticsByCity() {
        return new HashMap<>(userStatistics);
    }

    // Update user statistics
    public void updateUserStatistics(String city, int count) {
        userStatistics.put(city, count);
    }

    // Set total profit
    public void setTotalProfit(double profit) {
        this.totalProfit = profit;
    }

    // Update business information
    public boolean updateBusinessInformation(String info) {
        // Assume update is successful for this example
        return true;
    }

    // View content
    public boolean viewContent(String contentId) {
        // Assume viewing content is successful
        return true;
    }

    // Edit content
    public boolean editContent(String contentId, String newContent) {
        // Assume editing content is successful
        return true;
    }

    // Delete content
    public boolean deleteContent(String contentId) {
        // Assume deleting content is successful
        return true;
    }

    // Review feedback
    public boolean reviewFeedback(String feedbackId, String response) {
        // Assume feedback review is successful
        return true;
    }

    // Get user list
    public Map<String, User> getUserList() {
        Map<String, User> users = new HashMap<>();
        
        // Example: Add logic to retrieve users from your data source
        users.put("storeOwner1", new User("storeOwner1", "Store Owner", null));
        users.put("supplier1", new User("supplier1", "Raw Material Supplier", null));
        
        return users;
    }


    // Add user
    public boolean addUser(String username, String password, String role) {
        userList.put(username, new User(username, password, role));
        userStatus.put(username, true); // User is active when added
        notifications.put(username, "Account created successfully");
        return true;
    }

    // Check if user was created
    public boolean isUserCreated(String username) {
        return userList.containsKey(username);
    }

    // Update user details
    public boolean updateUserDetails(String username, String newPassword) {
        User user = userList.get(username);
        if (user != null) {
            user.setPassword(newPassword);
            notifications.put(username, "Account details updated successfully");
            return true; // Indicate success
        }
        return false; // Indicate failure
    }

    // Deactivate a user account
    public boolean deactivateUser(String username) {
        if (userStatus.containsKey(username)) {
            userStatus.put(username, false); // Mark user as inactive
            notifications.put(username, "Account deactivated successfully");
            return true;
        }
        return false;
    }

    // Check if user is active
    public boolean isUserActive(String username) {
        return userStatus.getOrDefault(username, false);
    }

    // Check notification
    public boolean checkNotification(String username) {
        return notifications.containsKey(username);
    }

    // Apply dietary needs filter
    public String applyDietaryNeedsFilter(String filter) {
        // Return a mock result
        return "Filtered results for " + filter;
    }

    // Sign up user
    public boolean signUp(String username, String password, String email) {
        // Assume sign-up is successful
        return true;
    }

    // Sign in user
    public boolean signIn(String username, String password) {
        // Assume sign-in is successful
        return true;
    }

    // Update email
    public boolean updateEmail(String newEmail) {
        // Assume email update is successful
        return true;
    }

    // Post dessert creation
    public boolean postDessertCreation(String title, String description) {
        // Assume posting dessert creation is successful
        return true;
    }

    // Upload image
    public boolean uploadImage(String imagePath) {
        // Assume image upload is successful
        return true;
    }

    // Check if dessert is shared
    public boolean isDessertShared(String title) {
        // Assume dessert is shared
        return true;
    }

    // Inner class for User details
    public static class User {
        private String username;
        private String password;
        private String role;

        public User(String username, String password, String role) {
            this.username = username;
            this.password = password;
            this.role = role;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getRole() {
            return role;
        }
    }
}
