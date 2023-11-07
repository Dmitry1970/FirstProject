package Homework.Module8.Logger;

public class MainApp {

    public static void main(String[] args) {

        LoggerApp logger1 = LoggerApp.getLogger(LogLevel.INFO);
        logger1.writeErrorMessage(LogLevel.ERROR.description, LogLevel.ERROR);
        }
    }

