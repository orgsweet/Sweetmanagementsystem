package najah.edu.acceptance_tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import najah.edu.FeedbackService;

public class communication {

    private FeedbackService feedbackService;
    private boolean feedbackSubmitted;

    @Given("I am logged in as a beneficiary user")
    public void i_am_logged_in_as_a_beneficiary_user() {
        // Initialize the services
        feedbackService = new FeedbackService();
        feedbackService.loginUser("beneficiaryUser", "password");
    }

    @When("I provide feedback on a purchased product with the rating {string} and the comment {string}")
    public void i_provide_feedback_on_a_purchased_product_with_the_rating_and_the_comment(String rating, String comment) {
        // Validate input if necessary
        if (rating == null || comment == null || rating.isEmpty() || comment.isEmpty()) {
            feedbackSubmitted = false;
        } else {
            feedbackSubmitted = feedbackService.submitFeedback(rating, comment);
        }
    }

    @Then("my feedback should be submitted successfully")
    public void my_feedback_should_be_submitted_successfully() {

    }
}
