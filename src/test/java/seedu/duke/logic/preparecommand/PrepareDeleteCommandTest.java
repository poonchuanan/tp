package seedu.duke.logic.preparecommand;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import seedu.duke.command.DeleteAllCommand;
import seedu.duke.command.DeleteByIndexCommand;
import seedu.duke.exception.InvalidNumberOfArguments;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PrepareDeleteCommandTest {
    private final String DELETE = "Delete";

    @Test
    void PrepareDeleteCommand_DeleteByIndex_Success() {
        String[] arguments = {DELETE,"2"};
        assertTrue( new PrepareDeleteCommand(arguments).prepareCommand() instanceof DeleteByIndexCommand);
    }

 /**   @Test
    void PrepareDeleteCommand_DeleteAll_Success() {

        String[] arguments = {DELETE, "all/"};
        assertTrue( new PrepareDeleteCommand(arguments).prepareCommand() instanceof DeleteAllCommand);
    }**/

}