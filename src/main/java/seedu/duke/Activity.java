package seedu.duke;

public class Activity {
    protected String description;
    protected int calories;

    public Activity(String description, int calories) {
        this.description = description;
        this.calories = calories;
    }

    public String toString() {
        return description + ", " + calories;
    }
}
