package seedu.duke;

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
    public Food(String description, int calories) {
        super(description, calories);
    }

    public String getString() {
        return toString();
    }

    @Override
    public String toString() {
        return "[F] | " + super.toString();
    }
}
