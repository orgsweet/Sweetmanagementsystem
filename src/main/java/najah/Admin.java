package najah;

public class Admin {
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
            System.out.println("Admin logged in successfully!");
            return true;
        } else {
            this.isLoggedIn = false;
            System.out.println("Login failed. Incorrect username or password.");
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
            System.out.println("Admin logged out successfully.");
        } else {
            System.out.println("Admin is not logged in.");
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
            System.out.println("Password changed successfully.");
            return true;
        } else {
            System.out.println("Password change failed. Old password is incorrect.");
            return false;
        }
    }

    // Method to reset the password if an admin forgets it
    public boolean resetPassword(String username, String secretAnswer, String newPassword) {
        String expectedSecretAnswer = "adminSecretAnswer"; // Placeholder for the secret answer

        if (this.username.equals(username) && secretAnswer.equals(expectedSecretAnswer)) {
            this.password = newPassword;
            System.out.println("Password reset successfully.");
            return true;
        } else {
            System.out.println("Password reset failed. Username or secret answer is incorrect.");
            return false;
        }
    }

    // Method to perform admin-specific actions (Example: deleting a user)
    public boolean deleteUser(User user) {
        if (this.isLoggedIn) {
            // Simulate deletion of a user
            System.out.println("User " + user.getUsername() + " has been deleted.");
            // Assuming successful deletion
            return true;
        } else {
            System.out.println("Admin must be logged in to delete users.");
            return false;
        }
    }

    // Method to view system logs (Example for an admin)
    public void viewSystemLogs() {
        if (this.isLoggedIn) {
            // Simulate log retrieval
            System.out.println("Displaying system logs...");
            // Logs might be printed, saved to a file, or otherwise displayed.
        } else {
            System.out.println("Admin must be logged in to view system logs.");
        }
    }
}
