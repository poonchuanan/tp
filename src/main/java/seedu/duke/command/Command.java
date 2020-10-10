package seedu.duke.command;

import seedu.duke.DayMap;

public class Command {
    protected DayMap dayMap;

    /**
     * This method is to be override by the specific commands.
     */
    public void execute() {
        return;
    }

    public void setData(DayMap dayMap) {
        this.dayMap = dayMap;
    }
}
