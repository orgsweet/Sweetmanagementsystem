package najah.edu;

import najah.AdminDashboard;
import najah.ContentManager;
import najah.ReportsService;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class Admin_mangement {
	
	@Before
	public void setup() {
	    adminDashboard = new AdminDashboard();
	    reportsService = new ReportsService(); // Ensure ReportsService is also properly initialized

	    // Initialize ContentManager properly with AdminDashboard
	    adminDashboard.setContentManager(new ContentManager(adminDashboard)); // Pass AdminDashboard instance
	}

	




@When("I navigate to the user statistics area")
public void i_navigate_to_the_user_statistics_area() {
    // Write code here that turns the phrase above into concrete actions
}
	
	@When("I navigate to the content management")
	public void i_navigate_to_the_content_management() {
	    viewedContent = adminDashboard.viewRecipesAndPosts();
	    Assert.assertNotNull("Failed to load content", viewedContent);
	}

	@Then("I should be able to edit, view, or delete recipes and posts")
	public void i_should_be_able_to_edit_view_or_delete_recipes_and_posts() {
	    // Check initial content
	    List<String> currentContent = adminDashboard.viewRecipesAndPosts();
	    String oldRecipe = "Recipe1";
	    String newRecipe = "UpdatedRecipe1";

	    System.out.println("Current Content: " + currentContent);

	    Assert.assertNotNull("Content should be viewable", currentContent);
	    Assert.assertTrue("Old recipe should be in the content list", currentContent.contains(oldRecipe));

	    // Edit recipe
	    adminDashboard.editRecipe(oldRecipe, newRecipe);

	    // Verify updated content
	    currentContent = adminDashboard.viewRecipesAndPosts();
	    Assert.assertTrue("Updated recipe should be in the content list", currentContent.contains(newRecipe));
	    Assert.assertFalse("Old recipe should not be in the content list", currentContent.contains(oldRecipe));

	    // Delete post
	    String postToDelete = "Post1";
	    adminDashboard.deletePost(postToDelete);

	    // Verify post deletion
	    currentContent = adminDashboard.viewRecipesAndPosts();
	    Assert.assertFalse("Deleted post should not be in the content list", currentContent.contains(postToDelete));
	}



	@When("I request to view the best-selling products")
	public void i_request_to_view_the_best_selling_products() {
	    // Fetch the best-selling products from the ReportsService
	    viewedBestSellingProducts = reportsService.getBestSellingProducts();
	    
	    // Assert that the best-selling products were successfully retrieved
	    Assert.assertNotNull("Failed to retrieve best-selling products", viewedBestSellingProducts);
	}
	@Then("I should see a report of the best-selling products across all stores")
	public void i_should_see_a_report_of_the_best_selling_products_across_all_stores() {
	    // Ensure that the list of best-selling products is not empty
	    Assert.assertFalse("The list of best-selling products should not be empty", viewedBestSellingProducts.isEmpty());

	    // Optionally, you can print out the products or perform additional assertions
	    System.out.println("Best-Selling Products Report:");
	    for (String product : viewedBestSellingProducts) {
	        System.out.println(product);
	    }
	}


	@When("I navigate to the financial reports section")
	public void i_navigate_to_the_financial_reports_section() {
	    // Simulate navigating to the financial reports section
	    reportsService.navigateToFinancialReports();

	    // Fetch the financial reports
	    viewedReports = reportsService.getFinancialReports();
	    
	    // Ensure that the reports have been successfully retrieved
	    Assert.assertNotNull("Failed to retrieve financial reports", viewedReports);
	}

	@Then("I should see reports on profits and financial performance")
	public void i_should_see_reports_on_profits_and_financial_performance() {
	    // Check that the reports list is not empty
	    Assert.assertFalse("No financial reports available", viewedReports.isEmpty());

	    // Optionally, you can check specific content if you have expectations
	    // For example, you might expect specific profit details
	    Assert.assertTrue("Reports do not contain expected content", 
	        viewedReports.contains("Profit: $5000") &&
	        viewedReports.contains("Expenses: $2000") &&
	        viewedReports.contains("Net Profit: $3000")
	    );
	}


	@When("I navigate to the user feedback section")
	public void i_navigate_to_the_user_feedback_section() {
	    // Fetch user feedback from the admin dashboard
	    viewedFeedback = adminDashboard.viewFeedback();
	    
	    // Ensure that feedback was loaded successfully
	    Assert.assertNotNull("Failed to load user feedback", viewedFeedback);
	}

	@Then("I should be able to view, review, and respond to user feedback")
	public void i_should_be_able_to_view_review_and_respond_to_user_feedback() {
	    // Ensure that feedback is loaded
	    Assert.assertNotNull("No feedback available", viewedFeedback);
	    
	    // Example of reviewing feedback
	    // Here we are assuming there's at least one feedback item
	    if (!viewedFeedback.isEmpty()) {
	        String feedbackToRespondTo = viewedFeedback.get(0); // Example: choose the first feedback
	        
	        // Simulate responding to feedback
	        boolean responseSuccess = adminDashboard.respondToFeedback(feedbackToRespondTo, "Thank you for your feedback!");
	        
	        // Ensure the response was successful
	        Assert.assertTrue("Failed to respond to feedback", responseSuccess);
	    } else {
	        Assert.fail("No feedback available to respond to");
	    }
	}



    private AdminDashboard adminDashboard;
    private List<String> viewedContent;
    private List<String> viewedFeedback;
    private List<String> viewedReports;
    private List<String> viewedBestSellingProducts;
    private List<String> viewedUserStatistics;
    private ReportsService reportsService;
    
}