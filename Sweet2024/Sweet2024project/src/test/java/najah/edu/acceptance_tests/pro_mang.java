package najah.edu.acceptance_tests;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.ProductService;
import najah.edu.StoreService;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class pro_mang {

    private static StoreService storeService = new StoreService(); // Make StoreService static
    private boolean actionSuccess;
    private String productName;

    public pro_mang() {
        storeService = new StoreService();
    }

    @Before
    public void setup() {
        storeService = new StoreService();
        ProductService productService = new ProductService();

        // Clear the catalog if needed
    }
    
    @Given("I am logged in as a store owner or supplier for product management")
    public void i_am_logged_in_as_a_store_owner_or_supplier_for_product_management() {
        actionSuccess = storeService.signIn("storeOwner", "password"); 
        Assert.assertTrue("Login should be successful.", actionSuccess);
    }

    @Given("the following product exists:")
    public void the_following_product_exists(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> products = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> product : products) {
            String name = product.get("name");
            String description = product.get("description");
            double price = Double.parseDouble(product.get("price"));
            int quantity = Integer.parseInt(product.get("quantity"));
            actionSuccess = storeService.addProduct(name, description, price, quantity);
            System.out.println("Attempting to add product: " + name + ", added: " + actionSuccess); // Debug statement
            this.productName = name; // Set productName to the added product
        }
    }



    @When("I remove the product {string}")
    public void i_remove_the_product(String productName) {
        actionSuccess = storeService.removeProduct(productName);
    }

    @Then("the product should be removed successfully")
    public void the_product_should_be_removed_successfully() {
        Assert.assertTrue("Product should be removed successfully.", actionSuccess);
    }
    
    

    @When("I set a discount of {int}% on the product {string}")
    public void i_set_a_discount_of_on_the_product(Integer discount, String productName) {
        StoreService.Product product = storeService.getProduct(productName);
        if (product == null) {
            System.out.println("Product not found: " + productName); // Debug statement
            Assert.fail("Product with name '" + productName + "' does not exist. Check if the product is added correctly.");
        }
        this.productName = productName;
        actionSuccess = storeService.setDiscount(productName, discount);
        System.out.println("Discount applied: " + discount + "% on product: " + productName + ", success: " + actionSuccess);
    }




    @Then("the product price should be updated to reflect the discount")
    public void the_product_price_should_be_updated_to_reflect_the_discount() {
        StoreService.Product product = storeService.getProduct(productName);
        Assert.assertNotNull("Product with name '" + productName + "' should not be null.", product);

        double originalPrice = storeService.getOriginalPrice(productName);
        int discount = storeService.getDiscount(productName);

        double expectedDiscountPrice = originalPrice - (originalPrice * discount / 100);
        Assert.assertEquals("Product price should be updated to reflect the discount.", expectedDiscountPrice, product.getPrice(), 0.01);
    }
    
    @When("I add a new product with the following details for product management:")
    public void i_add_a_new_product_with_the_following_details_for_product_management(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> products = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> product : products) {
            String name = product.get("name");
            String description = product.get("description");
            double price = Double.parseDouble(product.get("price"));
            int quantity = Integer.parseInt(product.get("quantity"));
            actionSuccess = storeService.addProduct(name, description, price, quantity);
            this.productName = name; // Set productName here
            System.out.println("Attempting to add product: " + name + ", added: " + actionSuccess); // Debug statement
        }
    }
    
    


    
    @Then("the new product should be added successfully")
    public void the_new_product_should_be_added_successfully() {
    	 StoreService.Product product = storeService.getProduct(productName);
    	    
    	    Assert.assertNotNull("The new product should be added successfully, but it was not found.", product);
    	    
    	    boolean isProductCorrect = storeService.validateProductDetails(productName, "description", 20.0, 10); // Update with correct expected details
    	    Assert.assertTrue("Product details are incorrect or not as expected.", isProductCorrect);
    
    }



  



    @When("I update the product {string} with the new details:")
    public void i_update_the_product_with_the_new_details(String productName, io.cucumber.datatable.DataTable dataTable) {
        this.productName = productName; // Set productName for further use
        Map<String, String> newDetails = dataTable.asMaps(String.class, String.class).get(0);
        String description = newDetails.get("description");
        double price = Double.parseDouble(newDetails.get("price"));
        int quantity = Integer.parseInt(newDetails.get("quantity"));
        actionSuccess = storeService.updateProduct(productName, description, price, quantity);
    }
    @When("I request to view my best-selling products")
    public void i_request_to_view_my_best_selling_products() {
        // Simulate some sales if necessary
        storeService.sellProduct("Chocolate Cake", 10); // Example
    }

    @Then("I should see the top-selling products report")
    public void i_should_see_the_top_selling_products_report() {
        char[] report = storeService.viewBestSellingProducts();
        Assert.assertNotNull("Best-selling products report should not be null.", report);
        // Additional checks to ensure the report contains valid data can be added here.
    }

    @When("I request to view my sales and profits")
    public void i_request_to_view_my_sales_and_profits() {
        // Simulate some sales if necessary
        storeService.sellProduct("Chocolate Cake", 5); // Example
    }

 

    @Then("I should see the detailed sales and profit report")
    public void i_should_see_the_detailed_sales_and_profit_report() {
        char[] details = storeService.viewSalesAndProfits();
        Assert.assertNotNull("Sales and profit details should not be null.", details);
        // Additional checks to ensure the details are correct can be added here.
    }





}
