package seedu.duke.command;

import seedu.duke.GraphDrawing;

public class GraphCommand extends Command{
    public static final int MAXIMUM_DAYS = 7;
    private int days;

    public GraphCommand(int days) {
        this.days = days;
    }

    @Override
    public void execute() {
        new GraphDrawing(super.dayMap, 2500, days).drawGraph();
    }

}
