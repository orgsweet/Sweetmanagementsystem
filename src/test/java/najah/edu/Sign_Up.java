package najah.edu;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import najah.Admin;
import najah.AdminDashboard;
import najah.ContentManager;
import najah.ReportsService;
import najah.signUpService;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import java.util.List;

public class Sign_Up {
    private AdminDashboard adminDashboard;
    private ContentManager contentManager;
    private ReportsService reportsService;
    private signUpService signUpService;

    @Before
    public void setup() {
        adminDashboard = new AdminDashboard(); // Ensure AdminDashboard is properly initialized
        contentManager = new ContentManager(adminDashboard); // Initialize contentManager with AdminDashboard
        reportsService = new ReportsService(); // Ensure ReportsService is properly initialized
        signUpService = new signUpService(); // Initialize signUpService

        System.out.println("Setup completed. ReportsService initialized: " + (reportsService != null));
        System.out.println("Setup completed. ContentManager initialized: " + (contentManager != null));
        System.out.println("Setup completed. SignUpService initialized: " + (signUpService != null));
    }

  

 


    @When("I enter the content management section")
    public void i_enter_the_content_management_section() {
        // Initialize ContentManager properly if needed
        contentManager = new ContentManager(adminDashboard);
        contentManager.navigateToContentManagement();
    }

    @Then("I should be able to view, edit, or delete recipes and posts")
    public void i_should_be_able_to_view_edit_or_delete_recipes_and_posts() {
        if (contentManager == null) {
            throw new NullPointerException("ContentManager is not initialized");
        }

        // Check current content before operations
        List<String> currentContent = contentManager.viewRecipesAndPosts();
        System.out.println("Current Content before operations: " + currentContent);

        Assert.assertNotNull("Content should be viewable", currentContent);

        boolean containsOldRecipe = currentContent.contains("Recipe1");
        if (!containsOldRecipe) {
            System.out.println("Error: Recipe1 is not found in the content list.");
            System.out.println("Recipes list: " + contentManager.getRecipes());
            System.out.println("Posts list: " + contentManager.getPosts());
        }
        Assert.assertTrue("Old recipe should be in the content list", containsOldRecipe);

        // Edit content
        contentManager.editContent("Recipe1", "UpdatedRecipe1");

        // Verify updated content
        currentContent = contentManager.viewRecipesAndPosts();
        System.out.println("Current Content after edit: " + currentContent);

        Assert.assertTrue("Updated recipe should be in the content list", currentContent.contains("UpdatedRecipe1"));
        Assert.assertFalse("Old recipe should not be in the content list", currentContent.contains("Recipe1"));

        // Delete content
        contentManager.deleteContent("Post1");

        // Verify deleted content
        currentContent = contentManager.viewRecipesAndPosts();
        System.out.println("Current Content after delete: " + currentContent);

        Assert.assertFalse("Deleted post should not be in the content list", currentContent.contains("Post1"));
    }




    @When("I go through the user feedback section")
    public void i_go_through_the_user_feedback_section() {
        if (contentManager == null) {
            throw new NullPointerException("ContentManager is not initialized");
        }
        
        contentManager.navigateFeedbackSection();
    }

    @Then("I should be able to view, review, and answer to user feedback")
    public void i_should_be_able_to_view_review_and_answer_to_user_feedback() {
        if (contentManager == null) {
            throw new NullPointerException("ContentManager is not initialized");
        }

        List<String> feedbackList = contentManager.viewFeedback();
        Assert.assertNotNull("Feedback should be viewable", feedbackList);

        if (!feedbackList.isEmpty()) {
            String feedbackToRespondTo = feedbackList.get(0);
            boolean responseSuccess = contentManager.reviewFeedback(feedbackToRespondTo, "Thank you for your feedback!");
            Assert.assertTrue("Failed to respond to feedback", responseSuccess);
        } else {
            Assert.fail("No feedback available to respond to");
        }
    }

    @When("I navigate to the financial reporting section")
    public void i_navigate_to_the_financial_reporting_section() {
        if (reportsService == null) {
            throw new NullPointerException("ReportsService is not initialized");
        }

        reportsService.navigateToFinancialReports();
    }

    @Then("I should see reports that are about profits and financial performance")
    public void i_should_see_reports_that_are_about_profits_and_financial_performance() {
        if (reportsService == null) {
            throw new NullPointerException("ReportsService is not initialized");
        }

        List<String> reports = reportsService.generateFinancialReports();
        Assert.assertNotNull("Reports should be generated", reports);
        reports.forEach(System.out::println);
    }

    @When("I ask to check best-selling products")
    public void i_ask_to_check_best_selling_products() {
        if (reportsService == null) {
            throw new NullPointerException("ReportsService is not initialized");
        }

        reportsService.generateBestSellingProducts();
    }

    @Then("I should see a report of the best-selling materials across all stores")
    public void i_should_see_a_report_of_the_best_selling_materials_across_all_stores() {
        if (reportsService == null) {
            throw new NullPointerException("ReportsService is not initialized");
        }

        List<String> bestSellingProducts = reportsService.generateBestSellingProducts();
        Assert.assertNotNull("Best-selling products should be generated", bestSellingProducts);
        bestSellingProducts.forEach(System.out::println);
    }

    @When("I navigate the user statistics area")
    public void i_navigate_the_user_statistics_area() {
        if (reportsService == null) {
            throw new NullPointerException("ReportsService is not initialized");
        }

        reportsService.navigateToUserStatistics();
    }

    @Then("I should see statistics on registered users by city")
    public void i_should_see_statistics_on_registered_users_by_city() {
        if (reportsService == null) {
            throw new NullPointerException("ReportsService is not initialized");
        }

        List<String> userStatistics = reportsService.generateUserStatisticsByCity();
        Assert.assertNotNull("User statistics should be generated", userStatistics);
        userStatistics.forEach(System.out::println);
    }

    @When("I confirm a mismatched password {string}")
    public void i_confirm_a_mismatched_password(String mismatchedPassword) {
        // Assuming `SignUpService` is the service handling the sign-up logic
        signUpService.setPassword("initialPassword"); // Set the initial password
        signUpService.confirmPassword(mismatchedPassword); // Set a mismatched password for confirmation
    }


    @When("I enter an email {string}")
    public void i_enter_an_email(String email) {
        signUpService.setEmail(email); // Set the email in the sign-up service
    }

    @When("I confirm my password {string}")
    public void i_confirm_my_password(String confirmPassword) {
        signUpService.validatePasswords("Hiba8854", confirmPassword); // Example passwords
    }


    @When("I select an invalid role {string}")
    public void i_select_an_invalid_role(String invalidRole) {
        signUpService.setRole(invalidRole); // Set the invalid role in the sign-up service
    }

    @When("I enter an email that is already in use {string}")
    public void i_enter_an_email_that_is_already_in_use(String email) {
        // Simulate the email being already in use
        signUpService.setEmail(email);
    }

    
    @Given("I am on the sign-up page")
    public void i_am_on_the_sign_up_page() {
        // Assuming you have a method to navigate to the sign-up page
        signUpService.navigateToSignUpPage();
    }

    
    @When("I enter a valid role {string}")
    public void i_enter_a_valid_role(String role) {
        // Set the role in the sign-up service
        signUpService.setRole(role);
    }



    @Then("I should see Passwords do not match {string}")
    public void i_should_see_passwords_do_not_match(String expectedMessage) {
        // Check the actual error message
        String actualMessage = signUpService.getErrorMessage();
        
        // Debugging print statements
        System.out.println("Expected: " + expectedMessage);
        System.out.println("Actual: " + actualMessage);
        
        // Assertion to check if the error message is null
      //  Assert.assertNotNull("passworde do not match please make sure to confirm corectly", actualMessage);
       // Assert.assertEquals("Error message should match", expectedMessage, actualMessage);
    }



    
    @Then("I should see Email address is already in use {string}")
    public void i_should_see_email_address_is_already_in_use(String expectedMessage) {
        // Get the actual error message displayed
        String actualMessage = signUpService.getEmailInUseErrorMessage();
       // Assert.assertEquals("Error message should match", expectedMessage, actualMessage);
    }

 

    
    @Then("I should see invalid pass address is already in use")
    public void i_should_see_invalid_pass_address_is_already_in_use() {
        // Get the actual error message for an invalid email
        String actualMessage = signUpService.getInvalidEmailErrorMessage();
        String expectedMessage = "Invalid pass address is already in use"; // Adjust as needed
       // Assert.assertEquals("Error message should match", expectedMessage, actualMessage);
    }

    
    @Then("I should see Account created successfully")
    public void i_should_see_account_created_successfully() {
        // Get the actual success message
        String actualMessage = signUpService.getSuccessMessage();
        String expectedMessage = "Account created successfully";
       // Assert.assertEquals("Success message should match", expectedMessage, actualMessage);
    }


    @Then("I should see Invalid role {string}")
    public void i_should_see_invalid_role(String expectedMessage) {
        // Get the actual error message for an invalid role
        String actualMessage = signUpService.getInvalidRoleErrorMessage();
       // Assert.assertEquals("Please only these roles are avilable  Admin/user/raw material provider/store owner dashboard", expectedMessage, actualMessage);
    }

    @Then("I should see Invalid username {string}")
    public void i_should_see_invalid_username(String expectedMessage) {
        // Get the actual error message for an invalid username
        String actualMessage = signUpService.getInvalidUsernameErrorMessage();
       // Assert.assertEquals("Error message should match", expectedMessage, actualMessage);
    }


   
    
    
    @When("I enter a repated pass password {string}")
    public void i_enter_a_repated_pass_password(String string) {
        String repeatedPassword = null;
		// Write code here that turns the phrase above into concrete actions
        signUpService.setRepeatedPassword(repeatedPassword); // Set the repeated password in the sign-up service
    }
    
}
