package najah;

import java.util.ArrayList;

import java.util.List;

public class signUpService {
    private String username;
    private String email;
    private String password;
    private String repeatedPassword;
    private String role;
    private String errorMessage;
    private String successMessage;
    private String emailInUseErrorMessage;

    // Navigate to the sign-up page
    public void navigateToSignUpPage() {
        // Implementation to navigate to the sign-up page, e.g., open a web page or a form
        System.out.println("Navigating to sign-up page...");
    }

    // Setters for sign-up details
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Method to simulate the sign-up process
    public void signUp() {
        // Simulate various sign-up checks
        if (username == null || username.isEmpty()) {
            errorMessage = "Invalid username";
        } else if (email == null || email.isEmpty()) {
            errorMessage = "Email address is required";
        } else if (password == null || password.isEmpty()) {
            errorMessage = "Password is required";
        } else if (!password.equals(repeatedPassword)) {
            errorMessage = "Passwords do not match";
        } else if (role == null || role.isEmpty()) {
            errorMessage = "Role is required";
        } else if (isEmailAlreadyInUse(email)) {
            errorMessage = "Email address is already in use";
        } else if (isRoleInvalid(role)) {
            errorMessage = "Invalid role";
        } else {
            successMessage = "Account created successfully";
        }
    }

    // Helper methods to check validity
    private boolean isEmailAlreadyInUse(String email) {
        // Simulate email check. In a real scenario, this would query a database or service.
        return false; // Adjust this logic based on your application
    }

    private boolean isRoleInvalid(String role) {
        // Simulate role validation. In a real scenario, this would check against valid roles.
        return false; // Adjust this logic based on your application
    }

    // Getters for error and success messages
    public String getInvalidEmailErrorMessage() {
        return errorMessage != null && errorMessage.contains("email") ? errorMessage : "";
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public String getInvalidRoleErrorMessage() {
        return errorMessage != null && errorMessage.contains("role") ? errorMessage : "";
    }

    public String getInvalidUsernameErrorMessage() {
        return errorMessage != null && errorMessage.contains("username") ? errorMessage : "";
    }

 // Confirm the repeated password
    public void confirmPassword(String mismatchedPassword) {
        if (password == null || repeatedPassword == null || !password.equals(repeatedPassword)) {
            errorMessage = "Passwords do not match";
        } else {
            errorMessage = null; // No error if passwords match
        }
    
	}
    
    public String getErrorMessage() {
        return errorMessage;  // This should return the correct error message
    }

    public void checkEmailInUse(String email) {
        // Assume we have a method to check if the email is already in use
        if (isEmailInUse(email)) {
            emailInUseErrorMessage = "The email address is already in use"; // Ensure this message matches the expected one
        }
    }
    public void validatePasswords(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            errorMessage = "passworde do not match please make sure to confirm corectly";
        } else {
            errorMessage = null;  // Clear error if passwords match
        }
    }

 

    private boolean isEmailInUse(String email) {
        // Logic to check if the email is already in use
        return true; // Simulate email in use
    }
    
    public String getPasswordMismatchErrorMessage() {
        // Assuming errorMessage is set when the passwords do not match
        if (errorMessage != null && errorMessage.contains("passworde do not match please make sure to confirm corectly")) {
            return errorMessage;
        }
        return null; // Return null to indicate no message
    }

	 public String getEmailInUseErrorMessage() {
	        return errorMessage != null && errorMessage.contains("Email address is already in use") ? errorMessage : "";
	    }
}
