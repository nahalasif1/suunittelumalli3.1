package Decorator;

import java.io.FileWriter;
import java.io.IOException;

public class FilePrinterDecorator extends PrinterDecorator {

    public FilePrinterDecorator(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String text) {
        try (FileWriter writer = new FileWriter("writer.txt")) {
            writer.write(text + "\n");
            System.out.println("Written to file: " + text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        printer.print(text);
    }
}
