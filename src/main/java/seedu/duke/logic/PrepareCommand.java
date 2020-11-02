package seedu.duke.logic;

import seedu.duke.command.Command;

import java.time.LocalDateTime;

public abstract class PrepareCommand {
    public String[] description;
    public LocalDateTime date;

    public PrepareCommand(String[] description) {
        this.description = description;
        setDate();
    }


    private void setDate() {
        this.date = LocalDateTime.now();
    }

    public abstract Command prepareCommand() throws Exception;


}
