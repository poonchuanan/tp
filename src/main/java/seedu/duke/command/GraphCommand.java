package seedu.duke.command;

import seedu.duke.Duke;
import seedu.duke.GraphDrawing;
import seedu.duke.GraphProperty;

public class GraphCommand extends Command {
    public static final int MAXIMUM_DAYS = 7;

    public GraphCommand() {
    }

    @Override
    public void execute() {
        //TODO Catch exception here for dayMap
        GraphProperty graphProperties = new GraphProperty(dayMap, (int) Duke.profile.getCalories());
        graphProperties.setProperties();
        System.out.println(new GraphDrawing(graphProperties).drawGraph());
    }

}
