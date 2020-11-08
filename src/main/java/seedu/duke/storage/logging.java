package seedu.duke.storage;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static seedu.duke.Trakcal.storage;

public class logging extends Storage{
    Logger logger = Logger.getLogger("MyLog");
    FileHandler fh;

    /**
     * Constructor for the storage class.
     *
     * @param filePath path of file to be stored into
     */
    public logging(String filePath) {
        super(filePath);
    }


    public void setLogger() {

           try {
               createFileHierarchy();
               // This block configure the logger with handler and formatter
               fh = new FileHandler(this.filePath);
               logger.addHandler(fh);
               SimpleFormatter formatter = new SimpleFormatter();
               fh.setFormatter(formatter);

               // the following statement is used to log any messages
               //logger.info("My first log");

           } catch (SecurityException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }

           //logger.info("Hi How r u?");
       }

       public void writeToLog(String logMessage) {
        this.logger.info(logMessage);
       }


}
