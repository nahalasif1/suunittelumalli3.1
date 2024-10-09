package chainOfResponsibility;

public abstract class AbstractFeedbackHandler {
    protected AbstractFeedbackHandler nextHandler;

    public void setNextHandler(AbstractFeedbackHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void processFeedback(FeedbackMessage feedbackMessage);
}
