package najah.edu;

import java.util.*;

public class StoreService {

    private Map<String, Product> productCatalog;
    private Map<String, Integer> salesTracker; // Tracks sales for each product

    public StoreService() {
        productCatalog = new HashMap<>();
        salesTracker = new HashMap<>();
    }

   
    public boolean addProduct(String name, String description, double price, int quantity) {
        if (productCatalog.containsKey(name)) {
            return false; // Product already exists
        }
        productCatalog.put(name, new Product(name, description, price, quantity));
        return true;
    }




    public boolean updateProduct(String productName, String description, double price, int quantity) {
        Product product = productCatalog.get(productName);
        if (product == null) {
            return false;
        }
        product.setDescription(description);
        product.setPrice(price);
        product.setQuantity(quantity);
        return true;
    }

    public boolean setDiscount(String productName, int discountPercentage) {
        Product product = productCatalog.get(productName);
        if (product == null) {
            return false;
        }
        double originalPrice = product.getOriginalPrice();
        double discountAmount = originalPrice * discountPercentage / 100;
        double newPrice = originalPrice - discountAmount;
        product.setPrice(newPrice);
        return true;
    }

    public Product getProduct(String productName) {
        return productCatalog.get(productName);
    }

    public double getOriginalPrice(String productName) {
        Product product = getProduct(productName);
        return (product != null) ? product.getOriginalPrice() : 0.0;
    }

    public int getDiscount(String productName) {
        // Implement logic to return the discount percentage
        // Assuming you might need a field in Product to store this
        return 10; // Placeholder for demo purposes
    }

    public boolean removeProduct(String productName) {
        return productCatalog.remove(productName) != null;
    }

    public void sellProduct(String productName, int quantity) {
        Product product = productCatalog.get(productName);
        if (product != null) {
            int remainingQuantity = product.getQuantity() - quantity;
            product.setQuantity(remainingQuantity);
            salesTracker.put(productName, salesTracker.getOrDefault(productName, 0) + quantity);
        }
    }

    public char[] viewBestSellingProducts() {
        if (salesTracker.isEmpty()) {
            return "No sales data available.".toCharArray(); // Return a message if no sales data exists
        }

        // Sort products by sales in descending order
        List<Map.Entry<String, Integer>> bestSellingProducts = new ArrayList<>(salesTracker.entrySet());
        bestSellingProducts.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // Build the report
        StringBuilder report = new StringBuilder("Best-Selling Products Report:\n");
        for (Map.Entry<String, Integer> entry : bestSellingProducts) {
            report.append(entry.getKey()).append(": ").append(entry.getValue()).append(" units sold\n");
        }
        return report.toString().toCharArray();
    }


    public char[] viewSalesAndProfits() {
        if (salesTracker.isEmpty()) {
            return "No sales data available.".toCharArray(); // Return a message if no sales data exists
        }

        // Calculate total sales and profits
        double totalSales = 0;
        double totalProfit = 0;
        StringBuilder report = new StringBuilder("Sales and Profits Report:\n");

        for (Map.Entry<String, Integer> entry : salesTracker.entrySet()) {
            String productName = entry.getKey();
            int quantitySold = entry.getValue();
            Product product = productCatalog.get(productName);

            if (product != null) {
                double sales = quantitySold * product.getPrice();
                double profit = sales - (quantitySold * product.getOriginalPrice());

                totalSales += sales;
                totalProfit += profit;

                report.append("Product: ").append(productName)
                      .append(", Quantity Sold: ").append(quantitySold)
                      .append(", Sales: ").append(sales)
                      .append(", Profit: ").append(profit).append("\n");
            }
        }

        report.append("Total Sales: ").append(totalSales)
              .append(", Total Profit: ").append(totalProfit);

        return report.toString().toCharArray();
    }
    
    private boolean loggedIn = false; // Track login status

    public boolean signIn(String username, String password) {
        // Your sign-in logic
        loggedIn = true; // Set loggedIn to true on successful sign-in
        return true;
    }

    public boolean logout() {
        // Your logout logic
        if (loggedIn) {
            loggedIn = false;
            return true;
        }
        return false;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }


    public static class Product {
        private String name;
        private String description;
        private double price;
        private double originalPrice;
        private int quantity;

        public Product(String name, String description, double price, int quantity) {
            this.name = name;
            this.description = description;
            this.price = price;
            this.originalPrice = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getOriginalPrice() {
            return originalPrice;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
    public Product getProduct1(String productName) {
        return productCatalog.get(productName);
    }
}
