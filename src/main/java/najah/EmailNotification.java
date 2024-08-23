package najah;

public class EmailNotification {
    private String recipient;
    private String subject;
    private String body;

    public EmailNotification(String recipient, String subject, String body) {
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
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

    public String getMessage() {
        // Construct a message string from the notification details
        return "To: " + recipient + "\nSubject: " + subject + "\nBody: " + body;
    }

    @Override
    public String toString() {
        return "EmailNotification{" +
               "recipient='" + recipient + '\'' +
               ", subject='" + subject + '\'' +
               ", body='" + body + '\'' +
               '}';
    }

 

	public static boolean isNotificationSent(String username, String string) {
		// TODO Auto-generated method stub
		return false;
	}
}
