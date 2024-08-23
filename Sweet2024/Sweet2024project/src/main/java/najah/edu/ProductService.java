package najah.edu;

import java.util.HashMap;
import java.util.Map;

public class ProductService {
    private Map<String, Product> productStore = new HashMap<>();

    public boolean addProduct(String productName, double price) {
        if (productStore.containsKey(productName)) {
            System.out.println("Product already exists.");
            return false; // Product already exists
        }
        productStore.put(productName, new Product(productName, productName, price, 0));
        System.out.println("Product added: " + productName);
        return true; // Product added successfully
    }

    public boolean updateProduct(String name, String description, double price, int quantity) {
        Product product = productStore.get(name);
        if (product == null) {
            return false; // Product does not exist
        }
        product.setDescription(description);
        product.setPrice(price);
        product.setQuantity(quantity);
        return true;
    }

    public boolean removeProduct(String name) {
        return productStore.remove(name) != null;
    }

    public boolean setDiscount(String productName, int discountPercentage) {
        Product product = productStore.get(productName);
        if (product == null) {
            return false; // Product does not exist
        }
        double newPrice = product.getPrice() * (1 - discountPercentage / 100.0);
        product.setPrice(newPrice);
        return true;
    }

    public Product getProduct(String name) {
        return productStore.get(name);
    }

    // Inner class to represent a Product
    class Product {
        private String name;
        private String description;
        private double price;
        private int quantity;

        public Product(String name, String description, double price, int quantity) {
            this.name = name;
            this.description = description;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() { return name; }
        public String getDescription() { return description; }
        public double getPrice() { return price; }
        public int getQuantity() { return quantity; }
        public void setDescription(String description) { this.description = description; }
        public void setPrice(double price) { this.price = price; }
        public void setQuantity(int quantity) { this.quantity = quantity; }
    }
}
