package seedu.duke;

/**
 * Store activities attributes.
 */
public class Activity {
    protected String description;
    protected int calories;

    public Activity(String description, int calories) {
        this.description = description;
        this.calories = calories;
    }

    /**
     * Returns String to be printed out.
     *
     * @return String to be printed out.
     */
    public String toString() {
        return description + ", " + calories;
    }
}
