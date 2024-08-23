package najah.edu.acceptance_tests;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import najah.edu.StoreService;

public class SharedSteps {

    private StoreService storeService = new StoreService();
    private boolean actionSuccess;
    private String viewedReport;


    @Then("I should see the sales and profit details")
    public void i_should_see_the_sales_and_profit_details() {
        Assert.assertNotNull("Sales and profit details should not be null.", viewedReport);
    }

   
    
   
    @Then("I should see a report of the best-selling products")
    public void i_should_see_a_report_of_the_best_selling_products() {
        Assert.assertNotNull("Best-selling products report should not be null.", viewedReport);
    }
}
