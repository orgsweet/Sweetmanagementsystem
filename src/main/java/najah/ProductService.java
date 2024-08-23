package najah;

import java.util.HashMap;

import java.util.Map;

public class ProductService {

    private Map<String, Integer> bestSellingProducts = new HashMap<>();
    private boolean onStorePage = false;
    private boolean purchaseSuccessful = false; // Track purchase status
    private Map<String, Double> salesData = new HashMap<>(); // Storage for profit data
    private Map<String, Double> profitData = new HashMap<>(); // Storage for profit data
    private Map<String, Product> products = new HashMap<>(); // Storage for products

  
     
    public void addProductSalesData(String productName, int salesCount) {
        bestSellingProducts.put(productName, salesCount);
        System.out.println("Product sales data added: " + productName + " with sales: " + salesCount);
    }

    /**
     * Displays the best-selling products.
     */
    public void viewBestSellingProducts() {
        if (bestSellingProducts.isEmpty()) {
            System.out.println("No product sales data available.");
        } else {
            System.out.println("Displaying best-selling products:");
            bestSellingProducts.forEach((productName, salesCount) -> 
                System.out.println("Product: " + productName + ", Sales: " + salesCount));
        }
    }

    /**
     * Generates a report of best-selling products sorted by sales count.
     */
    public void generateBestSellingProductsReport() {
        if (bestSellingProducts.isEmpty()) {
            System.out.println("No best-selling products data to generate a report.");
        } else {
            System.out.println("Generating best-selling products report:");
            bestSellingProducts.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .forEach(entry -> System.out.println("Product: " + entry.getKey() + ", Sales: " + entry.getValue()));
        }
    }

    /**
     * Navigates to the store page.
     */
    public void navigateToStorePage() {
        System.out.println("Navigating to the Store page...");
        onStorePage = true; // Set the flag to true once on the store page
    }

    /**
     * Completes a purchase.
     */
    public void completePurchase() {
        // Simulate purchase logic here
        System.out.println("Completing the purchase...");
        purchaseSuccessful = true; // Assume the purchase was successful
        System.out.println("Purchase completed successfully.");
    }

    /**
     * Clicks a button based on the provided label.
     *
     * @param buttonLabel The label of the button to click.
     */
    public void clickButton(String buttonLabel) {
        switch (buttonLabel.toLowerCase()) {
            case "view best selling products":
                viewBestSellingProducts();
                break;
            case "generate report":
                generateBestSellingProductsReport();
                break;
            case "complete purchase":
                completePurchase();
                break;
            case "navigate to store page":
                navigateToStorePage();
                break;
            case "select dessert":
                selectDessert();
                break;
            default:
                System.out.println("No action defined for button: " + buttonLabel);
                break;
        }
    }

    /**
     * Simulates selecting a dessert.
     */
    public void selectDessert() {
        // Simulate selecting a dessert
        System.out.println("Selecting a dessert...");
    }

    /**
     * Checks if the current page is the store page.
     *
     * @return true if on the store page, false otherwise.
     */
    public boolean isOnStorePage() {
        return onStorePage;
    }

    /**
     * Checks if the purchase was successful.
     *
     * @return true if the purchase was successful, false otherwise.
     */
    public boolean isPurchaseSuccessful() {
        return purchaseSuccessful;
    }

    public Product getProductByName(String productName) {
        if (productName == null || productName.isEmpty()) {
            return null;
        }
        return products.get(productName);
    }
    public String getReportContent() {
        StringBuilder report = new StringBuilder("Best-Selling Products Report:\n");
        if (bestSellingProducts.isEmpty()) {
            report.append("No product sales data available.");
        } else {
            bestSellingProducts.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .forEach(entry -> report.append("Product: ").append(entry.getKey())
                                        .append(", Sales: ").append(entry.getValue())
                                        .append("\n"));
        }
        return report.toString();
    }

    public void generateSalesAndProfitsReport() {
        if (salesData.isEmpty() && profitData.isEmpty()) {
            System.out.println("No sales or profits data available.");
        } else {
            System.out.println("Sales and Profits Report:");
            salesData.forEach((productName, sales) -> {
                Double profit = profitData.getOrDefault(productName, 0.0);
                System.out.println("Product: " + productName + ", Sales: " + sales + ", Profit: " + profit);
            });
        }}

    public String getSalesAndProfitsReport() {
        StringBuilder report = new StringBuilder("Sales and Profits Report:\n");
        if (salesData.isEmpty() && profitData.isEmpty()) {
            report.append("No sales or profits data available.");
        } else {
            salesData.forEach((productName, sales) -> {
                Double profit = profitData.getOrDefault(productName, 0.0);
                report.append("Product: ").append(productName)
                      .append(", Sales: ").append(sales)
                      .append(", Profit: ").append(profit)
                      .append("\n");
            });
        }
        return report.toString();
    }

    public boolean productExists(String productName) {
        return products.containsKey(productName);
    }

    public void addSalesData(String productName, double salesCount) {
        salesData.put(productName, salesCount);
        System.out.println("Sales data added/updated for product: " + productName + " with sales: " + salesCount);
    }

    public void addProfitData(String productName, double profit) {
        profitData.put(productName, profit);
        System.out.println("Profit data added/updated for product: " + productName + " with profit: " + profit);
    }
    
    
    public void addProduct(Product product) {
        if (product != null && product.getName() != null && !product.getName().isEmpty()) {
            products.put(product.getName(), product);
            System.out.println("Product added: " + product.getName());
        } else {
            System.out.println("Invalid product or product name.");
        }
    }

    // Retrieves a product by name
   

    // Removes a product by name
    public void removeProduct(String productName) {
        if (productName != null && !productName.isEmpty() && products.containsKey(productName)) {
            products.remove(productName);
            System.out.println("Product removed: " + productName);
        } else {
            throw new IllegalArgumentException("Product not found: " + productName);
        }
    }
    public boolean updateProduct(String productName, String newDescription, double newPrice, int newQuantity) {
        Product product = products.get(productName);
        
        if (product != null) {
            product.setDescription(newDescription);
            product.setPrice(newPrice);
            product.setQuantity(newQuantity);
            System.out.println("Product updated: " + productName);
            return true;
        } else {
            System.out.println("Product not found: " + productName);
            return false;
        }
    }

    
}
