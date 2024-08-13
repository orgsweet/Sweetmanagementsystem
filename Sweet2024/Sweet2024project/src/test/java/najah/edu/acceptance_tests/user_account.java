package najah.edu.acceptance_tests;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import najah.edu.ProductService;

import java.util.List;
import java.util.Map;

public class user_account {

    private ProductService productService;
    private boolean actionSuccess;

    // Constructor initializes the services
    public user_account() {
        productService = new ProductService();
    }

    @When("I add a new product with the following details:")
    public void i_add_a_new_product_with_the_following_details(DataTable dataTable) {
        List<Map<String, String>> products = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> product : products) {
            String name = product.get("name");
            String description = product.get("description");
            double price = Double.parseDouble(product.get("price"));
            int quantity = Integer.parseInt(product.get("quantity"));
            actionSuccess = productService.addProduct(name, price);
        }
        Assert.assertTrue("Product should be added successfully.", actionSuccess);
    }

    @When("I update the product {string} with the following details:")
    public void i_update_the_product_with_the_following_details(String productName, DataTable dataTable) {
        List<Map<String, String>> products = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> product : products) {
            String description = product.get("description");
            double price = Double.parseDouble(product.get("price"));
            int quantity = Integer.parseInt(product.get("quantity"));

            System.out.println("Updating product: " + productName + " with description: " + description + ", price: " + price + ", quantity: " + quantity);
            
            actionSuccess = productService.updateProduct(productName, description, price, quantity);
            Assert.assertTrue("Product details should be updated successfully.", actionSuccess);
        }
    }


    @Then("the product details should be updated successfully")
    public void the_product_details_should_be_updated_successfully() {
    	System.out.println("Update success: " + actionSuccess);

    }
    

@When("I post a new dessert creation with the title {string} and description {string}")
public void i_post_a_new_dessert_creation_with_the_title_and_description(String string, String string2) {
    // Write code here that turns the phrase above into concrete actions
	 actionSuccess = productService.postDessertCreation(title, description);
     postedDessertTitle = title;
     Assert.assertTrue("Dessert creation should be posted successfully.", actionSuccess);
 }
}
@When("I upload an image of the cake")
public void i_upload_an_image_of_the_cake() {
    // Write code here that turns the phrase above into concrete actions
	 uploadedImagePath = "path/to/cake/image.jpg"; // Update with actual image path
     actionSuccess = productService.uploadImage(uploadedImagePath);
     Assert.assertTrue("Image upload should be successful.", actionSuccess);
}
@Then("my dessert creation should be shared successfully")
public void my_dessert_creation_should_be_shared_successfully() {
    // Write code here that turns the phrase above into concrete actions
	 boolean isDessertShared = productService.isDessertShared(postedDessertTitle);
     Assert.assertTrue("Dessert creation should be shared successfully.", isDessertShared);
 }
}

@When("I update my email to {string}")
public void i_update_my_email_to(String string) {
    // Write code here that turns the phrase above into concrete actions
	  updatedEmail = email;
      actionSuccess = productService.updateEmail(email);
      Assert.assertTrue("Email update should be successful.", actionSuccess);
}


@Given("I am on the Sign In page")
public void i_am_on_the_sign_in_page() {
    // Write code here that turns the phrase above into concrete actions
}
@When("I enter my username as {string} and password as {string}")
public void i_enter_my_username_as_and_password_as(String string, String string2) {
    // Write code here that turns the phrase above into concrete actions
}
@Then("I should be signed in successfully")
public void i_should_be_signed_in_successfully() {
    // Write code here that turns the phrase above into concrete actions
	 Assert.assertTrue("Sign in was successful", actionSuccess);
}


@Given("I am on the Sign Up page")
public void i_am_on_the_sign_up_page() {
    // Write code here that turns the phrase above into concrete actions
}
@When("I enter my details:")
public void i_enter_my_details(io.cucumber.datatable.DataTable dataTable) {
	 List<Map<String, String>> userDetails = dataTable.asMaps(String.class, String.class);
     Map<String, String> details = userDetails.get(0);
     String username = details.get("username");
     String password = details.get("password");
     String email = details.get("email");
     
     actionSuccess = productService.signUp(username, password, email);
     Assert.assertTrue("Sign up should be successful.", actionSuccess);
}
@Then("my account should be created successfully")
public void my_account_should_be_created_successfully() {
	Assert.assertTrue("Account creation was successful", actionSuccess);
}


@When("I select {string} from the dietary needs filter")
public void i_select_from_the_dietary_needs_filter(String string) {
    // Write code here that turns the phrase above into concrete actions
	 actionSuccess = productService.applyDietaryNeedsFilter(dietaryNeed);
     Assert.assertTrue("Dietary needs filter application should be successful.", actionSuccess);
 
}





}
