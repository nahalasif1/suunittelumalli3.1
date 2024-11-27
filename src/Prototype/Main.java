package Prototype;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Predefined Recommendations
        Recommendation fantasyReaders = new Recommendation("Fantasy Readers");
        fantasyReaders.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 1937));
        fantasyReaders.addBook(new Book("Mistborn: The Final Empire", "Brandon Sanderson", "Fantasy", 2006));

        Recommendation romanceReaders = new Recommendation("Romance Readers");
        romanceReaders.addBook(new Book("Me Before You", "Jojo Moyes", "Romance", 2012));
        romanceReaders.addBook(new Book("Outlander", "Diana Gabaldon", "Romance", 1991));

        Recommendation clonedRecommendation = null;

        while (true) {
            System.out.println("\nBook Recommendation System");
            System.out.println("1. View Recommendations");
            System.out.println("2. Clone Recommendation");
            System.out.println("3. Modify Cloned Recommendation");
            System.out.println("4. Save and Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Display all recommendations
                    System.out.println("\nExisting Recommendations:");
                    System.out.println(fantasyReaders);
                    System.out.println(romanceReaders);
                    if (clonedRecommendation != null) {
                        System.out.println(clonedRecommendation);
                    }
                    break;

                case 2:
                    // Clone a recommendation
                    System.out.println("\nSelect a recommendation to clone:");
                    System.out.println("1. Fantasy Readers");
                    System.out.println("2. Romance Readers");
                    System.out.print("Enter choice: ");
                    int cloneChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    clonedRecommendation = (cloneChoice == 1)
                            ? fantasyReaders.clone()
                            : romanceReaders.clone();
                    System.out.println("Cloned recommendation created for " + clonedRecommendation.getTargetAudience());
                    break;

                case 3:
                    // Modify cloned recommendation
                    if (clonedRecommendation == null) {
                        System.out.println("No cloned recommendations available.");
                        break;
                    }
                    System.out.println("\n--- Modify Cloned Recommendations ---");
                    System.out.println("1. Add Book");
                    System.out.println("2. Remove Book");
                    System.out.println("3. Change Target Audience");
                    System.out.print("Choose: ");
                    int modifyChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (modifyChoice == 1) {
                        // Add book
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter genre: ");
                        String genre = scanner.nextLine();
                        System.out.print("Enter publication year: ");
                        int year = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        clonedRecommendation.addBook(new Book(title, author, genre, year));
                        System.out.println("Book added.");
                    } else if (modifyChoice == 2) {
                        // Remove book
                        System.out.println("Books in cloned recommendation:");
                        for (int i = 0; i < clonedRecommendation.getBooks().size(); i++) {
                            System.out.println((i + 1) + ". " + clonedRecommendation.getBooks().get(i));
                        }
                        System.out.print("Enter the number of the book to remove: ");
                        int removeIndex = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        clonedRecommendation.removeBook(clonedRecommendation.getBooks().get(removeIndex - 1));
                        System.out.println("Book removed.");
                    } else if (modifyChoice == 3) {
                        // Change target audience
                        System.out.print("Enter new target audience: ");
                        String newAudience = scanner.nextLine();
                        clonedRecommendation.setTargetAudience(newAudience);
                        System.out.println("Target audience updated.");
                    }
                    break;

                case 4:
                    // Save and exit
                    System.out.println("Saving and exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
