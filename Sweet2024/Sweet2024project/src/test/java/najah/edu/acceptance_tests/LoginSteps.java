package najah.edu.acceptance_tests;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import najah.edu.StoreService;

public class LoginSteps {

    private StoreService storeService;

    public LoginSteps() {
        storeService = new StoreService();
    }

    @Given("I am logged in as a store owner or supplier")
    public void i_am_logged_in_as_a_store_owner_or_supplier() {
        boolean actionSuccess = storeService.signIn("storeOwner", "password");
        Assert.assertTrue("Login should be successful.", actionSuccess);
    }
}
