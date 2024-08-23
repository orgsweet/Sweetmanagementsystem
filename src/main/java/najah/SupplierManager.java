package najah;

import java.util.HashMap;
import java.util.Map;

public class SupplierManager {
    private Map<String, String> suppliers = new HashMap<>();
    private Admin admin;

    public SupplierManager(Admin admin) {
        this.admin = admin;
    }

    public SupplierManager(String string, String string2) {
        // Initialize SupplierManager with dummy values if needed
        System.out.println("SupplierManager created with parameters: " + string + ", " + string2);
    }

    public void addSupplier(String id, String name, String email) {
        // Add supplier logic
        suppliers.put(id, name);
        System.out.println("Supplier added: " + name + " with email: " + email);
    }

    public boolean isSupplierAdded(String id) {
        return suppliers.containsKey(id);
    }

    public boolean login(String username, String password) {
        // Implement login logic (example implementation)
        if (username != null && password != null) {
            // Dummy implementation: validate username and password
            return username.equals("admin") && password.equals("admin123");
        }
        return false;
    }
}
