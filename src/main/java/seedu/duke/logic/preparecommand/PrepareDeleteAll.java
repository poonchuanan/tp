package seedu.duke.logic.preparecommand;

import seedu.duke.Trakcal;
import seedu.duke.command.Command;
import seedu.duke.command.DeleteAllCommand;
import seedu.duke.exception.ListNotFoundException;
import seedu.duke.model.DayMap;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import static seedu.duke.ui.ExceptionMessages.print;

public class PrepareDeleteAll extends PrepareDeleteCommand {
    DayMap dayMap;

    public PrepareDeleteAll(String[] description) {
        super(description);
        this.dayMap = Trakcal.calList;
    }

    @Override
    public Command prepareCommand() {
        try {
            checkList();
            if (isDeleteConfirmed()) {
                return new DeleteAllCommand();
            }
        } catch (ListNotFoundException e) {
            print("List is empty");
        } catch (NoSuchElementException e) {
            print("Invalid input....aborting delete command.");
        }
        return null;
    }

    /**
     * Gets input from the user to confirm the delete command.
     *
     * @return true if the user says yes
     */
    public boolean isDeleteConfirmed() throws NoSuchElementException {
        System.out.println("Are you sure you want to delete all activities in today's list? [yes/no]");
        String userInput = Trakcal.in.nextLine().trim().toLowerCase();
        if (userInput.equals("yes")) {
            return true;
        } else if (userInput.equals("no")) {
            print("Delete command aborted.");
        } else {
            print("Invalid input....aborting delete command.");
        }
        return false;

    }

    private void checkList() throws ListNotFoundException {
        if (dayMap.getActivityList(LocalDate.now().atStartOfDay()).getNumberOfActivities() == 0) {
            throw new ListNotFoundException();
        }
    }
}


