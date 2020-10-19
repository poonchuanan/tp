package seedu.duke;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import seedu.duke.command.Command;
import seedu.duke.command.ListCommand;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveActivityCommandTest {

    LocalDate date = LocalDate.of(2020, Month.AUGUST, 9);
    LocalDate date2 = LocalDate.of(2020, Month.AUGUST, 10);

    void createObjects(DayMap dummyMap) {
        dummyMap.addActivity(date.atStartOfDay(), new Food("Apple", 50, false));
        dummyMap.addActivity(date.atStartOfDay(), new Food("Banana", 100, false));
        dummyMap.addActivity(date.atStartOfDay(), new Food("Orange", 25, false));

        dummyMap.addActivity(date2.atStartOfDay(), new Food("Apple2", 51, false));
        dummyMap.addActivity(date2.atStartOfDay(), new Food("Banana2", 101, false));
        dummyMap.addActivity(date2.atStartOfDay(), new Food("Orange2", 26, false));
    }

    /**
     * Tests if the result will be the same even if there are different white spaces.
     */
    @Test
    void whiteSpace_parsingTest() {
        DayMap dummyMap = new DayMap();
        createObjects(dummyMap);
        Command listCommand = new ListCommand(date);
        listCommand.setData(dummyMap);
        listCommand.execute();
        assertEquals("2020-08-09: [F] | Apple | 50, [F] | Banana | 100, [F] | Orange | 25",
                dummyMap.toString(date.atStartOfDay()));

        Parser parser = new Parser("move from/   3 below/ 1");
        Command command = parser.parseCommand();
        command.setData(dummyMap);
        command.execute();
        assertEquals("2020-08-09: [F] | Apple | 50, [F] | Orange | 25, [F] | Banana | 100",
                dummyMap.toString(date.atStartOfDay()));

        Parser parser2 = new Parser("move from/3 below/  1");
        Command command2 = parser2.parseCommand();
        command2.setData(dummyMap);
        command2.execute();
        assertEquals("2020-08-09: [F] | Apple | 50, [F] | Banana | 100, [F] | Orange | 25",
                dummyMap.toString(date.atStartOfDay()));
    }

    /**
     * Tests if a NumberFormatException will be thrown if the user enters wrong command format.
     */
    @Test
    void numberFormatExceptionThrown_ifIndexEnteredIsNotANumber() {
        DayMap dummyMap = new DayMap();
        createObjects(dummyMap);
        Command listCommand = new ListCommand(date);
        listCommand.setData(dummyMap);
        listCommand.execute();
        assertEquals("2020-08-09: [F] | Apple | 50, [F] | Banana | 100, [F] | Orange | 25",
                dummyMap.toString(date.atStartOfDay()));

        Parser parser = new Parser("move from/a below/2");

        Assertions.assertThrows(NumberFormatException.class, parser::parseCommand);
    }

    /**
     * Tests if both the index is within the boundaries.
     */
    @Test
    void InvalidCommand_ifIndexEnteredIsOutOfBounds() {
        DayMap dummyMap = new DayMap();
        createObjects(dummyMap);
        Command listCommand = new ListCommand(date);
        listCommand.setData(dummyMap);
        listCommand.execute();
        assertEquals("2020-08-09: [F] | Apple | 50, [F] | Banana | 100, [F] | Orange | 25",
                dummyMap.toString(date.atStartOfDay()));

        Parser parser = new Parser("move from/3 below/5");
        parser.parseCommand().setData(dummyMap);
        Assertions.assertThrows(NullPointerException.class, () -> {
            parser.parseCommand().execute();
        });

        Parser parser2 = new Parser("move from/5 below/2");
        parser2.parseCommand().setData(dummyMap);
        Assertions.assertThrows(NullPointerException.class, () -> {
            parser2.parseCommand().execute();
        });
    }


}
