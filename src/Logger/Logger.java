package Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private BufferedWriter writer;
    private String fileName;


    private Logger() {
        fileName = "default_log.txt";
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.out.println("Error initializing the log file: " + e.getMessage());
        }
    }


    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }


    public void setFileName(String newFileName) {
        try {
            if (writer != null) {
                writer.close();
            }
            fileName = newFileName;
            writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.out.println("Error setting new log file: " + e.getMessage());
        }
    }


    public void write(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.out.println("Error writing to the log file: " + e.getMessage());
        }
    }


    public void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("Error closing the log file: " + e.getMessage());
        }
    }
}
