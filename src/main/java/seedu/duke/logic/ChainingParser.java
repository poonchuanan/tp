package seedu.duke.logic;

import seedu.duke.command.Command;

import static seedu.duke.Trakcal.calList;
import static seedu.duke.Trakcal.executeCmd;
import static seedu.duke.Trakcal.storage;

public class ChainingParser extends Parser {
    public static final String CHAIN_SEPARATOR = "&&";
    protected static final int CHAIN_SEPARATOR_LENGTH = 2;

    public ChainingParser(String userInput) {
        super(userInput);
    }

    /**
     * Prepares chained input by user into their respective commands to be read.
     *
     * @return null
     */
    public Command parseArgument() {
        while (userInput.contains(CHAIN_SEPARATOR)) {
            if (!(userInput.endsWith(CHAIN_SEPARATOR))) {
                userInput = userInput + CommandParser.SPACE + CHAIN_SEPARATOR;
            }
            int chainIndex = userInput.indexOf(CHAIN_SEPARATOR);

            String firstString = userInput.substring(0, chainIndex).trim();

            CommandParser parser = new CommandParser(firstString);
            Command cmd = parser.parseArgument();

            if (cmd.getCanBeChained()) {
                executeCmd(cmd);
            } else {
                System.out.println("'" + firstString + "' cannot be chained!");
                break;
            }
            storage.updateFile(calList);

            userInput = super.userInput.substring(chainIndex + CHAIN_SEPARATOR_LENGTH).trim();
        }
        return null;
    }
}
