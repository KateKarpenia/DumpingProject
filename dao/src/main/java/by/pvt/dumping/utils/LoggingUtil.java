package by.pvt.dumping.utils;


import org.apache.log4j.Logger;


public enum LoggingUtil {

    INSTANCE;

    private Logger logger;

    public void logError(Class sender, String message) {
        logger = Logger.getLogger(sender);
        logger.error(message);
    }
}
