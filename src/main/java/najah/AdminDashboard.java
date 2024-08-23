package najah;

import java.util.ArrayList;
import java.util.List;

public class AdminDashboard {
    private List<String> recipes;
    private List<String> posts;
    private List<String> feedback;
    private List<String> bestSellingProducts;
    private List<String> userStatistics;
    private List<String> financialReports;
    private Admin admin; // Admin object
    private ContentManager contentManager; // ContentManager object

    public AdminDashboard() {
        // Initialize lists with sample data
        recipes = new ArrayList<>();
        recipes.add("Recipe1");
        recipes.add("Recipe2");

        posts = new ArrayList<>();
        posts.add("Post1");
        posts.add("Post2");

        feedback = new ArrayList<>();
        feedback.add("User1: Great App!");
        feedback.add("User2: Could be improved.");

        bestSellingProducts = new ArrayList<>();
        bestSellingProducts.add("Product1");
        bestSellingProducts.add("Product2");

        userStatistics = new ArrayList<>();
        userStatistics.add("Nablus: 10 Users");
        userStatistics.add("Jenin: 5 Users");

        financialReports = new ArrayList<>();
        financialReports.add("Profit: $10,000");
        financialReports.add("Loss: $1,000");

        // Initialize ContentManager with this AdminDashboard instance
        contentManager = new ContentManager(this);
    }

    // Simulating login method
    public boolean login(String username, String password) {
        if ("adminUsername".equals(username) && "adminPassword".equals(password)) {
            System.out.println("Admin logged in successfully!");
            return true;
        } else {
            System.out.println("Login failed. Incorrect username or password.");
            return false;
        }
    }

    // View all content (recipes and posts)
    public List<String> viewContent() {
        List<String> content = new ArrayList<>();
        content.addAll(recipes);
        content.addAll(posts);
        return content;
    }

    // Edit content (recipes or posts)
    public void editContent(String oldContent, String newContent) {
        int recipeIndex = recipes.indexOf(oldContent);
        if (recipeIndex != -1) {
            recipes.set(recipeIndex, newContent);
            System.out.println("Recipe updated: " + oldContent + " -> " + newContent);
            return;
        }

        int postIndex = posts.indexOf(oldContent);
        if (postIndex != -1) {
            posts.set(postIndex, newContent);
            System.out.println("Post updated: " + oldContent + " -> " + newContent);
            return;
        }

        System.out.println("Content not found: " + oldContent);
    }

    // Delete a post
    public void deletePost(String post) {
        if (posts.remove(post)) {
            System.out.println("Post deleted successfully.");
        } else {
            System.out.println("Post not found: " + post);
        }
    }

    // View feedback
    public List<String> viewFeedback() {
        return new ArrayList<>(feedback);
    }

    // Respond to a feedback item
    public boolean respondToFeedback(String feedbackItem, String response) {
        int index = feedback.indexOf(feedbackItem);
        if (index != -1) {
            System.out.println("Responding to feedback: " + feedbackItem);
            System.out.println("Response: " + response);
            return true;
        } else {
            System.out.println("Feedback not found: " + feedbackItem);
            return false;
        }
    }

    // View financial reports
    public List<String> viewFinancialReports() {
        return new ArrayList<>(financialReports);
    }

    // View best selling products
    public List<String> viewBestSellingProducts() {
        return new ArrayList<>(bestSellingProducts);
    }

    // View user statistics
    public List<String> viewUserStatistics() {
        return new ArrayList<>(userStatistics);
    }

    // View user feedback
    public List<String> viewUserFeedback() {
        return new ArrayList<>(feedback);
    }

    // View recipes and posts combined
    public List<String> viewRecipesAndPosts() {
        List<String> allContent = new ArrayList<>();
        allContent.addAll(recipes);
        allContent.addAll(posts);
        return allContent;
    }

    // Edit a specific recipe
    public void editRecipe(String oldRecipe, String newRecipe) {
        int index = recipes.indexOf(oldRecipe);
        if (index != -1) {
            recipes.set(index, newRecipe);
            System.out.println("Recipe updated successfully.");
        } else {
            System.out.println("Recipe not found: " + oldRecipe);
        }
    }

    // Get the current admin
    public Admin getAdmin() {
        return this.admin;
    }

    // Set the content manager
    public void setContentManager(ContentManager contentManager) {
        this.contentManager = contentManager;
        System.out.println("Content manager assigned successfully.");
    }
}
