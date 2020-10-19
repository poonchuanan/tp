package seedu.duke;


import java.util.ArrayList;
import java.util.Arrays;

public class plotGraph {
    //Assumption
    int row = 10;
    int column = 7;
    int max_calories = 3000;
    int min_calories = 1800;
    int target_calories = 2500;
    int targetRow;
    int[] calories = {1800,2000,2500,2250,2500,3000, 2750};
    int[][] Table;
    //upperbound_y_axis = max(max_calories, target_calories);
    //lowerbound_y_axis = min(min_caloires, target_calories);
    //Appropirate division for y axis -> assume 10 for now
    //Round of each calories of the day
    //Assume x axis length to be always 7 for now

    public void plotGraph() {
    }

    public int round(int x, int y) {
        if (x % y < y/2) {
            return x - (x%y);
        } else if (x % y > y/2) {
            return x + (y - (x%y));
        } else {
            return x + y/2;
        }
    }

    public void initTable(){
        this.Table = new int[row][column];
        for(int[] row : Table) {
            Arrays.fill(row, 0);
        }
    }

    public int calculateDivisor() {
        return (max_calories - min_calories)/10;
    }

    public void fillTable() {
        int divisor = calculateDivisor();
        int target = round(target_calories, divisor);
        int low = round(min_calories, divisor);
        int high = round(max_calories, divisor);
        this.targetRow = (target - low)/divisor;
        for (int i = 0; i < column ; i++) {
            Table[targetRow][i] = 2;
        }
        for (int j = 0; j < 7 ; j++) {
            calories[j] = round(calories[j] - min_calories, divisor)/divisor;
        }
        System.out.println(Arrays.toString(calories));
        for (int i = 9; i >= 0 ; i--) {
            for (int j = 0; j< 7; j++) {
                if (calories[j] == i) {
                    Table[i][j] = 4;
                }
                else if (calories[j] > i) {
                    Table[i][j]++;
                }
            }
        }
        System.out.println(Arrays.deepToString(Table));
    }
    public String plot_x_axis() {
        String x_axis_line = "\t _____|_____|_____|_____|_____|_____|_____|____\n";
        String x_axis_labels = "     1/11   2/11   3/11   4/11   5/11   6/11   Sun\n";
        return x_axis_line + x_axis_labels;
    }

    public String plot_y_axis() {
        String y_axis = "";
        for(int i = 10; i >= 1; i--) {
            if (i == 10) {
                y_axis += Integer.toString(max_calories) + "|\n";
            } else {
                y_axis += "\t|\n";
            }
        }
        return y_axis;
    }

    //Draws out the graph
    public void drawGraph() {
        initTable();
        fillTable();
        String drawing = "";
        for(int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < column; j++) {
                if (Table[i][j] == 0) {
                    drawing += "   ";
                }
                else if (Table[i][j] == 1) {
                    drawing += "| |";
                }
                else if (Table[i][j] == 2) {
                    drawing += "***";
                }
                else if (Table[i][j] == 3) {
                    drawing += "|*|";
                }
                else if (Table[i][j] == 4) {
                    drawing += "|-|";
                }
                else if (Table[i][j] == 5) {
                    drawing += "|-|";
                }
                if (i == targetRow) {
                    drawing += "***";
                } else {
                    drawing += "   ";
                }
            }
            drawing += "\n";
        }
        System.out.println(drawing);
    }
}
