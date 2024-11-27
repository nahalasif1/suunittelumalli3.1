package Prototype;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
    private String targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books); // Return a copy to ensure immutability
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    @Override
    public Recommendation clone() {
        try {
            Recommendation clone = (Recommendation) super.clone();
            clone.books = new ArrayList<>();
            for (Book book : books) {
                clone.addBook(book.clone());
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported for Recommendation", e);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(targetAudience + " Recommendations:\n");
        for (Book book : books) {
            sb.append(" - ").append(book).append("\n");
        }
        return sb.toString();
    }
}
