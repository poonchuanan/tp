package seedu.duke;

/**
 * Sub-class of Activity.
 */
public class Exercise extends Activity {
    /**
     * Subclass of class Activity.
     *
     * @param description exercise description
     * @param calories calories burnt
     */
    public Exercise(String description, int calories, boolean isFromFile) {
        super(description, calories, isFromFile);
    }

    public String getString() {
        return toString();
    }

    @Override
    public String toString() {
        return "[E] | " + super.toString();
    }
}
