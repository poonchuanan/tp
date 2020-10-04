package seedu.duke;

public class Food extends Activity {
    public Food(String description, int calories) {
        super(description, calories);
    }

    @Override
    public String toString() {
        return "Got it! Added" + super.toString();
    }
}
