package najah.edu.acceptance_tests;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import najah.edu.MessagingService;

public class comm_not {

    private MessagingService messagingService = new MessagingService();
    private boolean messageSent = false;
    private boolean messageReceived = false;
    private String receivedMessage = null;
    private boolean notificationReceived = false;

    @When("I send a message to {string} with the subject {string} and the body {string}")
    public void i_send_a_message_to_with_the_subject_and_the_body(String email, String subject, String body) {
        messageSent = messagingService.sendMessage(email, subject, body);
    }

    @Then("the message should be sent successfully")
    public void the_message_should_be_sent_successfully() {
        Assert.assertTrue("Message was not sent successfully", messageSent);
    }

    @When("I receive a message from {string} with the subject {string}")
    public void i_receive_a_message_from_with_the_subject(String sender, String subject) {
        // Simulating message reception
        receivedMessage = messagingService.receiveMessage(sender, subject);
        messageReceived = (receivedMessage != null);
    }

    @Then("the message should be displayed in my inbox")
    public void the_message_should_be_displayed_in_my_inbox() {
        Assert.assertTrue("No message received", messageReceived);
        Assert.assertNotNull("No message content", receivedMessage);
        Assert.assertTrue("Message not displayed correctly", receivedMessage.contains("From:") && receivedMessage.contains("Subject:"));
    }

    @When("I receive a special request")
    public void i_receive_a_special_request() {
        // Simulating receiving a special request
        notificationReceived = messagingService.checkForSpecialRequest();
    }

    @Then("I should receive an email notification with the details of the request")
    public void i_should_receive_an_email_notification_with_the_details_of_the_request() {
        Assert.assertTrue("No notification received", notificationReceived);
    }
}
