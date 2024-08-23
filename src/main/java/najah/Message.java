package najah;

public class Message {
    private String sender;
    private String recipient;
    private String subject;
    private String body;

    public Message(String sender, String recipient, String subject, String body) {
        this.sender = sender;
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    /**
     * Gets the recipient's email. Alias for getRecipient().
     *
     * @return The recipient's email address.
     */
    public String getRecipientEmail() {
        return recipient;
    }
}
