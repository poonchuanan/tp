package seedu.duke.command;

import seedu.duke.DayMap;

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
