package najah.edu;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    // In-memory user store (for demonstration purposes)
    private Map<String, String> userStore = new HashMap<>();
    private String loggedInUser = null;

    private String currentPage;
    private boolean loggedIn;
    public UserService() {
        // Initialize with some mock users (username -> password)
        userStore.put("admin", "adminpass");
        userStore.put("user1", "password1");
        userStore.put("user2", "password2");
        this.currentPage = "loginPage";
        this.loggedIn = false;
    }

    public boolean signIn(String username, String password) {
        if (userStore.containsKey(username) && userStore.get(username).equals(password)) {
            loggedInUser = username;
            loggedIn = true;  // Set loggedIn to true on successful login
            currentPage = "homePage";  // Assuming a default page after login
            System.out.println("User signed in: " + username);
            return true;
        }
        return false;
    }
    public boolean deactivateUser(String userId) {
        // Check if the user exists in the userStore
        if (userStore.containsKey(userId)) {
            // Simulate deactivation by removing the user from the active list
            userStore.remove(userId);
            return true; // Deactivation successful
        }
        return false; // Deactivation failed (user not found)
    }


    public boolean logOut() {
        if (loggedIn) {
            loggedIn = false;
            loggedInUser = null;  // Clear the logged-in user
            currentPage = "loginPage";  // Redirect to login page on logout
            System.out.println("User logged out.");
            return true;
        }
        return false;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public boolean isAuthenticated() {
        // Check if there is a user currently logged in
        return loggedInUser != null;
    }

    public String getLoggedInUser() {
        // Return the currently logged in user
        return loggedInUser;
    }

    public boolean addUser(String username, String password) {
        if (userStore.containsKey(username)) {
            return false; // User already exists
        }
        userStore.put(username, password);
        return true;
    }

    public boolean removeUser(String username) {
        if (!userStore.containsKey(username)) {
            return false; // User doesn't exist
        }
        userStore.remove(username);
        return true;
    }
    public boolean updateAccountDetails(String newUsername, String newPassword) {
        // Check if the user is logged in and exists in the userStore
        if (loggedInUser != null && userStore.containsKey(loggedInUser)) {
            // Update the username and password
            userStore.remove(loggedInUser); // Remove old entry
            userStore.put(newUsername, newPassword); // Add updated entry
            loggedInUser = newUsername; // Update logged in user reference
            return true; // Update successful
        }
        return false; // Update failed
    }



    public char[] viewAccountDetails() {
        if (loggedInUser == null) {
            return null; // No user is logged in
        }

        String accountDetails = "Username: " + loggedInUser + "\nPassword: " + userStore.get(loggedInUser);
        return accountDetails.toCharArray();
    }

}
