package chainOfResponsibility;

public class SuggestionHandler extends AbstractFeedbackHandler {
    @Override
    public void processFeedback(FeedbackMessage feedbackMessage) {
        if (feedbackMessage.getFeedbackType() == FeedbackType.SUGGESTION) {
            System.out.println("Logging user suggestion: " + feedbackMessage.getMessageContent());


        } else if (nextHandler != null) {
            nextHandler.processFeedback(feedbackMessage);
        }
    }
}
