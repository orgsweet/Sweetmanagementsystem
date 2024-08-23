package najah.edu.acceptance_tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import najah.edu.ReportService;
import najah.edu.ReportService.User;
import najah.edu.UserService;

import java.util.Map;

public class Monitoring_Reporting {
    private UserService userService;
    private boolean deactivateSuccess;

    private ReportService reportService;
    private String profitReportDetails;
    private Map<String, Integer> userStatistics;
    private boolean updateSuccess;
    private boolean deleteSuccess;
    private String filterResult;

    public Monitoring_Reporting() {
        reportService = new ReportService();
        userService = new UserService();

    }

    @When("I navigate to the account management section")
    public void i_navigate_to_the_account_management_section() {
    	 boolean navigationSuccess = reportService.navigateToAccountManagement();

    	    // Assert that navigation was successful
    	    Assert.assertTrue("Failed to navigate to the account management section", navigationSuccess);
    	
    }

    @When("I update my business information")
    public void i_update_my_business_information() {
        updateSuccess = reportService.updateBusinessInformation("new info");
    }

    @Then("my account details should be updated successfully")
    public void my_account_details_should_be_updated_successfully() {
    	  Assert.assertTrue("Account details were not updated successfully", updateSuccess);
    }

    @When("I navigate to the content management section")
    public void i_navigate_to_the_content_management_section() {
    	boolean navigationSuccess = reportService.navigateToContentManagement();

        // Assert that navigation was successful
        Assert.assertTrue("Failed to navigate to the content management section", navigationSuccess);
    
    }

    @Then("I should be able to view, edit, or delete recipes and posts")
    public void i_should_be_able_to_view_edit_or_delete_recipes_and_posts() {
        boolean viewSuccess = reportService.viewContent("recipeId");
        boolean editSuccess = reportService.editContent("recipeId", "new content");
        deleteSuccess = reportService.deleteContent("recipeId");
        Assert.assertTrue("Failed to view content", viewSuccess);
        Assert.assertTrue("Failed to edit content", editSuccess);
        Assert.assertTrue("Failed to delete content", deleteSuccess);
    }

    @When("I navigate to the user feedback section")
    public void i_navigate_to_the_user_feedback_section() {
    	boolean navigationSuccess = reportService.navigateToUserFeedback();

        // Assert that navigation was successful
        Assert.assertTrue("Failed to navigate to the user feedback section", navigationSuccess);
    
    }

    @Then("I should be able to view, review, and respond to user feedback")
    public void i_should_be_able_to_view_review_and_respond_to_user_feedback() {
        boolean reviewSuccess = reportService.reviewFeedback("feedbackId", "response");
        Assert.assertTrue("Failed to review feedback", reviewSuccess);
    }

    @When("I navigate to the user management section")
    public void i_navigate_to_the_user_management_section() {
       
    	  boolean navigationSuccess = reportService.navigateToUserManagement();
    	    
    	    // Assert that navigation was successful
    	    Assert.assertTrue("Failed to navigate to the user management section", navigationSuccess);
    	
    }

    @Then("I should see a list of all user accounts including store owners and raw material suppliers")
    public void i_should_see_a_list_of_all_user_accounts_including_store_owners_and_raw_material_suppliers() {
        Map<String, User> userList = reportService.getUserList();
        Assert.assertNotNull("User list is null", userList);
        Assert.assertFalse("User list is empty", userList.isEmpty());
    }

    @When("I choose to add a new user account")
    public void i_choose_to_add_a_new_user_account() {
        // Simulate choosing to add a new user account
    	 String username = "newUser";       // Example username
    	    String password = "newPassword";   // Example password
    	    String role = "customer";          // Example

    	  
    	    boolean addSuccess = reportService.addUser(username, password, role);
    	 // Assert that the user was successfully added
    	    Assert.assertTrue("Failed to add new user account", addSuccess);
    }

    @When("provide the required details for the new user")
    public void provide_the_required_details_for_the_new_user() {
        boolean addSuccess = reportService.addUser("newUser", "password", "role");
        Assert.assertTrue("Failed to add new user", addSuccess);
    }

    @Then("the new user account should be created")
    public void the_new_user_account_should_be_created() {
        Assert.assertTrue("New user account was not created", reportService.isUserCreated("newUser"));
    }

    @Then("the user should receive a notification with account details")
    public void the_user_should_receive_a_notification_with_account_details() {
        boolean notificationReceived = reportService.checkNotification("newUser");
        Assert.assertTrue("Notification was not received", notificationReceived);
    }

    @When("I select a user account to update")
    public void i_select_a_user_account_to_update() {
    	 String userId = "existingUser";  // Replace with the actual user ID or username
    	    // Simulate selecting the user account for updating
    	    boolean userExists = reportService.checkUserExists(userId);
    	    // Assert that the user exists and can be selected for update
    	    Assert.assertTrue("User account does not exist or cannot be selected", userExists);
    }

   
    @When("modify the user's details")
    public void modify_the_user_s_details() {
        updateSuccess = reportService.updateUserDetails("userId", "newDetails");
    }

    @Then("the changes should be saved")
    Assert.assertTrue("Changes were not saved", updateSuccess);


    @Then("the user should be notified of the updates")
    public void the_user_should_be_notified_of_the_updates() {
        boolean notificationReceived = reportService.checkNotification("userId");

    }
    
 
  

    
    @When("I choose to deactivate a user account")
    public void i_choose_to_deactivate_a_user_account() {
        deactivateSuccess = userService.deactivateUser("userId");

    }



    @Then("the user account should be deactivated")
    public void the_user_account_should_be_deactivated() {
        Assert.assertFalse("User account is not deactivated", reportService.isUserActive("userId"));
    }

    @Then("the user should be notified of the deactivation")
    public void the_user_should_be_notified_of_the_deactivation() {
        boolean notificationReceived = reportService.checkNotification("userId");

    }

    @When("I navigate to the financial reports section")
    public void i_navigate_to_the_financial_reports_section() {
    	 boolean navigationSuccess = reportService.navigateToAccountManagement();

    	    // Assert that navigation was successful
    	    Assert.assertTrue("Failed to navigate to the financial reports section", navigationSuccess);
    	}
    }

    @Then("I should be able to view profit reports and user statistics")
    public void i_should_be_able_to_view_profit_reports_and_user_statistics() {
        profitReportDetails = reportService.generateProfitReport();
        userStatistics = reportService.generateUserStatisticsByCity();
        Assert.assertNotNull("Profit report details are null", profitReportDetails);
        Assert.assertNotNull("User statistics are null", userStatistics);
    }

    @When("I choose to filter recipes based on dietary needs")
    public void i_choose_to_filter_recipes_based_on_dietary_needs() {
        filterResult = reportService.applyDietaryNeedsFilter("Vegan");
    }
    @When("I update my account details to username {string} and password {string}")
    public void i_update_my_account_details(String newUsername, String newPassword) {
        updateSuccess = userService.updateAccountDetails(newUsername, newPassword);
    }



    @Then("I should see recipes that meet the dietary needs")
    public void i_should_see_recipes_that_meet_the_dietary_needs() {
        Assert.assertTrue("Filter result does not contain expected dietary needs", filterResult.contains("Vegan"));
    }

    @When("I sign up for a new account")
    public void i_sign_up_for_a_new_account() {
        boolean signUpSuccess = reportService.signUp("user", "password", "email@example.com");
        Assert.assertTrue("Sign up was not successful", signUpSuccess);
    }

    @When("I sign in to the system")
    public void i_sign_in_to_the_system() {
        boolean signInSuccess = reportService.signIn("user", "password");
        Assert.assertTrue("Sign in was not successful", signInSuccess);
    }

    @When("I update my email address")
    public void i_update_my_email_address() {
        boolean emailUpdateSuccess = reportService.updateEmail("newemail@example.com");
        Assert.assertTrue("Email update was not successful", emailUpdateSuccess);
    }

    @When("I post a new dessert creation")
    public void i_post_a_new_dessert_creation() {
        boolean postSuccess = reportService.postDessertCreation("Chocolate Cake", "Delicious chocolate cake recipe.");
        Assert.assertTrue("Posting dessert creation was not successful", postSuccess);
    }

    @When("I upload an image for the dessert")
    public void i_upload_an_image_for_the_dessert() {
        boolean uploadSuccess = reportService.uploadImage("path/to/image.jpg");
        Assert.assertTrue("Image upload was not successful", uploadSuccess);
    }

    @Then("the dessert should be shared successfully")
    public void the_dessert_should_be_shared_successfully() {
        Assert.assertTrue("Dessert was not shared", reportService.isDessertShared("Chocolate Cake"));
    }
    

@When("I request to view best-selling products")
public void i_request_to_view_best_selling_products() {
    // Write code here that turns the phrase above into concrete actions
}
@Then("I should see a report of the best-selling products across all stores")
public void i_should_see_a_report_of_the_best_selling_products_across_all_stores() {
    // Write code here that turns the phrase above into concrete actions
	  String bestSellingProducts = reportService.getBestSellingProductsReport();
      Assert.assertNotNull("Best-selling products report is null", bestSellingProducts);
      Assert.assertTrue("Best-selling products report is empty", !bestSellingProducts.isEmpty());
  }
}


@When("I navigate to the user statistics section")
public void i_navigate_to_the_user_statistics_section() {
    // Write code here that turns the phrase above into concrete actions
}
@Then("I should see statistics on registered users by city \\(e.g., Nablus, Jenin)")
public void i_should_see_statistics_on_registered_users_by_city_e_g_nablus_jenin() {
    // Write code here that turns the phrase above into concrete actions
	 Map<String, Integer> userStatsByCity = reportService.getUserStatisticsByCity();
     Assert.assertNotNull("User statistics by city are null", userStatsByCity);
     Assert.assertFalse("User statistics by city are empty", userStatsByCity.isEmpty());
}

@Then("I should see reports on profits and financial performance")
public void i_should_see_reports_on_profits_and_financial_performance() {
	 profitReportDetails = reportService.generateProfitReport();
     Assert.assertNotNull("Profit report details are null", profitReportDetails);
}

}
