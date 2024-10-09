package chainOfResponsibility;

public class GeneralFeedbackHandler extends AbstractFeedbackHandler {
    @Override
    public void processFeedback(FeedbackMessage feedbackMessage) {
        if (feedbackMessage.getFeedbackType() == FeedbackType.GENERAL_FEEDBACK) {
            System.out.println("Analyzing general feedback: " + feedbackMessage.getMessageContent());


        } else if (nextHandler != null) {
            nextHandler.processFeedback(feedbackMessage);
        }
    }
}
