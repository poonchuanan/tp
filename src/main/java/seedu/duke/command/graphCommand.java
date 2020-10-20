package seedu.duke.command;

import seedu.duke.DayMap;
import seedu.duke.GraphProperty;

public class graphCommand extends Command{
    public graphCommand() {
    }

    @Override
    public void execute() {
        new GraphProperty(super.dayMap, 2500, 7).drawGraph();
    }

}
