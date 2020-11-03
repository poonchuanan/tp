package seedu.duke.logic.parser;

import seedu.duke.command.Command;

public abstract class Parser {
    public String userInput;

    public Parser(String description) {
        this.userInput = description;
    }

    public abstract Command parseArgument();

    public String checkExtraSpaces() {
        return this.userInput.replaceAll(" +", CommandParser.SPACE);
    }

}
