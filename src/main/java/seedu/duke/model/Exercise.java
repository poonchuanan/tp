package seedu.duke.model;

import java.time.LocalDate;

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
    public Exercise(String description, int calories, LocalDate date, boolean isFromFile) {
        super(description, calories, date, isFromFile);
    }

    public String getString() {
        return toString();
    }

    @Override
    public String toString() {
        return "[E] | " + super.toString();
    }
}
