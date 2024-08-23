package najah.edu.acceptance_tests;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import najah.edu.OrderService;
import najah.edu.StoreService;

import java.util.HashMap;
import java.util.Map;

public class order {

    private OrderService orderService;
    private StoreService storeService;
    private boolean actionSuccess;
    private String orderStatus;
    private Map<String, String> orders;
    private String orderId;

   
    @Before
    public void setup() {
        // Initialize OrderService here
        orderService = new OrderService();
    }

    @When("I receive a new order for {string}")
    public void i_receive_a_new_order_for(String productName) {
        Assert.assertNotNull("OrderService should be initialized.", orderService);
        orderId = orderService.receiveOrder(productName); // Save the order ID
        actionSuccess = (orderId != null && !orderId.isEmpty());
        Assert.assertTrue("Order should be received successfully.", actionSuccess);
    }

    @Then("I should be able to process the order and update the status to {string}")
    public void i_should_be_able_to_process_the_order_and_update_the_status_to(String status) {
        Assert.assertNotNull("OrderService should be initialized.", orderService);
        Assert.assertNotNull("Order ID should be set.", orderId);

        actionSuccess = orderService.processOrder(orderId, status);
        Assert.assertTrue("Order processing should be successful.", actionSuccess);

        orderStatus = orderService.getOrderStatus(orderId);
        Assert.assertEquals("Order status should be updated correctly.", status, orderStatus);
    }

    @When("I view the orders page")
    public void i_view_the_orders_page() {
        Assert.assertNotNull("OrderService should be initialized.", orderService);
        orders = orderService.viewOrders();
    }

    @Then("I should see the status of all orders")
    public void i_should_see_the_status_of_all_orders() {
        Assert.assertNotNull("Orders list should not be null.", orders);
        if (orders.isEmpty()) {
            System.out.println("No orders available.");
        } else {
            for (Map.Entry<String, String> entry : orders.entrySet()) {
                System.out.println("Order ID: " + entry.getKey() + ", Status: " + entry.getValue());
            }
        }
    }
}
