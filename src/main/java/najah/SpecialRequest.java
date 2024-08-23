package najah;

public class SpecialRequest {
    private String details;
    private String userEmail;
    private String requestId;

    
     
    public SpecialRequest(String details, String userEmail, String requestId) {
        this.details = details;
        this.userEmail = userEmail;
        this.requestId = requestId;
    }

    /**
     * Constructor to initialize a SpecialRequest with a single string parameter.
     * This constructor might be used for simplicity or legacy code.
     *
     * @param details The details of the special request.
     */
    public SpecialRequest(String details) {
        this(details, "unknown@example.com", "unknown"); // Default values for simplicity
    }

    /**
     * Get the details of the special request.
     *
     * @return The details of the request.
     */
    public String getDetails() {
        return details;
    }

    /**
     * Get the email of the user who made the request.
     *
     * @return The email of the user.
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Get the unique ID of the request.
     *
     * @return The request ID.
     */
    public String getRequestId() {
        return requestId;
    }
}
