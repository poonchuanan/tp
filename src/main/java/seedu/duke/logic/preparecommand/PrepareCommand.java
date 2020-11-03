package seedu.duke.logic.preparecommand;

import seedu.duke.command.Command;

import java.time.LocalDateTime;

public abstract class PrepareCommand {
    public String[] description;
    public LocalDateTime date;
    public static final int MAXIMUM_DESCRIPTION_LENGTH = 40;
    public static final int MAXIMUM_CALORIE_COUNT = 3000;
    public static final int MINIMUM_CALORIE_COUNT = 0;
    public static final String APPLICATION_LAUNCH_DATE = "2020-11-01";

    public PrepareCommand(String[] description) {
        this.description = description;
        setDate();
    }


    private void setDate() {
        this.date = LocalDateTime.now();
    }

    public abstract Command prepareCommand() throws Exception;


}
