package najah.edu;

import java.util.HashMap;
import java.util.Map;

public class AdminService {

    // Mock data storage
    private Map<String, String> adminCredentials = new HashMap<>();
    private Map<String, User> users = new HashMap<>();

    public AdminService() {
        // Sample data for testing
        adminCredentials.put("ahmad", "123");

        // Pre-populate with some sample users
        users.put("user1", new User("user1", "password1", "storeOwner"));
        users.put("user2", new User("user2", "password2", "supplier"));
    }

    public boolean signIn(String username, String password) {
        // Check if the username and password match
        return password.equals(adminCredentials.get(username));
    }

    public boolean addUser(String username, String password, String role) {
        // Check if the user already exists
        if (users.containsKey(username)) {
            System.out.println("User already exists.");
            return false; // User already exists
        }
        // Add new user
        users.put(username, new User(username, password, role));
        System.out.println("User added: " + username);
        return true; // User added successfully
    }

    public boolean removeUser(String username) {
        // Remove the user if they exist
        if (users.containsKey(username)) {
            users.remove(username);
            System.out.println("User removed: " + username);
            return true; // User removed successfully
        }
        System.out.println("User not found: " + username);
        return false; // User not found
    }

    // Inner User class
    private class User {
        private String username;
        private String password;
        private String role;

        public User(String username, String password, String role) {
            this.username = username;
            this.password = password;
            this.role = role;
        }

        // Getters and setters (if needed)
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
