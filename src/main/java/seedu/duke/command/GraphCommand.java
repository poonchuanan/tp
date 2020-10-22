package seedu.duke.command;

import seedu.duke.DayMap;
import seedu.duke.GraphDrawing;

public class GraphCommand extends Command {
    public static final int MAXIMUM_DAYS = 7;
    private DayMap dayMap;

    public GraphCommand() {
        this.dayMap = super.dayMap;

    }

    @Override
    public void execute() {
        new GraphDrawing(dayMap, 2500).drawGraph();
    }

}
