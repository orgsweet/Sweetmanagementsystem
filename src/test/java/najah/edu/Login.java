package najah.edu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.Admin;
import najah.ContentManager;
import najah.ReportsService;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class Login {
	
	private String login(String username, String password) {
	    if (username.isEmpty() || password.isEmpty()) {
	        return "All fields are required";  // Ensure this message matches the expected message in the feature file
	    }
	    if (!validCredentials(username, password)) {
	        return "Invalid username or password";  // Adjust this as needed for invalid credentials
	    }
	    return null; // No error
	}

    private boolean validCredentials(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	private Admin admin;
    private ContentManager contentManager;
    private ReportsService reportsService;

    @Given("the admin is successfully logged in")
    public void i_am_logged_in_as_an_admin() {
        // Initialize Admin instance with proper credentials
        admin = new Admin("adminUsername", "adminPassword");
        
        // Attempt to log in with the provided credentials
        boolean isLoggedIn = admin.login("adminUsername", "adminPassword");
        
        // Assert that the login was successful
        assertTrue("Admin should be logged in", isLoggedIn);
    }


    @When("I should ne able to access the content management interface")
    public void i_should_be_able_to_access_the_content_management_interface() {
        // Ensure admin is logged in
        assertTrue("Admin should be logged in before accessing content management", admin != null);

        // Initialize ContentManager with the logged-in admin
        contentManager = new ContentManager(admin);

        // Verify that contentManager has been initialized
        assertTrue("ContentManager should be initialized", contentManager != null);
    }


    @Then("I should view, edit, or delete recipes and posts")
    public void i_should_view_edit_or_delete_recipes_and_posts() {
        // Example logic to view, edit or delete posts
        contentManager.viewPosts();
        contentManager.editPost("post1", "Updated Content");
        contentManager.deletePost("post1");

        assertTrue("Admin performed actions on posts", contentManager.actionsPerformed());
    }

    @When("I should access to the user feedback section")
    public void i_should_access_to_the_user_feedback_section() {
        contentManager.navigateFeedbackSection();
    }

    @Then("I should have the ability to view, review, and respond to user feedback")
    public void i_should_have_the_ability_to_view_review_and_respond_to_user_feedback() {
        contentManager.viewFeedback();
        contentManager.reviewFeedback("feedback1", "Thank you for your feedback!");

        assertTrue("Admin performed actions on feedback", contentManager.feedbackActionsPerformed());
    }

    @When("I access  financial performance reports")
    public void i_access_financial_performance_reports() {
        reportsService = new ReportsService(admin);
    }

    @Then("I should view reports on profits and financial performance")
    public void i_should_view_reports_on_profits_and_financial_performance() {
        List<String> financialReports = reportsService.getFinancialReports();
        assertTrue("Financial reports should not be empty", !financialReports.isEmpty());

        // Print the financial reports to the console (for simulation)
        financialReports.forEach(System.out::println);
    }

    @When("I request to see best-selling products")
    public void i_request_to_see_best_selling_products() {
        reportsService = new ReportsService(admin);
    }

    @Then("I should be able to see a report of the best-selling products across all stores")
    public void i_should_be_able_to_see_a_report_of_the_best_selling_products_across_all_stores() {
        List<String> bestSellingProducts = reportsService.getBestSellingProducts();
        assertTrue("Best-selling products report should not be empty", !bestSellingProducts.isEmpty());

        // Print the best-selling products to the console (for simulation)
        bestSellingProducts.forEach(System.out::println);
    }

    @When("I access the user statistics section")
    public void i_access_the_user_statistics_section() {
        reportsService = new ReportsService(admin);
    }

    @Then("I should see statistics on registered users by city (e.g., Nablus, Jenin)")
    public void i_should_see_statistics_on_registered_users_by_city_e_g_nablus_jenin() {
        List<String> userStatistics = reportsService.getUserStatisticsByCity();
        assertTrue("User statistics by city should not be empty", !userStatistics.isEmpty());

        // Print the user statistics to the console (for simulation)
        userStatistics.forEach(System.out::println);
    }
    @When("the user enters an invalid username")
    public void the_user_enters_an_invalid_username() {
        // Write code here that turns the phrase above into concrete actions
    }
}
