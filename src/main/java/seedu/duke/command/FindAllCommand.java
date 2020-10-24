package seedu.duke.command;

import seedu.duke.ActivityList;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static seedu.duke.Ui.displayEmptyActivityCounterMessage;
import static seedu.duke.Ui.displaySavedMessage;

/**
 * Initialises Command to find all description tags.
 */
public class FindAllCommand extends Command {
    protected LocalDate date;
    protected String userInput;

    /**
     * Find matching results based on input tags.
     * @param userInput keywords to be matched
     */
    public FindAllCommand(String userInput) {
        this.date = LocalDateTime.now().toLocalDate();
        this.userInput = userInput;
    }

    @Override
    public void execute() {
        ActivityList activities = dayMap.getActivityList(date.atStartOfDay());
        int activityCounter = activities.getNumberOfActivities();
        if (activityCounter == 0) {
            displayEmptyActivityCounterMessage();
        } else {
            System.out.println("Here are the matching results based on all keywords typed:");
            boolean hasAllWords;
            for (int i = 0; i < activityCounter; i++) {
                String currentLine = activities.getActivity(i).toString();
                hasAllWords = checkAllWords(currentLine);
                if (hasAllWords) {
                    System.out.println(currentLine);
                }
            }
        }
        displaySavedMessage();
    }

    /**
     * Checks if all keywords inputted by user is present in entry.
     * @param currentLine current entry to be checked
     * @return true if all words are present, false otherwise
     */
    private boolean checkAllWords(String currentLine) {
        ArrayList<String> wordsToCheck = new ArrayList<>();
        wordsToCheck = getAllTags(userInput);
        for (String word : wordsToCheck) {
            if (!currentLine.contains(word)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Parses all keywords inputted by user into an arraylist.
     * @param userInput String user typed into CLI
     */
    private ArrayList<String> getAllTags(String userInput) {
        ArrayList<String> tags = new ArrayList<>();
        while (userInput.contains("a/")) {
            if (!userInput.contains(" ")) {
                userInput = userInput.substring(2);
                tags.add(userInput);
                break;
            }
            int spaceIndex = userInput.indexOf(" ");
            String firstWord = userInput.substring(0, spaceIndex);
            userInput = userInput.substring(spaceIndex).trim();
            firstWord = firstWord.substring(2);
            tags.add(firstWord);
        }
        return tags;
    }
}
