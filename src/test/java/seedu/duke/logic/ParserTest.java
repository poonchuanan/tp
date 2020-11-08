package seedu.duke.logic;

import org.junit.jupiter.api.Test;
import seedu.duke.Trakcal;
import seedu.duke.command.Command;
import seedu.duke.command.DeleteAllCommand;
import seedu.duke.command.DeleteByIndexCommand;
import seedu.duke.logic.parser.CommandParser;
import seedu.duke.model.ActivityList;
import seedu.duke.model.DayMap;
import seedu.duke.model.Exercise;
import seedu.duke.model.Food;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ParserTest {

    @Test
    public void deleteIndex_success() {

        CommandParser parser = new CommandParser("delete 2");
        Command cmd = parser.parseArgument();
        assertTrue(cmd instanceof DeleteByIndexCommand);
    }

}