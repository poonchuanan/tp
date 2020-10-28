package seedu.duke.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import seedu.duke.command.Command;
import seedu.duke.command.DeleteCommand;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ParserTest {

    @Test
    public void deleteAll_success() {
        Parser parser = new Parser("delete all/");
        Command cmd = parser.parseCommand();
        assertTrue(cmd instanceof DeleteCommand);
    }

    @Test
    public void deleteIndex_success() {
        Parser parser = new Parser("delete 2");
        Command cmd = parser.parseCommand();
        assertTrue(cmd instanceof DeleteCommand);
    }

    @Test
    public void deleteNull_Exception() {
        Parser parser = new Parser("delete");

        Assertions.assertThrows(NumberFormatException.class, () -> {
            Command cmd = parser.parseCommand();
        });
    }

}