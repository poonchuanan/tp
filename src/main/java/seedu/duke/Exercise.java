package seedu.duke;

public class Exercise extends Activity {
    public Exercise(String description, int calories) {
        super(description, calories);
    }

    @Override
    public String toString() {
        return "Got it! Added" + super.toString();
    }
}
