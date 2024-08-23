package najah.edu.acceptance_tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import najah.edu.UserService;

public class log_out {

    private UserService userService;
    private boolean logoutSuccess;
    private String currentPage;

    public log_out() {
        userService = new UserService();
    }

    @Given("I am logged in")
    public void i_am_logged_in_to_the_system() {
        // Simulate user login
        boolean loginSuccess = userService.signIn("user1", "password1"); // Ensure this matches your mock data
        Assert.assertTrue("Login was not successful", loginSuccess);
    }
    
    @When("I click the 'Log Out' button")
    public void i_click_the_log_out_button() {
        logoutSuccess = userService.logOut(); // Ensure this method is correctly implemented
    }

    @Then("I should be logged out of the system")
    public void i_should_be_logged_out_of_the_system() {
    	Assert.assertTrue("Logout was not successful", logoutSuccess);

        // Additional check to ensure the user is no longer recognized as logged in
        boolean isLoggedIn = userService.isUserLoggedIn("user1");
        Assert.assertFalse("User is still logged in after logout", isLoggedIn);
    }

    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {
        // Assume we have a method to get the current page
        currentPage = userService.getCurrentPage();

    }
}
