package seedu.duke.Commands;

import seedu.duke.DayMap;

public class Command {
    protected DayMap dayMap;


    //to be overriden
    public void execute() {
        return;
    }

    public void setData(DayMap dayMap) {
        this.dayMap = dayMap;
    }
}
