package najah.edu;

import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.EmailNotification;
import najah.EmailService;
import najah.InboxService;
import najah.Message;
import najah.MessageService;
import najah.SpecialRequest;
import najah.SpecialRequestService;
import najah.Admin; // Assuming there is an Admin class
import najah.ContentManager; // Assuming there is a ContentManager class
import najah.ReportsService; // Assuming there is a ReportsService class
import najah.StoreOwnerManager; // Assuming there is a StoreOwner class
import najah.SupplierManager; // Assuming there is a Supplier class

public class Communication_and_Notification {

    private Admin admin; // Admin instance
    private ContentManager contentManager; // ContentManager instance
    private ReportsService reportsService; // ReportsService instance
    private MessageService messageService; // MessageService instance
    private EmailService emailService; // EmailService instance
    private List<String> reports;
    private InboxService inboxService; // InboxService instance
    private boolean messageSent;
    private boolean messageReceived;
    private boolean emailNotificationReceived;

    @Given("the admin is logged in successfully")
    public void i_am_logged_in_as_an_admin() {
        admin = new Admin("adminUsername", "adminPassword");
        boolean loginSuccessful = admin.login(null, null);
        assertTrue("Admin login should be successful", loginSuccessful);
    }

    @When("I access the content management interface")
    public void i_navigate_to_the_content_management_section() {
        contentManager = new ContentManager(admin);
        assertTrue("Admin should access content management", contentManager != null);
    }

    @Then("I should have the ability to manage recipes and posts")
    public void i_should_be_able_to_view_edit_or_delete_recipes_and_posts() {
        contentManager.viewPosts();
        contentManager.editPost("PostID", "New content");
        contentManager.deletePost("PostID");
        assertTrue("Content management actions should be successful", contentManager.actionsPerformed());
    }

    @When("I enter the user feedback area")
    public void I_enter_the_user_feedback_area() {
        contentManager.navigateFeedbackSection();
        assertTrue("Should access user feedback section", contentManager.feedbackSectionAccessed());
    }

    @Then("I should be able to review and respond to feedback")
    public void i_should_be_able_to_view_review_and_respond_to_user_feedback() {
        contentManager.viewFeedback();
        contentManager.reviewFeedback("FeedbackID", "Response text");
        assertTrue("Feedback actions should be successful", contentManager.feedbackActionsPerformed());
    }

    @When("I navigate to financial reports section")
    public void i_navigate_to_financial_reports_section() {
        reportsService = new ReportsService(admin);
        reports = reportsService.getFinancialReports();
        assertTrue("Should access financial reports", reports != null);
    }

    @When("I check the financial performance reports")
    public void I_check_the_financial_performance_reports() {
        reports = reportsService.getFinancialReports();
        Assert.assertNotNull("Reports should be available", reports);
        assertTrue("Reports should contain financial data", reports.size() > 0);
    }

    @Then("I should find detailed reports on financial performance and profits")
    public void i_should_find_detailed_reports_on_financial_performance_and_profits() {
        reports = reportsService.getFinancialReports();
        Assert.assertNotNull("Detailed financial reports should be available", reports);
        assertTrue("Reports should contain detailed data", reports.size() > 0);
    }

    @When("I request the list of top-selling products")
    public void i_request_to_view_best_selling_products() {
        reports = reportsService.getBestSellingProducts();
        Assert.assertNotNull("Best-selling products report should be available", reports);
        assertTrue("Report should list best-selling products", reports.size() > 0);
    }

    @When("I access the user statistics dashboard")
    public void i_navigate_to_the_user_statistics_section() {
        reportsService = new ReportsService(admin);
        reports = reportsService.getUserStatisticsByCity();
        assertTrue("Should access user statistics", reports != null);
    }

    @Then("I should review statistics on registered users by city such as Nablus and Jenin")
    public void i_should_see_statistics_on_registered_users_by_city_e_g_nablus_jenin() {
        reports = reportsService.getUserStatisticsByCity();
        Assert.assertNotNull("User statistics should be available", reports);
        assertTrue("Statistics should contain data by city", reports.size() > 0);
    }

    @Given("store owner or supplier has logged in")
    public void store_owner_or_supplier_has_logged_in() {
        // This assumes the role is either StoreOwner or Supplier, so you can use appropriate login
    	StoreOwnerManager storeOwner = new StoreOwnerManager("storeOwnerUsername", "storeOwnerPassword");
    	SupplierManager supplier = new SupplierManager("supplierUsername", "supplierPassword");
        boolean loginSuccessful = storeOwner.login(null, null) || supplier.login(null, null);
        assertTrue("Login should be successful", loginSuccessful);
    }

    @When("I write a message to {string} with the subject {string} and the body {string}")
    public void i_wtite_a_message_to( String sender,String recipient, String subject, String body) {
        messageService = new MessageService();
		messageSent = messageService.sendMessage(new Message(  sender,   recipient,   subject,   body));
        assertTrue("Message should be sent successfully", messageSent);
    }

    @Then("message should be sent successfully")
    public void message_should_be_sent_successfully() {
        assertTrue("Message should be sent successfully", messageSent);
    }

    @When("I get a message from {string} with the subject {string}")
    public void i_get_a_message_from(String sender, String subject) {
        inboxService = new InboxService();
        messageReceived = inboxService.receiveMessage(new Message(sender, subject, "", sender)) != null;
        assertTrue("Message should be received successfully", messageReceived);
    }

    @Then("the message should appear in my inbox")
    public void the_message_should_appear_in_my_inbox() {
        assertTrue("Message should be displayed in the inbox", messageReceived);
    }

    @When("I get a special request")
    public void i_get_a_special_request() {
        emailService = new EmailService();
        SpecialRequest specialRequest = new SpecialRequest("Special request details");
        emailNotificationReceived = emailService.sendEmailNotification(specialRequest);
        assertTrue("Email notification should be received", emailNotificationReceived);
    }

    @Then("I should get an email notification with the details of the request")
    public void i_should_get_an_email_notification_with_the_details_of_the_request() {
        assertTrue("Email notification should be received with request details", emailNotificationReceived);
    }
    
    @When("I receive a special request")
    public void i_receive_a_special_request() {
        emailService = new EmailService();
        SpecialRequest specialRequest = new SpecialRequest("Special request details");
        emailNotificationReceived = emailService.receiveSpecialRequest(specialRequest);
        assertTrue("I receive a special request", emailNotificationReceived);
    }

    @Then("I should receive an email notification with the details of the request")
    public void i_should_receive_an_email_notification_with_the_details_of_the_request() {
        assertTrue("Email notification should be received with request details", emailNotificationReceived);
    }

    @When("I send a message to {string} with the subject {string} and the body {string}")
    public void i_send_a_message_to_with_the_subject_and_the_body(String recipient, String subject, String body) {
        messageService = new MessageService();
        messageSent = messageService.sendMessage(new Message("senderUsername", recipient, subject, body));
        assertTrue("Message should be sent successfully", messageSent);
    }

    @Then("the message should be sent successfully")
    public void the_message_should_be_sent_successfully() {
        assertTrue("Message should be sent successfully", messageSent);
    }

    @When("I receive a message from {string} with the subject {string}")
    public void i_receive_a_message_from_with_the_subject(String sender, String subject) {
        inboxService = new InboxService();
        // Receive a message and ensure it's not null
        Message receivedMessage = inboxService.receiveMessage(new Message(sender, "receiverUsername", subject, ""));
        // Check if the received message matches the expected subject
        messageReceived = (receivedMessage != null && receivedMessage.getSubject().equals(subject));
        assertTrue("Message should be received successfully", messageReceived);
    }

    @Then("the message should be displayed in my inbox")
    public void the_message_should_be_displayed_in_my_inbox() {
        assertTrue("Message should be displayed in the inbox", messageReceived);
    }


}
