package seedu.duke.command;

import seedu.duke.Duke;
import seedu.duke.GraphDrawing;
import seedu.duke.GraphProperty;
import seedu.duke.userprofile.Userinfo;

public class GraphCommand extends Command {
    public static final int MAXIMUM_DAYS = 7;

    public GraphCommand() {
    }

    @Override
    public void execute() {
        GraphProperty graphProperties = new GraphProperty(dayMap, (int) Userinfo.getCalories());
        graphProperties.setProperties();
        new GraphDrawing(graphProperties).drawGraph();
    }

}
