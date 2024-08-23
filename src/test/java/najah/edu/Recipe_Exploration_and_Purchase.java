package najah.edu;

import najah.Admin;

import najah.ContentManager;
import najah.FeedbackService;
import najah.ReportsService;
import najah.ProductService;

import static org.junit.Assert.assertTrue;

import java.util.List;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Recipe_Exploration_and_Purchase {
    
    private ContentManager contentManager;
    private FeedbackService feedbackService;
    private ReportsService reportsService;
    private ProductService productService;
    private Recipe_Exploration_and_Purchase testClass;

    private Admin admin;
    // Constructor to initialize the services
    public Recipe_Exploration_and_Purchase() {
        this.feedbackService = new FeedbackService();
        this.reportsService = new ReportsService();
        this.productService = new ProductService();

        admin = new Admin("adminUsername", "adminPassword");
        boolean loggedIn = admin.login("adminUsername", "adminPassword");

        if (loggedIn) {
            contentManager = new ContentManager(admin);
        } else {
            throw new IllegalStateException("Admin login failed. Cannot initialize ContentManager.");
        }
    }
    

    
    
   
    
    @Given("I signed up as an admin")
    public void i_signed_up_as_an_admin() {
        boolean loggedIn = admin.login("adminUsername", "adminPassword");

        if (!loggedIn) {
            throw new IllegalStateException("Admin login failed. Cannot proceed.");
        }
    }
    @When("I navigate to content management section")
    public void i_navigate_to_content_management_section() {
        // Navigate to the content management section
        contentManager.navigateToContentManagement();
    }

    @Then("I should see, edit, or delete recipes and posts")
    public void i_should_see_edit_or_delete_recipes_and_posts() {
        // View, edit, and delete recipes and posts
        contentManager.viewContent();
        contentManager.editContent("Recipe ID", "New Recipe Content");
        contentManager.deletePost("Recipe ID");
    }

    @When("I navigate to user feedback section")
    public void i_navigate_to_user_feedback_section() {
        // Navigate to the feedback section
        feedbackService.navigateToFeedbackSection();
    }

    @Then("I should be able to see, review, and respond to user feedback")
    public void i_should_be_able_to_see_review_and_respond_to_user_feedback() {
        // View, review, and respond to user feedback
        feedbackService.viewFeedback();
        feedbackService.respondToFeedback("Feedback ID", "Response Message");
    }

    @When("I should access the financial reports section")
    public void i_should_access_to_the_financial_reports_section() {
        // Navigate to financial reports section
        reportsService.navigateToFinancialReports();
    }

    @Then("I should see all reports on profits and financial performance")
    public void i_should_see_all_reports_on_profits_and_financial_performance() {
        // Ensure ReportsService is properly initialized
        assertTrue("ReportsService should be initialized", reportsService != null);

        // Fetch financial reports
        List<String> financialReports = reportsService.getFinancialReports();

        // Validate that financial reports are not empty
        assertTrue("Financial reports should not be empty", !financialReports.isEmpty());

        // Optionally, print the financial reports to the console
        System.out.println("Financial Reports:");
        financialReports.forEach(System.out::println);
    }

    @When("I ask to view best-selling products")
    public void i_ask_to_view_best_selling_products() {
        // Request best-selling products report
        productService.viewBestSellingProducts();
    }

    @Then("I should see a report of the top-selling products across all stores")
    public void i_should_see_a_report_of_the_top_selling_products_across_all_stores() {
        // View report of best-selling products
        productService.generateBestSellingProductsReport();
    }

    @When("I access to the user statistics section")
    public void i_access_to_the_user_statistics_section() {
        // Navigate to user statistics section
        reportsService.navigateToUserStatistics();
    }

    @Then("I should see statistics about registered users by city (e.g., Nablus, Jenin)")
    public void i_should_see_statistics_about_registered_users_by_city_e_g_nablus_jenin() {
        // View user statistics by city
        reportsService.generateUserStatisticsByCity();
    }
    
    @Given("I am on the Recipes page")
    public void i_am_on_the_recipes_page() {
        // Assuming there is a method in ContentManager or another class to navigate to the recipes page
        contentManager.navigateToRecipesPage();
        assertTrue("Should be on the Recipes page", contentManager.isOnRecipesPage());
    }

    @When("I enter {string} in the search bar")
    public void i_enter_in_the_search_bar(String searchTerm) {
        // Assuming there's a method to perform search in ContentManager
        contentManager.searchRecipes(searchTerm);
    }

    @When("I click the {string} button")
    public void i_click_the_button(String buttonLabel) {
        // Assuming there's a method to click a button by its label in ContentManager
        contentManager.clickButton(buttonLabel);
    }

    @Then("I should see recipes matching {string}")
    public void i_should_see_recipes_matching(String searchTerm) {
        List<String> recipes = contentManager.getSearchResults();
        assertTrue("Recipes should match the search term", recipes.stream().anyMatch(r -> r.contains(searchTerm)));
    }

    @Given("I am on the Store page")
    public void i_am_on_the_store_page() {
        // Navigate to the store page
        productService.navigateToStorePage();
        
        // Add a log to check if we successfully navigated
        boolean isOnStorePage = productService.isOnStorePage();
        System.out.println("Is on Store Page: " + isOnStorePage);

        // Check if the page has been loaded successfully
        assertTrue("Should be on the Store page", isOnStorePage);
    }



    @When("I select a dessert and click the {string} button")
    public void i_select_a_dessert_and_click_the_button(String buttonLabel) {
        // Assuming there’s a method to select a dessert and click a button in ProductService
        productService.selectDessert();
        productService.clickButton(buttonLabel);
    }

    @When("I click the {string} button and complete the purchase process")
    public void i_click_the_button_and_complete_the_purchase_process(String buttonLabel) {
        // Assuming there’s a method to click the button and complete the purchase in ProductService
        productService.clickButton(buttonLabel);
        productService.completePurchase();
    }

    @Then("I should purchase the dessert successfully")
    public void i_should_purchase_the_dessert_successfully() {
        // Verify if the dessert purchase was successful
        assertTrue("Dessert purchase should be successful", productService.isPurchaseSuccessful());
    }
    

@Then("I should see a list of dessert recipes")
public void i_should_see_a_list_of_dessert_recipes() {
    // Write code here that turns the phrase above into concrete actions
}

@When("I select {string} from the dietary needs filter")
public void i_select_from_the_dietary_needs_filter(String string) {
    // Write code here that turns the phrase above into concrete actions
}
@Then("I should see recipes matching the {string} filter")
public void i_should_see_recipes_matching_the_filter(String string) {
    // Write code here that turns the phrase above into concrete actions
}
}
