package Decorator;

public class Main {
    public static void main(String[] args) {
        Printer printer = new BasicPrinter();
        printer.print("This assignment is fun!");

        // Using decorators
        Printer encryptedPrinter = new EncryptedPrinterDecorator(new FilePrinterDecorator(printer));
        encryptedPrinter.print("This assignment is fun!");
    }
}
