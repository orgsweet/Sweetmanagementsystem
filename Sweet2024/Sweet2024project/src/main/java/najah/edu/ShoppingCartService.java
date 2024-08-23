package najah.edu;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartService {
    private List<String> cartItems = new ArrayList<>();

    // Adds an item to the cart
    public boolean addToCart(String item) {
        if (item != null && !item.isEmpty()) {
            cartItems.add(item);
            System.out.println("Item added to cart: " + item);
            return true;
        }
        return false;
    }

    // Removes an item from the cart
    public boolean removeFromCart(String item) {
        if (cartItems.contains(item)) {
            cartItems.remove(item);
            System.out.println("Item removed from cart: " + item);
            return true;
        }
        return false;
    }

    // Checks out all items in the cart
    public boolean checkout() {
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty. Cannot proceed with checkout.");
            return false;
        }
        // Process the payment (mock implementation)
        System.out.println("Checking out items: " + cartItems);
        cartItems.clear(); // Clear the cart after checkout
        return true;
    }

    // Views the items in the cart
    public List<String> viewCart() {
        return new ArrayList<>(cartItems); // Return a copy of the cart items
    }
}
