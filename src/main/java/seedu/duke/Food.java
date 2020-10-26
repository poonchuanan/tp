package seedu.duke;

import java.time.LocalDate;

/**
 * Sub-class of Activity.
 */
public class Food extends Activity {
    /**
     * Subclass of class Activity.
     *
     * @param description food description
     * @param calories calories consumed
     */
    public Food(String description, int calories, LocalDate date, boolean isFromFile) {
        super(description, calories, date, isFromFile);
    }

    public String getString() {
        return toString();
    }

    @Override
    public String toString() {
        return "[F] | " + super.toString();
    }
}
