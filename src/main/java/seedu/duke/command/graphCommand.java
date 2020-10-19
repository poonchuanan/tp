package seedu.duke.command;

import seedu.duke.plotGraph;

public class graphCommand extends Command{
    public graphCommand() {

    }

    @Override
    public void execute() {
        new plotGraph().drawGraph();
    }
}
