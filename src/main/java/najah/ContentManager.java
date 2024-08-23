package najah;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContentManager {
    private Admin admin;
    private List<String> posts; // Simulating posts
    private List<String> feedback; // Simulating feedback
    private List<String> recipes; // Simulating recipes
    private boolean actionsPerformed = false; // Track if any actions have been performed
    private boolean feedbackSectionAccessed = false; // Track if feedback section has been accessed
    private boolean onRecipesPage = false; // Track if currently on the recipes page

    // Constructor that requires an admin to access content management
    public ContentManager(Admin admin) {
        if (admin == null || !admin.isLoggedIn()) {
            throw new IllegalStateException("Admin not logged in");
        }
        this.admin = admin;
        this.posts = new ArrayList<>(Arrays.asList("Post1", "Post2"));
        this.feedback = new ArrayList<>();
        this.recipes = new ArrayList<>(Arrays.asList("Recipe1", "Recipe2"));
    }

    // Constructor for use with AdminDashboard
    public ContentManager(AdminDashboard adminDashboard) {
        this.posts = new ArrayList<>();
        this.feedback = new ArrayList<>();
        this.recipes = new ArrayList<>();
    }

    // Default constructor
    public ContentManager() {
        this.posts = new ArrayList<>();
        this.feedback = new ArrayList<>();
        this.recipes = new ArrayList<>();
    }

    // Method to simulate logging in as admin (placeholder)
    public boolean loginAsAdmin(String username, String password) {
        if (admin != null && admin.authenticate(username, password)) {
            return true;
        }
        return false;
    }

    // Method to simulate navigating to the content management section
    public void navigateToContentManagement() {
        System.out.println("Navigating to the content management section...");
        // Additional logic to navigate to the content management UI can be added here
    }

    // Methods to simulate post management
    public void viewPosts() {
        if (posts.isEmpty()) {
            System.out.println("No posts available.");
        } else {
            System.out.println("Viewing posts:");
            posts.forEach(post -> System.out.println("Post: " + post));
        }
        actionsPerformed = true; // Indicate that an action has been performed
    }

    public void editPost(String postId, String newContent) {
        // Simulate editing a post by ID (for simplicity, assume posts are strings)
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).contains(postId)) {
                posts.set(i, newContent); // Replace the post with new content
                System.out.println("Post updated.");
                actionsPerformed = true; // Indicate that an action has been performed
                return;
            }
        }
        System.out.println("Post not found.");
    }

    public void deletePost(String postId) {
        if (posts.removeIf(post -> post.contains(postId))) {
            System.out.println("Post deleted successfully.");
        } else {
            System.out.println("Post not found.");
        }
    }

    // Methods to simulate user feedback management
    public void navigateFeedbackSection() {
        System.out.println("Navigating to the feedback section...");
        feedbackSectionAccessed = true; // Indicate that feedback section has been accessed
    }

    public List<String> viewFeedback() {
        if (feedback.isEmpty()) {
            System.out.println("No feedback available.");
        } else {
            System.out.println("Viewing feedback:");
            feedback.forEach(fb -> System.out.println("Feedback: " + fb));
        }
        actionsPerformed = true; // Indicate that an action has been performed
        return feedback;
    }

    public boolean reviewFeedback(String feedbackId, String responseText) {
        // Simulate reviewing and responding to feedback
        if (feedback.size() > 0) {
            System.out.println("Responding to feedback ID: " + feedbackId);
            System.out.println("Response: " + responseText);
            actionsPerformed = true; // Indicate that an action has been performed
            return true;
        } else {
            System.out.println("No feedback available to respond.");
            return false;
        }
    }

    // Methods to check if feedback-related actions have been performed
    public boolean feedbackActionsPerformed() {
        return actionsPerformed;
    }

    public boolean feedbackSectionAccessed() {
        return feedbackSectionAccessed;
    }

    // Methods to simulate content management
    public void viewContent() {
        viewPosts(); // Display posts
        viewFeedback(); // Display feedback
    }

    public void editContent(String oldContent, String newContent) {
        int index = recipes.indexOf(oldContent);
        if (index != -1) {
            recipes.set(index, newContent);
        } else {
            index = posts.indexOf(oldContent);
            if (index != -1) {
                posts.set(index, newContent);
            }
        }
    }

    public void deleteContent(String content) {
        recipes.remove(content);
        posts.remove(content);
    }

    // Method to simulate navigating to and from the recipes page
    public void navigateToRecipesPage() {
        System.out.println("Navigating to the recipes page...");
        onRecipesPage = true; // Set to true when navigating to the recipes page
    }

    public void navigateAwayFromRecipesPage() {
        System.out.println("Navigating away from the recipes page...");
        onRecipesPage = false; // Set to false when navigating away
    }

    public boolean isOnRecipesPage() {
        return onRecipesPage; // Return the current state
    }

    // Methods related to recipes
    public void searchRecipes(String searchTerm) {
        // Simulate searching for recipes
        System.out.println("Searching for recipes with term: " + searchTerm);
    }

    public List<String> getSearchResults() {
        // Example implementation
        return Arrays.asList("Chocolate Cake Recipe", "Vanilla Cake Recipe"); // Replace with actual search results
    }

    public void editRecipe(String oldRecipe, String newRecipe) {
        for (int i = 0; i < recipes.size(); i++) {
            if (recipes.get(i).equals(oldRecipe)) {
                recipes.set(i, newRecipe);
                return;
            }
        }
    }

    public List<String> getRecipes() {
        return new ArrayList<>(recipes);
    }

    public List<String> getPosts() {
        return new ArrayList<>(posts);
    }

    public List<String> viewRecipesAndPosts() {
        List<String> recipesAndPosts = new ArrayList<>();
        if (recipes != null) {
            recipesAndPosts.addAll(recipes);
        }
        if (posts != null) {
            recipesAndPosts.addAll(posts);
        }
        return recipesAndPosts;
    }

    public void addRecipe(String recipe) {
        if (recipes != null) {
            recipes.add(recipe);
        }
    }

    public void addPost(String post) {
        if (posts != null) {
            posts.add(post);
        }
    }

    public boolean actionsPerformed() {
        // Returns whether any actions have been performed
        return actionsPerformed;
    }

    public void clickButton(String buttonLabel) {
        // Handle different button clicks based on the button label
        switch (buttonLabel.toLowerCase()) {
            case "view posts":
                viewPosts();
                break;
            case "edit post":
                // For demonstration, use dummy values or prompt for actual input
                String postId = "dummyPostId"; // Replace with actual ID
                String newContent = "Updated post content"; // Replace with actual content
                editPost(postId, newContent);
                break;
            case "delete post":
                // For demonstration, use dummy values or prompt for actual input
                String deletePostId = "dummyPostId"; // Replace with actual ID
                deletePost(deletePostId);
                break;
            case "view feedback":
                viewFeedback();
                break;
            case "review feedback":
                // For demonstration, use dummy values or prompt for actual input
                String feedbackId = "dummyFeedbackId"; // Replace with actual ID
                String responseText = "Response to feedback"; // Replace with actual response
                reviewFeedback(feedbackId, responseText);
                break;
            case "navigate to recipes":
                navigateToRecipesPage();
                break;
            case "search recipes":
                // For demonstration, use a dummy search term
                String searchTerm = "chocolate"; // Replace with actual search term
                searchRecipes(searchTerm);
                break;
            case "add recipe":
                // For demonstration, use a dummy recipe
                String newRecipe = "New Chocolate Cake Recipe"; // Replace with actual recipe
                addRecipe(newRecipe);
                break;
            case "add post":
                // For demonstration, use a dummy post
                String newPost = "New Blog Post"; // Replace with actual post
                addPost(newPost);
                break;
            default:
                System.out.println("No action defined for button: " + buttonLabel);
                break;
        }
        actionsPerformed = true; // Set to true if any button action is executed
    }

}
