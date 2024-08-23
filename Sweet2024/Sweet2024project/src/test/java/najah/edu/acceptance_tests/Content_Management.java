package najah.edu.acceptance_tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import najah.edu.ContentService;

public class Content_Management {

    private ContentService contentService;
    private boolean actionSuccess;
    private String contentId; // To simulate content ID for review

    public Content_Management() {
        contentService = new ContentService();
    }

    @Given("I am logged in as an admin or moderator")
    public void i_am_logged_in_as_an_admin_or_moderator() {
        boolean loggedIn = contentService.signIn("admin", "adminPassword");
        Assert.assertTrue("Admin or moderator login failed", loggedIn);
    }


    @When("I review the shared content with ID {string}")
    public void i_review_the_shared_content(String contentId) {
        // Simulate reviewing content with specific content ID
        this.contentId = contentId; // Store the content ID for use in assertions
        actionSuccess = contentService.reviewContent(contentId, true); // Simulating review action
    }

    @Then("I should be able to approve or remove inappropriate content")
    public void i_should_be_able_to_approve_or_remove_inappropriate_content() {
        Assert.assertTrue("Failed to approve or remove content", actionSuccess);
    }

    // Scenario: Remove User Feedback
    @When("I remove the feedback with ID {string}")
    public void i_remove_the_feedback_with_id(String feedbackId) {
        actionSuccess = contentService.removeFeedback(feedbackId);
    }

    @Then("the feedback should be removed successfully")
    public void the_feedback_should_be_removed_successfully() {
        Assert.assertTrue("Feedback was not removed successfully", actionSuccess);
    }
}
