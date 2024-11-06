package Proxy;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        AccessControlService accessService = AccessControlService.getInstance();


        library.addUnprotectedDocument("doc1", "2024-11-01", "This is a public document.");
        library.addProtectedDocument("doc2", "2024-11-02", "This is a protected document.");


        User user1 = new User("user1");
        User user2 = new User("user2");


        accessService.grantAccess("doc2", "user1");


        try {
            System.out.println("User1 accessing doc1: " + library.getDocument("doc1").getContent(user1));
            System.out.println("User1 accessing doc2: " + library.getDocument("doc2").getContent(user1));
            System.out.println("User2 accessing doc2: " + library.getDocument("doc2").getContent(user2));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}
