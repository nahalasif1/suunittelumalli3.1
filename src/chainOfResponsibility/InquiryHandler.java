package chainOfResponsibility;

public class InquiryHandler extends AbstractFeedbackHandler {
    @Override
    public void processFeedback(FeedbackMessage feedbackMessage) {
        if (feedbackMessage.getFeedbackType() == FeedbackType.INQUIRY) {
            System.out.println("Routing inquiry to support: " + feedbackMessage.getMessageContent());

        } else if (nextHandler != null) {
            nextHandler.processFeedback(feedbackMessage);
        }
    }
}
