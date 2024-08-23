package najah.edu;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import najah.ContentManager;
import najah.ReportsService;
import najah.Admin;

import java.util.List;

public class Role_Management {
    private Admin admin;
    private ContentManager contentManager;
    private ReportsService reportsService;
    
    @Given("I am currently logged in as an admin")
    public void I_am_currently_logged_in_as_an_admin() {
        // Create an admin instance and log in
        admin = new Admin("adminUsername", "adminPassword");
        boolean loggedIn = admin.login("adminUsername", "adminPassword");
        if (!loggedIn) {
            throw new RuntimeException("Admin login failed");
        }
        // Initialize ContentManager and ReportsService
        contentManager = new ContentManager(admin);
        reportsService = new ReportsService(admin);
    }

    @When("I enter to the content management section")
    public void i_enter_to_the_content_management_section() {
        // Simulate navigating to content management
        contentManager.navigateToContentManagement();
    }

    @Then("I should be able to view, fix, or delete recipes and posts")
    public void i_should_be_able_to_view_fix_or_delete_recipes_and_posts() {
        // View, edit, and delete posts
        contentManager.viewPosts();
        contentManager.editContent("postId", "New Content");
        contentManager.deleteContent("postId");
    }

    @When("I navigate to the section of user feedback ")
    public void i_navigate_to_the_section_of_user_feedback() {
        // Simulate navigating to user feedback section
        contentManager.navigateFeedbackSection();
    }

    @Then("I should be able to view, check, and respond to user feedback")
    public void i_should_be_able_to_view_check_and_respond_to_user_feedback() {
        // View and review feedback
        contentManager.viewFeedback();
        contentManager.reviewFeedback("feedbackId", "Response to feedback");
    }

    @When("I navigate to the section of financial reports =")
    public void i_navigate_to_the_section_of_financial_reports() {
        // Simulate navigating to financial reports section
        reportsService.navigateToFinancialReports();
    }

    @Then("I should see all reports that are about profits and financial performance")
    public void i_should_see_all_reports_that_are_about_profits_and_financial_performance() {
        // Generate and display financial reports
        List<String> reports = reportsService.generateFinancialReports();
        reports.forEach(System.out::println);
    }

    @When("I ask to see best-selling products")
    public void i_ask_to_see_best_selling_products() {
        // Simulate requesting best-selling products
        reportsService.generateBestSellingProducts();
    }

    @Then("I should see report of the best-selling products across all stores")
    public void i_should_see_report_of_the_best_selling_products_across_all_stores() {
        // Get and display best-selling products report
        List<String> bestSellingProducts = reportsService.generateBestSellingProducts();
        bestSellingProducts.forEach(System.out::println);
    }

    @When("I navigate to the section of user statistics ")
    public void i_navigate_to_the_section_of_user_statistics() {
        // Simulate navigating to user statistics section
        reportsService.navigateToUserStatistics();
    }

    @Then("I should see statistics of registered users by city \\(e.g., Nablus, Jenin)")
    public void i_should_see_statistics_of_registered_users_by_city_e_g_nablus_jenin() {
        // Get and display user statistics by city
        List<String> userStatistics = reportsService.generateUserStatisticsByCity();
        userStatistics.forEach(System.out::println);
    }
    
    @Given("the user is on the Role Selection page")
    public void the_user_is_on_the_role_selection_page() {
        // Write code here that turns the phrase above into concrete actions
    }
    @When("the user clicks the {string} button")
    public void the_user_clicks_the_button(String string) {
        // Write code here that turns the phrase above into concrete actions
    }
    @Then("the user should be redirected to the Admin Dashboard")
    public void the_user_should_be_redirected_to_the_admin_dashboard() {
        // Write code here that turns the phrase above into concrete actions
    }

   
  
    @Then("the user should be redirected to the Beneficiary User Dashboard")
    public void the_user_should_be_redirected_to_the_beneficiary_user_dashboard() {
        // Write code here that turns the phrase above into concrete actions
    }

  
   
    @Then("the user should be redirected to the Store Owner Dashboard")
    public void the_user_should_be_redirected_to_the_store_owner_dashboard() {
        // Write code here that turns the phrase above into concrete actions
    }
    
 
 
    @Then("the user should be redirected to the Supplier Dashboard")
    public void the_user_should_be_redirected_to_the_supplier_dashboard() {
        // Write code here that turns the phrase above into concrete actions
    }
}
