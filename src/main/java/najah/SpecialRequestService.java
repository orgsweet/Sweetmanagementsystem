package najah;

public class SpecialRequestService {

    /**
     * Simulates receiving a special request with details, user email, and request ID.
     *
     * @param details   The details of the special request.
     * @param userEmail The email of the user making the request.
     * @param requestId The unique ID of the request.
     * @return A SpecialRequest object with the provided details.
     */
    public SpecialRequest receiveRequest(String details, String userEmail, String requestId) {
        return new SpecialRequest(details, userEmail, requestId);
    }

    /**
     * Simulates receiving a special request with default details.
     *
     * @return A SpecialRequest object with default details.
     */
    public SpecialRequest receiveRequest() {
        // Simulate receiving a special request with default values
        return new SpecialRequest("Default special request details", "default@example.com", "REQ-0001");
    }

    /**
     * Example method to process a special request.
     *
     * @param request The SpecialRequest to process.
     * @return A confirmation message indicating the request has been processed.
     */
    public String processRequest(SpecialRequest request) {
        // Simulate processing the special request
        return "Request with ID: " + request.getRequestId() + " has been processed.";
    }
}
