package najah.edu.acceptance_tests;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class choose {

    private String currentRole;
    private Map<String, Runnable> roleNavigationMap;

    
    public choose() {
        roleNavigationMap = new HashMap<>();
        // Initialize role navigation actions
        roleNavigationMap.put("admin", this::navigateToAdminDashboard);
        roleNavigationMap.put("store owner", this::navigateToStoreOwnerDashboard);
        roleNavigationMap.put("supplier", this::navigateToSupplierDashboard);
        roleNavigationMap.put("beneficiary user", this::navigateToBeneficiaryUserDashboard);
    }

    @Given("the user is on the Role Selection page")
    public void the_user_is_on_the_role_selection_page() {
       
        navigateToRoleSelectionPage();
    }

    @When("the user clicks the {string} button")
    public void the_user_clicks_the_button(String role) {
        
        this.currentRole = role.toLowerCase();
        Runnable navigationAction = roleNavigationMap.get(currentRole);
        if (navigationAction != null) {
            navigationAction.run();
        } else {
            throw new IllegalArgumentException("Unknown role: " + role);
        }
    }

    @Then("the user should be redirected to the Admin Dashboard")
    public void the_user_should_be_redirected_to_the_admin_dashboard() {
        
        Assert.assertTrue("User is not on the Admin Dashboard", checkAdminDashboard());
    }

    @Then("the user should be redirected to the Store Owner Dashboard")
    public void the_user_should_be_redirected_to_the_store_owner_dashboard() {
        
        Assert.assertTrue("User is not on the Store Owner Dashboard", checkStoreOwnerDashboard());
    }

    @Then("the user should be redirected to the Supplier Dashboard")
    public void the_user_should_be_redirected_to_the_supplier_dashboard() {
     
        Assert.assertTrue("User is not on the Supplier Dashboard", checkSupplierDashboard());
    }

    @Then("the user should be redirected to the Beneficiary User Dashboard")
    public void the_user_should_be_redirected_to_the_beneficiary_user_dashboard() {
              Assert.assertTrue("User is not on the Beneficiary User Dashboard", checkBeneficiaryUserDashboard());
    }

    
    private void navigateToRoleSelectionPage() {
        System.out.println("Navigated to Role Selection page.");
    }

    // Simulate navigating to the Admin Dashboard
    private void navigateToAdminDashboard() {
        System.out.println("Navigated to Admin Dashboard.");
        currentRole = "admin"; // Update role for validation
    }

    // Simulate navigating to the Store Owner Dashboard
    private void navigateToStoreOwnerDashboard() {
        System.out.println("Navigated to Store Owner Dashboard.");
        currentRole = "store owner"; // Update role for validation
    }

    // Simulate navigating to the Supplier Dashboard
    private void navigateToSupplierDashboard() {
        System.out.println("Navigated to Supplier Dashboard.");
        currentRole = "supplier"; // Update role for validation
    }

    // Simulate navigating to the Beneficiary User Dashboard
    private void navigateToBeneficiaryUserDashboard() {
        System.out.println("Navigated to Beneficiary User Dashboard.");
        currentRole = "beneficiary user"; // Update role for validation
    }

    // Simulate checking if on Admin Dashboard
    private boolean checkAdminDashboard() {
        return "admin".equals(currentRole);
    }

    // Simulate checking if on Store Owner Dashboard
    private boolean checkStoreOwnerDashboard() {
        return "store owner".equals(currentRole);
    }

    // Simulate checking if on Supplier Dashboard
    private boolean checkSupplierDashboard() {
        return "supplier".equals(currentRole);
    }

    // Simulate checking if on Beneficiary User Dashboard
    private boolean checkBeneficiaryUserDashboard() {
        return "beneficiary user".equals(currentRole);
    }
}
