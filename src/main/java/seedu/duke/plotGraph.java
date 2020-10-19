package seedu.duke;


public class plotGraph {
    //Assumption
    int max_calories;
    int min_calories;
    int target_calories;

    //upperbound_y_axis = max(max_calories, target_calories);
    //lowerbound_y_axis = min(min_caloires, target_calories);
    //Appropirate division for y axis -> assume 10 for now
    //Round of each calories of the day
    //Assume x axis length to be always 7 for now
    public String draw_x_axis() {
        String x_axis = "___________________________________________\n";
        return x_axis;
    }
    //Draws out the graph
    public void drawGraph() {
        System.out.print(draw_x_axis());
    }
}
