package Decorator;

public class BasicPrinter implements Printer {
    @Override
    public void print(String text) {
        System.out.println(text);
    }
}