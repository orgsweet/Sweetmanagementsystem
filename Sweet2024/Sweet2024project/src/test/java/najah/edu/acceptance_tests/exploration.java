package najah.edu.acceptance_tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import najah.edu.DessertService;
import najah.edu.ShoppingCartService;

public class exploration {

    private DessertService dessertService;
    private ShoppingCartService shoppingCartService;
    private String searchResult;
    private String filterResult;
    private boolean purchaseSuccess;

    @Given("I am on the Store page")
    public void i_am_on_the_store_page() {
        // Initialize the services
        dessertService = new DessertService();
        shoppingCartService = new ShoppingCartService();
    }

    @When("I select a dessert and click the {string} button")
    public void i_select_a_dessert_and_click_the_button(String buttonLabel) {
        if (buttonLabel.equals("Add to Cart")) {
            purchaseSuccess = shoppingCartService.addToCart("Chocolate Cake");
        }
    }

    @When("I click the {string} button and complete the purchase process")
    public void i_click_the_button_and_complete_the_purchase_process(String buttonLabel) {
        if (buttonLabel.equals("Checkout")) {
            purchaseSuccess = shoppingCartService.checkout();
        }
    }

    @When("I enter {string} in the search bar")
    public void i_enter_in_the_search_bar(String searchTerm) {
        searchResult = dessertService.searchDesserts(searchTerm);
    }

    @Given("I am on the Recipes page")
    public void i_am_on_the_recipes_page() {
        dessertService = new DessertService();
    }

    @When("I click the {string} button")
    public void i_click_the_button(String buttonLabel) {
        if (buttonLabel.equals("Browse")) {
            searchResult = dessertService.browseDesserts();
        } else if (buttonLabel.equals("Search")) {
            searchResult = dessertService.searchDesserts("Chocolate Cake");
        } else if (buttonLabel.equals("Apply Filters")) {
            filterResult = dessertService.filterDesserts("Gluten-Free");
        } else if (buttonLabel.equals("Add to Cart")) {
            purchaseSuccess = shoppingCartService.addToCart("Chocolate Cake");
        } else if (buttonLabel.equals("Checkout")) {
            purchaseSuccess = shoppingCartService.checkout();
        }
    }

    @Then("I should see a list of dessert recipes")
    public void i_should_see_a_list_of_dessert_recipes() {
        Assert.assertNotNull("Search result should not be null", searchResult);
        Assert.assertTrue("Search result does not contain 'Dessert List'", searchResult.contains("Dessert List"));
    }

    @Then("I should see recipes matching {string}")
    public void i_should_see_recipes_matching(String searchTerm) {
        Assert.assertNotNull("Search result should not be null", searchResult);
        Assert.assertTrue("Search result does not contain the search term", searchResult.contains(searchTerm));
    }

    @Then("I should see recipes matching the {string} filter")
    public void i_should_see_recipes_matching_the_filter(String filter) {
        Assert.assertNotNull("Filter result should not be null", filterResult);
        Assert.assertTrue("Filter result does not contain the filter", filterResult.contains(filter));
    }

    @Then("I should purchase the dessert successfully")
    public void i_should_purchase_the_dessert_successfully() {
        Assert.assertTrue("Purchase was not successful", purchaseSuccess);
    }
}
