package najah.edu;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OrderService {
    private Map<String, String> orders = new HashMap<>();

    public String receiveOrder(String productName) {
        String orderId = UUID.randomUUID().toString(); // Unique identifier for each order
        orders.put(orderId, "Pending: " + productName);
        return orderId; // Return the order ID for further reference
    }

    public boolean processOrder(String orderId, String status) {
        if (orders.containsKey(orderId)) {
            orders.put(orderId, status);
            return true;
        }
        return false; // Order ID not found
    }

    public String getOrderStatus(String orderId) {
        return orders.getOrDefault(orderId, "Order not found");
    }

    public Map<String, String> viewOrders() {
        return new HashMap<>(orders); // Return a copy of the orders
    }
}
