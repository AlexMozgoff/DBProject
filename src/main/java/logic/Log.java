package main.java.logic;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class Log {

    private static Logger logger;

    static {
        try {
            logger = Logger.getLogger(Log.class.getName());
            Handler handler = new FileHandler("log.txt");
            logger.addHandler(handler);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void write(String message) {
        logger.info(message);
    }
}
