package seedu.duke.command;

import seedu.duke.DayMap;
import seedu.duke.GraphDrawing;
import seedu.duke.GraphProperty;

public class graphCommand extends Command{
    public graphCommand() {
    }

    @Override
    public void execute() {
        new GraphDrawing(super.dayMap, 2500, 7).drawGraph();
    }

}
