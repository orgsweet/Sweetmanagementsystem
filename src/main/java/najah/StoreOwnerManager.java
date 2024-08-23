package najah;

import java.util.HashMap;
import java.util.Map;
import najah.Product;

 
public class StoreOwnerManager {
    private Map<String, String> storeOwners = new HashMap<>();
    private Admin admin;
    private Map<String, Product> products = new HashMap<>(); // Storage for products
    /**
     * Constructor to initialize StoreOwnerManager with an Admin.
     *
     * @param admin The Admin instance required for managing store owners.
     */
    public StoreOwnerManager(Admin admin) {
        this.admin = admin;
    }

    public StoreOwnerManager(String storeOwnerId, String storeOwnerName) {
        // Example implementation: adding a store owner with ID and name
        this.storeOwners.put(storeOwnerId, storeOwnerName);
        System.out.println("Store Owner added via constructor: " + storeOwnerName);
    }


	/**
     * Checks if the current page is the Store page.
     *
     * @return true if the current page is "Store", false otherwise.
     */
    public boolean isOnStorePage() {
        String currentPage = getCurrentPage();  // Fetch the current page identifier, like URL or page title.
        
        if (currentPage == null) {
            return false;  // Ensure we don't return an error if currentPage is null.
        }
        
        return currentPage.equals("Store");
    }

    /**
     * Simulates getting the current page.
     *
     * @return A string representing the current page.
     */
    private String getCurrentPage() {
        // Logic to get the current page, e.g., URL, title, or a specific element identifier.
        return "Store";  // For example, return "Store" when on the Store page.
    }

    /**
     * Adds a store owner to the system.
     *
     * @param id    The unique identifier for the store owner.
     * @param name  The name of the store owner.
     * @param email The email of the store owner.
     */
    public void addStoreOwner(String id, String name, String email) {
        // Add store owner logic
        storeOwners.put(id, name);
        System.out.println("Store Owner added: " + name + " with email: " + email);
    }

    /**
     * Checks if a store owner with the given ID has been added.
     *
     * @param id The unique identifier for the store owner.
     * @return true if the store owner exists, false otherwise.
     */
    public boolean isStoreOwnerAdded(String id) {
        return storeOwners.containsKey(id);
    }

    /**
     * Placeholder for login functionality.
     *
     * @param username The username for login.
     * @param password The password for login.
     * @return true if login is successful, false otherwise.
     */
    public boolean login(String username, String password) {
        // Example hardcoded credentials for demonstration
        String correctUsername = "admin";
        String correctPassword = "password123";
        
        // Check if the provided credentials match the hardcoded values
        return username.equals(correctUsername) && password.equals(correctPassword);
    }


    public boolean updateProduct(String productName, String newDescription, double newPrice, int newQuantity) {
        Product product = products.get(productName);
        if (product == null) {
            System.out.println("Product not found.");
            return false;
        }

        // Update product details
        product.setDescription(newDescription);
        product.setPrice(newPrice);
        product.setQuantity(newQuantity);
        return true;
    }



    public boolean addProduct(Product product) {
        if (product == null || product.getName() == null || product.getName().isEmpty()) {
            System.out.println("Invalid product or product name.");
            return false;
        }

        products.put(product.getName(), product);
        System.out.println("Product added: " + product.getName());  // Debugging line
        return true;
    }



    public Product getProductByName(String productName) {
        if (productName == null || productName.isEmpty()) {
            return null; // Invalid product name
        }
        // Retrieve the product from the storage
        Product product = products.get(productName);
        if (product == null) {
            System.out.println("Product not found: " + productName);
        }
        return product;
    

    }
    
    



    // Additional methods or functionality can be added as needed
}
