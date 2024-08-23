package najah.edu.acceptance_tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import najah.edu.AdminService;

import java.util.List;
import java.util.Map;
import najah.edu.StoreService;


public class user_profile {

    private AdminService adminService;
    private boolean actionSuccess;
    private StoreService storeService;


    // Constructor initializes the AdminService
    public user_profile() {
        adminService = new AdminService();
        storeService = new StoreService();

    }

    // Scenario: Admin login
    @Given("I am logged in as an admin")
    public void i_am_logged_in_as_an_admin() {
        // Simulate admin login with hardcoded credentials
        actionSuccess = adminService.signIn("admin", "adminPassword");
        // Assert that login was successful
    }

    // Scenario: Add a new user
    @When("I add a new user with the following details:")
    public void i_add_a_new_user_with_the_following_details(DataTable dataTable) {
        List<Map<String, String>> users = dataTable.asMaps(String.class, String.class);
        // Iterate through each user entry in the DataTable
        for (Map<String, String> user : users) {
            String username = user.get("username");
            String password = user.get("password");
            String role = user.get("role");
            // Call the service to add the new user
            actionSuccess = adminService.addUser(username, password, role);
        }
        // Assert that the user was added successfully
        Assert.assertTrue("New user should be added successfully.", actionSuccess);
    }

    // Scenario: Verify new user addition
    @Then("the new user should be added successfully")
    public void the_new_user_should_be_added_successfully() {
        // Assert that the previous action was successful
        Assert.assertTrue("The new user should be added successfully.", actionSuccess);
    }
    
    // Scenario: Remove a user
    @When("I remove the user {string}")
    public void i_remove_the_user(String username) {
        // Call the service to remove the user
        actionSuccess = adminService.removeUser(username);
    }

    // Scenario: Verify user removal
    @Then("the user should be removed successfully")
    public void the_user_should_be_removed_successfully() {
        // Assert that the previous action was successful
        Assert.assertTrue("The user should be removed successfully.", actionSuccess);
    }
}
