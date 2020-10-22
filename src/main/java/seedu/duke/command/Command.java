package seedu.duke.command;

import seedu.duke.ActivityList;
import seedu.duke.DayMap;
import seedu.duke.exception.KeywordNotFoundException;

/**
 * Execute command.
 */
public class Command {
    protected DayMap dayMap;
    protected boolean canBeChained = false;

    /**
     * This method is to be override by the specific commands.
     */
    public void execute() {
        return;
    }

    /**
     * Set data.
     *
     * @param dayMap date
     */
    public void setData(DayMap dayMap) {
        this.dayMap = dayMap;
    }

    public boolean getCanBeChained() {
        return canBeChained;
    }
}
