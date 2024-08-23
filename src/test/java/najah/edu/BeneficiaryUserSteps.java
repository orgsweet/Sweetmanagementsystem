package najah.edu;

import io.cucumber.java.en.*;
import najah.BeneficiaryUserDashboard; // Ensure you have the correct import
import org.junit.Assert;
import org.junit.Test;

public class BeneficiaryUserSteps {

    private BeneficiaryUserDashboard beneficiaryUserDashboard;
    private boolean isEmailUpdated;
    private boolean isDessertPosted;
    private String feedbackResponse;
    private String userStatistics;

    // Constructor to initialize the objects
    public BeneficiaryUserSteps() {
        beneficiaryUserDashboard = new BeneficiaryUserDashboard();
    }
    
    @Test
    public void testBeneficiaryLogin() {
        BeneficiaryUserDashboard dashboard = new BeneficiaryUserDashboard();
        boolean loginSuccessful = dashboard.login("beneficiaryUsername", "beneficiaryPassword");
        Assert.assertTrue("Beneficiary login failed", loginSuccessful);
    }

    
    public boolean login(String username, String password) {
        // Example logic for login
        if (username.equals("beneficiary") && password.equals("password")) {
            return true; // Assuming successful login
        }
        return false; // Login failed
    }
    
    @When("I update my email to {string}")
    public void i_update_my_email_to(String newEmail) {
        // Update email in the beneficiary user's profile
        isEmailUpdated = beneficiaryUserDashboard.updateEmail(newEmail);
    }

    @Given("the beneficiary user is successfully logged in")
    public void the_beneficiary_user_is_successfully_logged_in() {
        // Simulate login
        boolean loginSuccessful = beneficiaryUserDashboard.login("beneficiaryUsername", "beneficiaryPassword");
        Assert.assertTrue("Beneficiary login failed", loginSuccessful);
    }
    
    
    @When("I post a new dessert creation with the title {string} and description {string}")
    public void i_post_a_new_dessert_creation_with_the_title_and_description(String title, String description) {
        // Set the title and description of the new dessert creation
        beneficiaryUserDashboard.createDessertPost(title, description);
        
        // Upload a dummy image to ensure the dessert post is complete
        beneficiaryUserDashboard.uploadImage("dummyImage.png");
        
        // Post the dessert creation
        isDessertPosted = beneficiaryUserDashboard.postDessert();
        
        // Optionally verify that the dessert was posted successfully
        Assert.assertTrue("Failed to post dessert creation", isDessertPosted);
    }

    
    @When("I upload an image of the cake")
    public void i_upload_an_image_of_the_cake() {
        // Simulate uploading an image of the cake
        boolean imageUploaded = beneficiaryUserDashboard.uploadImage("cakeImage.png");
        
        // Optionally, verify that the image was uploaded successfully
        Assert.assertTrue("Failed to upload image of the cake", imageUploaded);
    }

    
    @Then("my dessert creation should be shared successfully")
    public void my_dessert_creation_should_be_shared_successfully() {
        // Check if the dessert creation was posted
        Assert.assertTrue("Dessert creation was not posted successfully", isDessertPosted);
        
        // Verify that the dessert creation appears in the list of posts
        boolean postExists = beneficiaryUserDashboard.getPosts().stream()
                .anyMatch(post -> post.contains("Delicious Cake") && post.contains("This is my favorite cake"));
        
        Assert.assertTrue("Dessert creation post is missing", postExists);
    }

    @When("I update the email to {string}")
    public void i_update_the_email_to(String newEmail) {
        // Update email in the beneficiary user's profile
        isEmailUpdated = beneficiaryUserDashboard.updateEmail(newEmail);
        Assert.assertTrue("Failed to update email", isEmailUpdated);
    }

    @When("I choose the {string} button")
    public void i_choose_the_button(String buttonName) {
        // Handle clicking different buttons
        if (buttonName.equals("Save")) {
            // Simulate clicking the Save button for email update
            Assert.assertTrue("Failed to save changes", isEmailUpdated);
        } else if (buttonName.equals("Post")) {
            // Simulate clicking the Post button for dessert creation
            Assert.assertTrue("Failed to post dessert creation", isDessertPosted);
        }
    }

    @Then("my account details should updated successfully")
    public void my_account_details_should_updated_successfully() {
        // Verify email update success
        Assert.assertTrue("Email was not updated successfully", isEmailUpdated);
    }

    @When("I post a new dessert creation that has the title {string} and description {string}")
    public void i_post_a_new_dessert_creation_that_has_the_title_and_description(String title, String description) {
        // Post a new dessert creation
        isDessertPosted = beneficiaryUserDashboard.postDessert();
        Assert.assertTrue("Failed to post dessert creation", isDessertPosted);
    }

    @When("I upload an image of the cakes")
    public void i_upload_an_image_of_the_cakes() {
        // Simulate uploading an image
        // Assuming the method returns true if the image upload is successful
        isDessertPosted = beneficiaryUserDashboard.uploadImage("cakeImage.png");
        Assert.assertTrue("Failed to upload image", isDessertPosted);
    }

    @Then("my dessert creation should be shared correctly")
    public void my_dessert_creation_should_be_shared_correctly() {
        // Verify dessert creation share success
        Assert.assertTrue("Dessert creation was not shared successfully", isDessertPosted);
    }

    @When("I navigate to the user feedback")
    public void i_navigate_to_the_user_feedback() {
        // Fetch user feedback
        feedbackResponse = beneficiaryUserDashboard.viewUserFeedback();
        Assert.assertNotNull("Failed to load user feedback", feedbackResponse);
    }

    @Then("I should be able to view, review, and respond to the user feedback")
    public void i_should_be_able_to_view_review_and_respond_to_the_user_feedback() {
        // Simulate reviewing and responding to feedback
        boolean responseSuccess = beneficiaryUserDashboard.respondToFeedback("Feedback1", "Thank you for your feedback!");
        Assert.assertTrue("Failed to respond to feedback", responseSuccess);
    }

    @When("I navigate to the financial reports")
    public void i_navigate_to_the_financial_reports() {
        // Fetch financial reports
        // Assuming there's a method to view financial reports
        String financialReports = beneficiaryUserDashboard.viewFinancialReports();
        Assert.assertNotNull("Failed to load financial reports", financialReports);
    }

    @When("I review the financial performance reports")
    public void I_review_the_financial_performance_reports() {
        // Simulate reviewing the financial performance reports
        // This assumes you have a method to check if reports are reviewed
        boolean reviewSuccess = beneficiaryUserDashboard.reviewFinancialReports();
        Assert.assertTrue("Failed to review financial reports", reviewSuccess);
    }

    @When("I navigate to the user statistics page")
    public void i_navigate_to_the_user_statistics_page() {
        // Fetch user statistics
        userStatistics = beneficiaryUserDashboard.viewUserStatistics();
        Assert.assertNotNull("Failed to load user statistics", userStatistics);
    }

    @Then("I should view statistics on users by city, like Nablus and Jenin")
    public void i_should_see_statistics_on_registered_users_by_city() {
        // Verify user statistics
        Assert.assertTrue("User statistics are missing", userStatistics.contains("Nablus") && userStatistics.contains("Jenin"));
    }
}
