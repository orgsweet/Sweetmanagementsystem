package najah.edu;

public class DessertService {

    public String browseDesserts() {
        // Simulate browsing desserts
        System.out.println("Browsing desserts...");
        return "Dessert List: Chocolate Cake, Vanilla Pudding, Fruit Tart";
    }

    public String searchDesserts(String searchTerm) {
        // Simulate searching for desserts
        System.out.println("Searching for desserts with term: " + searchTerm);
        return "Search Results: Chocolate Cake, Chocolate Brownie";
    }

    public String filterDesserts(String filter) {
        // Simulate filtering desserts
        System.out.println("Applying filter: " + filter);
        return "Filtered Results: Gluten-Free Chocolate Cake, Gluten-Free Brownie";
    }
}
