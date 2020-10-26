package seedu.duke;

import java.time.LocalDate;

/**
 * Store activities attributes.
 */
public class Activity {
    protected String description;
    protected int calories;
    protected boolean isFromFile;
    protected LocalDate date;

    /**
     * Activity class constructor.
     *
     * @param description activity description
     * @param calories activity calories count
     */
    public Activity(String description, int calories, LocalDate date, boolean isFromFile) {
        this.description = description;
        this.calories = calories;
        this.isFromFile = isFromFile;
        this.date = date;

        // If the activity added is not from decoding the file, print confirmation message
        if (!isFromFile) {
            System.out.println(toString());
        }
    }

    public String getActivityDescription() {
        return this.description;
    }

    public int getActivityCalories() {
        return this.calories;
    }

    public LocalDate getActivityDate() {
        return this.date;
    }

    /**
     * Returns String to be printed out.
     *
     * @return String to be printed out.
     */
    public String toString() {
        return description + " | " + calories;
    }
}
