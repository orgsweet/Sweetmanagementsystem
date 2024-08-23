package najah;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


    

public class User {
    private String id;
    private String info;
    private String username; // Field to store the username
    private String email;    // Field to store the email
    private String password; // Field to store the password
    private String role;     // Field to store the role
	private Collection<User> users;
	private String status;
	private String notes;

    // List to simulate database of users
    private static List<User> userList = new ArrayList<>();

    public User(String username, String email, String password, String role, String status, String notes) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
        this.notes = notes;
    }

    // Getters and setters for fields
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getEmail() {
        return email; // Return the email field
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{id='" + id + "', username='" + username + "', info='" + info + "', email='" + email + "', role='" + role + "'}";
    }

    // Static methods for managing users
    public static List<User> getAllUsers() {
        return new ArrayList<>(userList); // Return a copy to avoid external modification
    }

    public static User getUser(String username) {
        Optional<User> userOptional = userList.stream()
                                              .filter(user -> user.getUsername().equals(username))
                                              .findFirst();
        return userOptional.orElse(null); // Return null if user not found
    }

    public static boolean createUser(User newUser) {
        if (newUser != null && getUser(newUser.getUsername()) == null) {
            userList.add(newUser);
            return true;
        }
        return false; // User already exists or newUser is null
    }

    public static boolean updateUser(User updatedUser) {
        if (updatedUser != null && userList != null) {
            Optional<User> userOptional = userList.stream()
                                                  .filter(user -> user.getUsername().equalsIgnoreCase(updatedUser.getUsername()))
                                                  .findFirst();

            if (userOptional.isPresent()) {
                User existingUser = userOptional.get();
                existingUser.setInfo(updatedUser.getInfo());
                existingUser.setEmail(updatedUser.getEmail());
                existingUser.setPassword(updatedUser.getPassword());
                existingUser.setRole(updatedUser.getRole());
                
                // Optional: Add verification after setting the properties
                if (existingUser.getEmail().equals(updatedUser.getEmail()) && 
                    existingUser.getPassword().equals(updatedUser.getPassword()) && 
                    existingUser.getRole().equals(updatedUser.getRole())) {
                    return true;
                }
            }
        }
        return false; // User not found, userList is null, or updatedUser is null
    }

    public static boolean remove(String username) {
        return userList.removeIf(user -> user.getUsername().equals(username));
    }

    public static User selectUser(String username) {
        return getUser(username); // Simply return the user if found
    }

    public boolean updateUser1(User selectedUser) {
        // Check if the selectedUser is not null and has an ID
        if (selectedUser != null && selectedUser.getId() != null) {
            // Find the existing user with the same ID
            Optional<User> existingUserOptional = users.stream()
                                                      .filter(user -> user.getId().equals(selectedUser.getId()))
                                                      .findFirst();

            if (existingUserOptional.isPresent()) {
                // Update the existing user's details
                User existingUser = existingUserOptional.get();
                existingUser.setUsername(selectedUser.getUsername());
                existingUser.setEmail(selectedUser.getEmail());
              
                // Add other fields as needed

                System.out.println("User updated: " + existingUser);
                return true; // Return true to indicate the update was successful
            } else {
                System.out.println("User with ID " + selectedUser.getId() + " not found.");
            }
        } else {
            System.out.println("Invalid user data provided.");
        }

        return false; // Return false to indicate the update was not successful
    }

	private Object getPhone() {
		// TODO Auto-generated method stub
		return null;
	}

}
