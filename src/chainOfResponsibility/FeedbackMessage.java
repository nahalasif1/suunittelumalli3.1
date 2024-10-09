package chainOfResponsibility;

public class FeedbackMessage {
    private FeedbackType feedbackType;
    private String messageContent;
    private String userEmail;

    public FeedbackMessage(FeedbackType feedbackType, String messageContent, String userEmail) {
        this.feedbackType = feedbackType;
        this.messageContent = messageContent;
        this.userEmail = userEmail;
    }

    public FeedbackType getFeedbackType() {
        return feedbackType;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
