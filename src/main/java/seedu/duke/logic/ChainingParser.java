package seedu.duke.logic;

import seedu.duke.command.Command;

import static seedu.duke.Trakcal.calList;
import static seedu.duke.Trakcal.executeCmd;
import static seedu.duke.Trakcal.storage;

public class ChainingParser extends Parser {

    public ChainingParser(String userInput) {
        super(userInput);
    }

    /**
     * Prepares chained input by user into their respective commands to be read.
     *
     * @return null
     */
    public Command parseArgument() {
        while (super.userInput.contains(CommandParser.CHAIN_SEPARATOR)) {
            if (!(super.userInput.endsWith(CommandParser.CHAIN_SEPARATOR))) {
                super.userInput = super.userInput + CommandParser.SPACE + CommandParser.CHAIN_SEPARATOR;
            }
            int chainIndex = super.userInput.indexOf(CommandParser.CHAIN_SEPARATOR);

            String firstString = super.userInput.substring(0, chainIndex).trim();

            CommandParser parser = new CommandParser(firstString);
            Command cmd = parser.parseArgument();

            if (cmd.getCanBeChained()) {
                executeCmd(cmd);
            } else {
                System.out.println("'" + firstString + "' cannot be chained!");
                break;
            }
            storage.updateFile(calList);

            super.userInput = super.userInput.substring(chainIndex + CommandParser.CHAIN_SEPARATOR_LENGTH).trim();
        }
        return null;
    }
}
