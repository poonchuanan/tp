package seedu.duke.logic.preparecommand;

import seedu.duke.command.Command;
import seedu.duke.command.CreateNewUserCommand;
import seedu.duke.exception.InvalidNumberOfArguments;

public class PrepareUserCommand extends PrepareCommand {
    private static final int ARGUMENT_LIMIT = 2;

    public PrepareUserCommand(String[] description) {
        super(description);
    }

    @Override
    public Command prepareCommand() throws Exception {
        try {
            isNumberOfArgumentsValid(ARGUMENT_LIMIT);
        } catch (InvalidNumberOfArguments e) {
            System.out.println("Arguments are not valid!");
        }
        String[] input = description[1].split(" ", 2);

        switch (input[0].trim()) {
        case "l/":
            return new PrepareProfileListCommand(input).prepareCommand();
        case "c/":
            return new CreateNewUserCommand();
        case "e/":
            return new PrepareEditUserProfile(input).prepareCommand();
        default:
            return null;
        }
    }


}
