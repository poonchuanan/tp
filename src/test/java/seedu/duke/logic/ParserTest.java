package seedu.duke.logic;

import org.junit.jupiter.api.Test;
import seedu.duke.command.Command;
import seedu.duke.command.DeleteCommand;
import seedu.duke.logic.parser.CommandParser;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ParserTest {

    @Test
    public void deleteAll_success() {
        CommandParser parser = new CommandParser("delete all/");
        Command cmd = parser.parseArgument();
        assertTrue(cmd instanceof DeleteCommand);
    }

    @Test
    public void deleteIndex_success() {
        CommandParser parser = new CommandParser("delete 2");
        Command cmd = parser.parseArgument();
        assertTrue(cmd instanceof DeleteCommand);
    }

}