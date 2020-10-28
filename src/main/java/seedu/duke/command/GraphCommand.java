package seedu.duke.command;

import seedu.duke.model.DayMap;
import seedu.duke.Trakcal;
import seedu.duke.model.GraphDrawing;
import seedu.duke.model.GraphProperty;

import java.util.HashMap;

public class GraphCommand extends Command {
    public static final int MAXIMUM_DAYS = 7;

    public GraphCommand() {
    }

    boolean isMapValid(DayMap dayMap) {
        return dayMap != null;
    }

    @Override
    public void execute() {
        GraphProperty graphProperties = new GraphProperty(dayMap, (int) Trakcal.profile.getCalories());
        graphProperties.setProperties();
        System.out.println(new GraphDrawing(graphProperties).drawGraph());
    }
}
