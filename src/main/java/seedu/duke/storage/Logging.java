package seedu.duke.storage;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


//@@ chewyang
/**
 * Logger class to store logs into a file.
 */
public class Logging extends Storage {
    Logger logger = Logger.getLogger("MyLog");
    FileHandler fh;

    /**
     * Constructor for the logging class.
     * @param filePath path of file to be stored into
     */
    public Logging(String filePath) {
        super(filePath);
    }


    /**
     * Checks if the file to input the loggers is present and sets up the logging mechanism.
     */
    public void setUpLogger() {
        try {
            createFileHierarchy();
            // This block configure the logger with handler and formatter
            fh = new FileHandler(this.filePath);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes a log of INFO level.
     * @param logMessage is the message to be logged
     */
    public void writeToLogInfo(String logMessage) {
        this.logger.setUseParentHandlers(false);
        this.logger.info(logMessage);
    }

    /**
     * Writes a log of SEVERE level.
     * @param logMessage is the message to be logged
     */
    public void writeToLogSevere(String logMessage) {
        this.logger.setUseParentHandlers(false);
        this.logger.severe(logMessage);
    }

    /**
     * Writes a log of WARNING level.
     * @param logMessage is the message to be logged
     */
    public void writeToLogWarning(String logMessage) {
        this.logger.setUseParentHandlers(false);
        this.logger.warning(logMessage);
    }



}
