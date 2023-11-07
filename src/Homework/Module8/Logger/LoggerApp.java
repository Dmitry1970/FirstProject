package Homework.Module8.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerApp {

    private static LoggerApp logger;
    public LogLevel level;
    public static final LogLevel ERROR_LEVEL = LogLevel.INFO;

    private LoggerApp(LogLevel level) {
        this.level = level;
    }

    public static LoggerApp getLogger(LogLevel level) {
        if (logger == null) {
            logger = new LoggerApp(level);
        }
        return logger;
    }

    public void writeErrorMessage(String errorMessage, LogLevel level) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH-mm");
        if (level.ordinal() > ERROR_LEVEL.ordinal()) {
            try (FileWriter writer = new FileWriter("src/Homework/Module8/Logger/error.txt")) {
                writer.write(localDateTime.format(formatter) + ": " + level + ": " + errorMessage);
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}