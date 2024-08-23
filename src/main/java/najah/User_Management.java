package najah;


import java.util.HashMap;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class User_Management {

    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private String role;
    private String errorMessage;

    private Map<String, String> users = new HashMap<>();
    private Map<String, String> notifications = new HashMap<>();
    private boolean isAdminLoggedIn = false;

    @Given("the admin is successfully logged in")
    public void the_admin_is_successfully_logged_in() {
        isAdminLoggedIn = true;
    }

    @When("I navigate to the user management section")
    public void i_navigate_to_the_user_management_section() {
        if (!isAdminLoggedIn) {
            errorMessage = "Admin not logged in";
        }
    }

    @Then("I should see a list of all user accounts including store owners and raw material suppliers")
    public void i_should_see_a_list_of_all_user_accounts_including_store_owners_and_raw_material_suppliers() {
        if (isAdminLoggedIn) {
            for (Map.Entry<String, String> entry : users.entrySet()) {
                System.out.println("User: " + entry.getKey() + ", Role: " + entry.getValue());
            }
        } else {
            errorMessage = "Admin not logged in";
        }
    }

    @When("I choose to add a new user account")
    public void i_choose_to_add_a_new_user_account() {
        if (!isAdminLoggedIn) {
            errorMessage = "Admin not logged in";
        }
    }

    @When("provide the required details for the new user")
    public void provide_the_required_details_for_the_new_user() {
        if (username != null && email != null && password != null && confirmPassword != null && role != null) {
            if (password.equals(confirmPassword)) {
                users.put(username, role);
                notifications.put(username, "Account created with email: " + email);
            } else {
                errorMessage = "Passwords do not match";
            }
        } else {
            errorMessage = "Missing required details";
        }
    }

    @Then("the new user account should be created")
    public void the_new_user_account_should_be_created() {
        if (users.containsKey(username)) {
            System.out.println("User " + username + " created successfully.");
        } else {
            errorMessage = "User account creation failed";
        }
    }

    @Then("the user should receive a notification with account details")
    public void the_user_should_receive_a_notification_with_account_details() {
        String notification = notifications.get(username);
        if (notification != null) {
            System.out.println(notification);
        } else {
            errorMessage = "Notification sending failed";
        }
    }

    @When("I select a user account to update")
    public void i_select_a_user_account_to_update() {
        if (!users.containsKey(username)) {
            errorMessage = "User not found";
        }
    }

    @When("modify the user's details")
    public void modify_the_user_s_details() {
        if (users.containsKey(username)) {
            users.put(username, role);  // Modify the role, or other details as necessary
        } else {
            errorMessage = "User not found";
        }
    }

    @Then("the changes should be saved")
    public void the_changes_should_be_saved() {
        if (users.containsKey(username)) {
            System.out.println("Changes saved for user: " + username);
        } else {
            errorMessage = "Failed to save changes";
        }
    }

    @Then("the user should be notified of the updates")
    public void the_user_should_be_notified_of_the_updates() {
        if (users.containsKey(username)) {
            notifications.put(username, "Your account has been updated.");
        } else {
            errorMessage = "Failed to send update notification";
        }
    }

    @When("I choose to deactivate a user account")
    public void i_choose_to_deactivate_a_user_account() {
        if (users.containsKey(username)) {
            users.remove(username);
            notifications.put(username, "Your account has been deactivated.");
        } else {
            errorMessage = "User not found";
        }
    }

    @Then("the user account should be deactivated")
    public void the_user_account_should_be_deactivated() {
        if (!users.containsKey(username)) {
            System.out.println("User account deactivated: " + username);
        } else {
            errorMessage = "Failed to deactivate account";
        }
    }

    @Then("the user should be notified of the deactivation")
    public void the_user_should_be_notified_of_the_deactivation() {
        String notification = notifications.get(username);
        if (notification != null && notification.contains("deactivated")) {
            System.out.println(notification);
        } else {
            errorMessage = "Failed to send deactivation notification";
        }
    }
}
