package seedu.duke.logic.preparecommand;

import seedu.duke.Trakcal;
import seedu.duke.command.Command;
import seedu.duke.command.GraphCommand;

/**
 * Prepares graph command.
 */
public class PrepareGraphCommand extends PrepareCommand {

    public PrepareGraphCommand(String[] description) {
        super(description);
    }

    /**
     * Prepares the arguments needed for the graph command.
     *
     * @return graphCommand
     * @throws Exception if no records are found
     */
    public Command prepareCommand() throws Exception {
        if (description.length != 1) {
            throw new Exception("Graph has no description");
        }
        if (Trakcal.calList.getHashMap().size() == 0) {
            throw new Exception("No records found!");
        }
        return new GraphCommand();
    }

}
