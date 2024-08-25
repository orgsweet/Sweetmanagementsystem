import java.util.logging.Logger;
import java.util.logging.Level;

public class Admin {
    private static final Logger logger = Logger.getLogger(Admin.class.getName());
    
    private String username;
    private String password;
    private boolean isLoggedIn;

    // Constructor
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        this.isLoggedIn = false;
    }

    // Method to simulate admin login
    public boolean login(String username, String password) {
        if (authenticate(username, password)) {
            this.username = username;
            this.password = password;
            this.isLoggedIn = true;
            logger.info("Admin logged in successfully!");
            return true;
        } else {
            this.isLoggedIn = false;
            logger.warning("Login failed. Incorrect username or password.");
            return false;
        }
    }

    // Method to check if admin is logged in
    public boolean isLoggedIn() {
        return this.isLoggedIn;
    }

    // Method to log out the admin
    public void logout() {
        if (this.isLoggedIn) {
            this.isLoggedIn = false;
            logger.info("Admin logged out successfully.");
        } else {
            logger.warning("Admin is not logged in.");
        }
    }

    // Getters for username and password
    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    // Method to authenticate credentials
    boolean authenticate(String username, String password) {
        // Authenticating against hardcoded admin credentials
        return "adminUsername".equals(username) && "adminPassword".equals(password);
    }

    // Method to change admin password
    public boolean changePassword(String oldPassword, String newPassword) {
        if (authenticate(this.username, oldPassword)) {
            this.password = newPassword;
            logger.info("Password changed successfully.");
            return true;
        } else {
            logger.warning("Password change failed. Old password is incorrect.");
            return false;
        }
    }

    // Method to reset the password if an admin forgets it
    public boolean resetPassword(String username, String secretAnswer, String newPassword) {
        String expectedSecretAnswer = "adminSecretAnswer"; // Placeholder for the secret answer

        if (this.username.equals(username) && secretAnswer.equals(expectedSecretAnswer)) {
            this.password = newPassword;
            logger.info("Password reset successfully.");
            return true;
        } else {
            logger.warning("Password reset failed. Username or secret answer is incorrect.");
            return false;
        }
    }

    // Method to perform admin-specific actions (Example: deleting a user)
    public boolean deleteUser(User user) {
        if (this.isLoggedIn) {
            // Simulate deletion of a user
            logger.info("User " + user.getUsername() + " has been deleted.");
            // Assuming successful deletion
            return true;
        } else {
            logger.warning("Admin must be logged in to delete users.");
            return false;
        }
    }

    // Method to view system logs (Example for an admin)
    public void viewSystemLogs() {
        if (this.isLoggedIn) {
            // Simulate log retrieval
            logger.info("Displaying system logs...");
            // Logs might be printed, saved to a file, or otherwise displayed.
        } else {
            logger.warning("Admin must be logged in to view system logs.");
        }
    }
}
