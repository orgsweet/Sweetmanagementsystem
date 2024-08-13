package najah.edu;

import java.util.Scanner;

public class MyApplication {

    private AdminService adminService;
    private StoreService storeService;
    private ContentService contentService;
    private DessertService dessertService;
    private FeedbackService feedbackService;
    private MessagingService messagingService;
    private OrderService orderService;
    private ProductService productService;
    private ReportService reportService;
    private ShoppingCartService shoppingCartService;
    private UserService userService;

    private String currentRole;

    // Constructor
    public MyApplication() {
        // Initialize services
        adminService = new AdminService();
        storeService = new StoreService();
        contentService = new ContentService();
        dessertService = new DessertService();
        feedbackService = new FeedbackService();
        messagingService = new MessagingService();
        orderService = new OrderService();
        productService = new ProductService();
        reportService = new ReportService();
        shoppingCartService = new ShoppingCartService();
        userService = new UserService();
        
        currentRole = null; // No role is assigned initially
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            System.out.println("Welcome to Sweet Management System!");
            System.out.println("1. Sign In");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    handleSignIn(scanner);
                    break;
                case 2:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private void handleSignIn(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.println("Select your role:");
        System.out.println("1. Admin");
        System.out.println("2. Store Owner");
        System.out.println("3. Supplier");
        System.out.println("4. Beneficiary User");
        System.out.print("Choose a role: ");
        int roleChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (roleChoice) {
            case 1:
                currentRole = "Admin";
                if (adminService.signIn(username, password)) {
                    adminDashboard(scanner);
                } else {
                    System.out.println("Invalid credentials for Admin.");
                }
                break;
            case 2:
                currentRole = "Store Owner";
                if (storeService.signIn(username, password)) {
                    storeOwnerDashboard(scanner);
                } else {
                    System.out.println("Invalid credentials for Store Owner.");
                }
                break;
            case 3:
                currentRole = "Supplier";
                if (userService.signIn(username, password)) {
                    supplierDashboard(scanner);
                } else {
                    System.out.println("Invalid credentials for Supplier.");
                }
                break;
            case 4:
                currentRole = "Beneficiary User";
                if (userService.signIn(username, password)) {
                    beneficiaryUserDashboard(scanner);
                } else {
                    System.out.println("Invalid credentials for Beneficiary User.");
                }
                break;
            default:
                System.out.println("Invalid role selection.");
        }
    }

    private void adminDashboard(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("Admin Dashboard");
            System.out.println("1. Manage Users");
            System.out.println("2. Monitor and Reporting");
            System.out.println("3. Content Management");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageUsers(scanner);
                    break;
                case 2:
                    monitorAndReport(scanner);
                    break;
                case 3:
                    manageContent(scanner);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void manageUsers(Scanner scanner) {
        System.out.println("User Management");
        System.out.println("1. Add User");
        System.out.println("2. Remove User");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                System.out.print("Enter role: ");
                String role = scanner.nextLine();
                if (adminService.addUser(username, password, role)) {
                    System.out.println("User added successfully.");
                } else {
                    System.out.println("Failed to add user.");
                }
                break;
            case 2:
                System.out.print("Enter username to remove: ");
                String userToRemove = scanner.nextLine();
                if (adminService.removeUser(userToRemove)) {
                    System.out.println("User removed successfully.");
                } else {
                    System.out.println("Failed to remove user.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void monitorAndReport(Scanner scanner) {
        System.out.println("Monitoring and Reporting");
        System.out.println("1. Generate Profit Report");
        System.out.println("2. Identify Best-Selling Products");
        System.out.println("3. User Statistics by City");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.println(reportService.generateProfitReport());
                break;
            case 2:
                System.out.println(storeService.viewBestSellingProducts());
                break;
            case 3:
                System.out.println(reportService.generateUserStatisticsByCity());
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void manageContent(Scanner scanner) {
        System.out.println("Content Management");
        System.out.println("1. Review Content");
        System.out.println("2. Remove Feedback");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                if (contentService.reviewContent(currentRole, false)) {
                    System.out.println("Content reviewed successfully.");
                } else {
                    System.out.println("Failed to review content.");
                }
                break;
            case 2:
                System.out.print("Enter feedback ID to remove: ");
                String feedbackId = scanner.nextLine();
                if (contentService.removeFeedback(feedbackId)) {
                    System.out.println("Feedback removed successfully.");
                } else {
                    System.out.println("Failed to remove feedback.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void storeOwnerDashboard(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("Store Owner Dashboard");
            System.out.println("1. Manage Products");
            System.out.println("2. View Sales and Profits");
            System.out.println("3. Best-Selling Products");
            System.out.println("4. Manage Orders");
            System.out.println("5. Communication and Notifications");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageProducts(scanner);
                    break;
                case 2:
                    System.out.println(storeService.viewSalesAndProfits());
                    break;
                case 3:
                    System.out.println(storeService.viewBestSellingProducts());
                    break;
                case 4:
                    manageOrders(scanner);
                    break;
                case 5:
                    communicationAndNotifications(scanner);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void manageProducts(Scanner scanner) {
        System.out.println("Product Management");
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Remove Product");
        System.out.println("4. Set Discount");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter product name: ");
                String name = scanner.nextLine();
                System.out.print("Enter description: ");
                String description = scanner.nextLine();
                System.out.print("Enter price: ");
                double price = scanner.nextDouble();
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                if (productService.addProduct(name, price)) {
                    System.out.println("Product added successfully.");
                } else {
                    System.out.println("Failed to add product.");
                }
                break;
            case 2:
                System.out.print("Enter product name: ");
                String nameToUpdate = scanner.nextLine();
                System.out.print("Enter new description: ");
                String newDescription = scanner.nextLine();
                System.out.print("Enter new price: ");
                double newPrice = scanner.nextDouble();
                System.out.print("Enter new quantity: ");
                int newQuantity = scanner.nextInt();
                if (productService.updateProduct(nameToUpdate, newDescription, newPrice, newQuantity)) {
                    System.out.println("Product updated successfully.");
                } else {
                    System.out.println("Failed to update product.");
                }
                break;
            case 3:
                System.out.print("Enter product name to remove: ");
                String nameToRemove = scanner.nextLine();
                if (productService.removeProduct(nameToRemove)) {
                    System.out.println("Product removed successfully.");
                } else {
                    System.out.println("Failed to remove product.");
                }
                break;
            case 4:
                System.out.print("Enter product name to discount: ");
                String productName = scanner.nextLine();
                System.out.print("Enter discount percentage: ");
                int discountPercentage = scanner.nextInt();
                if (productService.setDiscount(productName, discountPercentage)) {
                    System.out.println("Discount applied successfully.");
                } else {
                    System.out.println("Failed to apply discount.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void manageOrders(Scanner scanner) {
        System.out.println("Order Management");
        System.out.println("1. Receive Order");
        System.out.println("2. Process Order");
        System.out.println("3. View Orders");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter product name to receive order: ");
                String productName = scanner.nextLine();
                if (orderService.receiveOrder(productName) != null) {
                    System.out.println("Order received successfully.");
                } else {
                    System.out.println("Failed to receive order.");
                }
                break;
            case 2:
                System.out.print("Enter new status for the order: ");
                String status = scanner.nextLine();
			String orderId = null;
			if (orderService.processOrder(orderId, status)) {
                    System.out.println("Order status updated successfully.");
                } else {
                    System.out.println("Failed to update order status.");
                }
                break;
            case 3:
                System.out.println(orderService.viewOrders());
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void communicationAndNotifications(Scanner scanner) {
        System.out.println("Communication and Notifications");
        System.out.println("1. Send Message");
        System.out.println("2. Check Notifications (Bonus)");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter recipient's email: ");
                String email = scanner.nextLine();
                System.out.print("Enter subject: ");
                String subject = scanner.nextLine();
                System.out.print("Enter message body: ");
                String body = scanner.nextLine();
                if (messagingService.sendMessage(email, subject, body)) {
                    System.out.println("Message sent successfully.");
                } else {
                    System.out.println("Failed to send message.");
                }
                break;
            case 2:
                // Bonus functionality: Implement notification checking if needed
                System.out.println("Notification feature is optional.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private void supplierDashboard(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("Supplier Dashboard");
            System.out.println("1. Manage Products");
            System.out.println("2. Communication and Notifications");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageProducts(scanner);
                    break;
                case 2:
                    communicationAndNotifications(scanner);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void beneficiaryUserDashboard(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("Beneficiary User Dashboard");
            System.out.println("1. Explore Desserts");
            System.out.println("2. Search Desserts");
            System.out.println("3. Filter Desserts");
            System.out.println("4. Manage Account");
            System.out.println("5. Provide Feedback");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println(dessertService.browseDesserts());
                    break;
                case 2:
                    System.out.print("Enter search term: ");
                    String searchTerm = scanner.nextLine();
                    System.out.println(dessertService.searchDesserts(searchTerm));
                    break;
                case 3:
                    System.out.print("Enter filter (e.g., Gluten-Free): ");
                    String filter = scanner.nextLine();
                    System.out.println(dessertService.filterDesserts(filter));
                    break;
                case 4:
                    manageAccount(scanner);
                    break;
                case 5:
                    provideFeedback(scanner);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void manageAccount(Scanner scanner) {
        System.out.println("Account Management");
        // Implement functionalities for account management
    }

    private void provideFeedback(Scanner scanner) {
        System.out.println("Provide Feedback");
        System.out.print("Enter rating: ");
        String rating = scanner.nextLine();
        System.out.print("Enter comment: ");
        String comment = scanner.nextLine();
        if (feedbackService.submitFeedback(rating, comment)) {
            System.out.println("Feedback submitted successfully.");
        } else {
            System.out.println("Failed to submit feedback.");
        }
    }

    public static void main(String[] args) {
        MyApplication app = new MyApplication();
        app.start();
    }
}
