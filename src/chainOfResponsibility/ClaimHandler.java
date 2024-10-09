package chainOfResponsibility;

public class ClaimHandler extends AbstractFeedbackHandler {
    @Override
    public void processFeedback(FeedbackMessage feedbackMessage) {
        if (feedbackMessage.getFeedbackType() == FeedbackType.COMPENSATION_CLAIM) {
            System.out.println("Processing compensation claim: " + feedbackMessage.getMessageContent());
            // Logic to handle the claim
        } else if (nextHandler != null) {
            nextHandler.processFeedback(feedbackMessage);
        }
    }
}
