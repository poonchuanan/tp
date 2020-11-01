package seedu.duke.logic;

import seedu.duke.command.Command;

import java.time.LocalDateTime;

public abstract class Parser {
    public String userInput;
    private LocalDateTime date;

    public Parser(String description) {
        this.userInput = description;
        this.date = LocalDateTime.now();
    }

    public abstract Command parseArgument();

    public String checkExtraSpaces() {
        return this.userInput.replaceAll(" +", CommandParser.SPACE);
    }

}
