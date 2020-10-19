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
    public String plot_x_axis() {
        String x_axis_line = "_____|_____|_____|_____|_____|_____|_____|____\n";
        String x_axis_labels = "    Mon   Tue   Wed   Thu   Fri   Sat   Sun\n";
        return x_axis_line + x_axis_labels;
    }

    public String plot_y_axis() {
        String y_axis = "";
        for(int i = 0; i < 10; i++) {
            y_axis += "|\n";
        }
        return y_axis;
    }

    //Draws out the graph
    public void drawGraph() {
        System.out.print(plot_y_axis());
        System.out.print(plot_x_axis());
    }
}
