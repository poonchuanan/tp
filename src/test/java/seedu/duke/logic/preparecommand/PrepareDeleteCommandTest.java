package seedu.duke.logic.preparecommand;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import seedu.duke.command.DeleteAllCommand;
import seedu.duke.command.DeleteByIndexCommand;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PrepareDeleteCommandTest {
    private static final String DELETE = "Delete";

    @Test
    public void prepareDeleteCommand_DeleteByIndex_Success() {
        String[] arguments = {DELETE,"2"};
        assertTrue(new PrepareDeleteCommand(arguments).prepareCommand() instanceof DeleteByIndexCommand);
    }

}