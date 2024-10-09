package chainOfResponsibility;

public class FeedbackSystemApplication {
    public static void main(String[] args) {
        // Set up the chain of handlers
        AbstractFeedbackHandler claimHandler = new ClaimHandler();
        AbstractFeedbackHandler inquiryHandler = new InquiryHandler();
        AbstractFeedbackHandler suggestionHandler = new SuggestionHandler();
        AbstractFeedbackHandler generalFeedbackHandler = new GeneralFeedbackHandler();

        claimHandler.setNextHandler(inquiryHandler);
        inquiryHandler.setNextHandler(suggestionHandler);
        suggestionHandler.setNextHandler(generalFeedbackHandler);

        // Create various feedback messages
        FeedbackMessage claimMessage = new FeedbackMessage(FeedbackType.COMPENSATION_CLAIM,
                "Requesting compensation for service delay.", "user1@example.com");
        FeedbackMessage inquiryMessage = new FeedbackMessage(FeedbackType.INQUIRY,
                "I have a question about my order status.", "user2@example.com");
        FeedbackMessage suggestionMessage = new FeedbackMessage(FeedbackType.SUGGESTION,
                "Please consider adding a feedback feature to the app.", "user3@example.com");
        FeedbackMessage generalFeedbackMessage = new FeedbackMessage(FeedbackType.GENERAL_FEEDBACK,
                "The service was excellent. Thank you!", "user4@example.com");

        // Process each message
        System.out.println("Handling Compensation Claim:");
        claimHandler.processFeedback(claimMessage);
        System.out.println();

        System.out.println("Handling Inquiry:");
        claimHandler.processFeedback(inquiryMessage);
        System.out.println();

        System.out.println("Handling Suggestion:");
        claimHandler.processFeedback(suggestionMessage);
        System.out.println();

        System.out.println("Handling General Feedback:");
        claimHandler.processFeedback(generalFeedbackMessage);
    }
}
