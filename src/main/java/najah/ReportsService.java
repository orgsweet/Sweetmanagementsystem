package najah;

import java.util.ArrayList;

import java.util.List;

public class ReportsService {
    private Admin admin;

    /**
     * Constructor that requires an admin to access the reports service.
     *
     * @param admin The admin user accessing the reports service.
     * @throws IllegalStateException if the admin is not logged in.
     */
    public ReportsService(Admin admin) {
        if (admin != null && admin.isLoggedIn()) {
            this.admin = admin;
        } else {
            throw new IllegalStateException("Admin not logged in");
        }
    }

    // Default constructor (only used if there's a reason to initialize without an admin)
    public ReportsService() {
        // No-op constructor
    }

    /**
     * Simulates generating financial reports.
     *
     * @return A list of financial report strings.
     */
    public List<String> generateFinancialReports() {
        List<String> reports = new ArrayList<>();
        reports.add("Profit: $5000");
        reports.add("Expenses: $2000");
        reports.add("Net Profit: $3000");
        return reports;
    }

    /**
     * Simulates generating best-selling product reports.
     *
     * @return A list of best-selling product strings.
     */
    public List<String> generateBestSellingProducts() {
        List<String> bestSellingProducts = new ArrayList<>();
        bestSellingProducts.add("Chocolate Cake");
        bestSellingProducts.add("Cupcakes");
        bestSellingProducts.add("Cheesecake");
        return bestSellingProducts;
    }

    /**
     * Simulates generating user statistics by city.
     *
     * @return A list of user statistics strings by city.
     */
    public List<String> generateUserStatisticsByCity() {
        List<String> userStatistics = new ArrayList<>();
        userStatistics.add("Nablus: 100 users");
        userStatistics.add("Jenin: 50 users");
        return userStatistics;
    }

    /**
     * Navigates to the financial reports section.
     */
    public void navigateToFinancialReports() {
        System.out.println("Navigating to financial reports section...");
    }

    /**
     * Navigates to the user statistics section.
     */
    public void navigateToUserStatistics() {
        System.out.println("Navigating to user statistics section...");
    }

    /**
     * Retrieves the financial reports.
     *
     * @return A list of financial reports.
     */
    public List<String> getFinancialReports() {
        return generateFinancialReports();
    }

    /**
     * Retrieves the best-selling products.
     *
     * @return A list of best-selling products.
     */
    public List<String> getBestSellingProducts() {
        return generateBestSellingProducts();
    }

    /**
     * Retrieves user statistics by city.
     *
     * @return A list of user statistics by city.
     */
    public List<String> getUserStatisticsByCity() {
        return generateUserStatisticsByCity();
    }
}
