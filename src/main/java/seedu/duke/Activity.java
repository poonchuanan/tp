package seedu.duke;

/**
 * Store activities attributes.
 */
public class Activity {
    protected String description;
    protected int calories;
    protected boolean isFromFile;

    /**
     * Activity class constructor.
     *
     * @param description activity description
     * @param calories activity calories count
     */
    public Activity(String description, int calories, boolean isFromFile) {
        this.description = description;
        this.calories = calories;
        this.isFromFile = isFromFile;
        //If the activity added is not from decoding the file, print confirmation message
        if (!isFromFile) {
            System.out.println(toString());
        }
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
