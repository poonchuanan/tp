package seedu.duke;

import java.time.LocalDate;
import java.util.ArrayList;

public class GraphDrawing {

    public GraphProperty graphProperty;

    private final int row;
    private final int column;
    private final int targetRow;
    private final int maxCalories;
    private final int minCalories;
    private final int targetCalories;

    private final String BLANK_WIDTH = "   ";
    private final String TARGET_WIDTH  = "***";
    private final String BAR_WIDTH  = "| |";
    private final String TARGET_BAR_WIDTH  = "|*|";
    private final String TOP_BAR_WIDTH  = "|-|";

    /**
     * Constructor
     * @param dayMap Hashmap
     * @param targetCalories target calories set by user
     * @param days number of days shown in graph
     */
    public GraphDrawing(DayMap dayMap, int targetCalories, int days) {
        this.graphProperty = new GraphProperty(dayMap, targetCalories, days);
        this.row = graphProperty.ROW;
        this.column = graphProperty.Column;
        this.targetRow = graphProperty.targetRow;
        this.maxCalories = graphProperty.max_calories;
        this.minCalories = graphProperty.min_calories;
        this.targetCalories = graphProperty.max_calories;
    }

    /**
     * Repeats character back to back.
     * @param character character
     * @param size number of times to repeat
     * @return concatenated string
     */
    public String repeatCharacter(String character, int size) {
        String characterText = "";
        for (int i = 0 ; i < size; i++) {
            characterText += character;
        }
        return characterText;
    }

    /**
     * Generates the x_axis
     * @return x_axis String
     */
    public String generate_x_axis(int maxCalorieSize) {
        String x_axis_line = "|-+";
        for (int i = 0; i < column - 1; i++) {
            x_axis_line += repeatCharacter("-", 5) + "+";
        }
        x_axis_line = repeatCharacter(" ", maxCalorieSize) + x_axis_line + "--\n";
        return x_axis_line;
    }

    /**
     * generate date labels for the x-axis.
     * @param maxCalorieSize Character length of maxCalorieSize
     * @return date labels
     */
    public String generateDateLabels(int maxCalorieSize) {
        ArrayList<LocalDate> keys = graphProperty.keys;
        return repeatCharacter(" ", maxCalorieSize - 1) + " " + graphProperty.parseDate(keys);
    }

    /**
     * generates the y axis
     * @param space space width set by number of characters in maximum calories.
     * @param columnNumber column number
     * @return y_axis string for that row
     */
    private String generate_y_axis(String space, int columnNumber) {
        String targetCaloriesString = Integer.toString(targetCalories);
        String maxCaloriesString = Integer.toString(maxCalories);
        String minCaloriesString = Integer.toString(minCalories);
        String label = "";
        if (columnNumber == row - 1) {
            label = maxCaloriesString;
        } else if (columnNumber == targetRow) {
            label = targetCaloriesString
                    + repeatCharacter(" ", calculateSizeDifference(maxCaloriesString, targetCaloriesString));
        } else if (columnNumber == 0) {
            label = minCaloriesString
                    + repeatCharacter(" ", calculateSizeDifference(maxCaloriesString, minCaloriesString));
        } else {
            label = space;
        }
        return label;
    }

    /**
     * Calculate difference in string size.
     * @param string1 first string
     * @param string2 second string
     * @return string length differemnce
     */
    public int calculateSizeDifference(String string1, String string2) {
        if (string1.length() > string2.length()) {
            return string1.length() - string2.length();
        } else {
            return string1.length() - string2.length();
        }
    }

    /**
     * adds width based on the row type
     * @param number row number
     * @return width
     */
    public String addWidth(int number) {
        String width = "";
        if (number == targetRow) {
            width += TARGET_WIDTH;
        } else {
            width += BLANK_WIDTH;
        }
        return width;
    }

    /**
     * draws the graph
     */
    public void drawGraph() {
        int[][] table = graphProperty.Table;
        ArrayList<LocalDate> keys = graphProperty.keys;
        int maxCalorieSize = Integer.toString(maxCalories).length();
        String space = repeatCharacter(" ", maxCalorieSize);

        String drawing = "";

        for(int i = row - 1; i >= 0; i--) {
            drawing += generate_y_axis(space, i) + "|";
            for (int j = 0; j < column; j++) {
                switch (table[i][j]) {
                case 0:
                    drawing += BLANK_WIDTH;
                    break;
                case 1:
                    drawing += BAR_WIDTH;
                    break;
                case 2:
                    drawing += TARGET_WIDTH;
                    break;
                case 3:
                    drawing += TARGET_BAR_WIDTH;
                    break;
                case 4:
                    drawing += TOP_BAR_WIDTH;
                    break;
                default:
                    //does nothing
                    break;
                }
                drawing += addWidth(i);
            }
            drawing += "\n";
        }

        drawing += generate_x_axis(maxCalorieSize);
        drawing += generateDateLabels(maxCalorieSize);
        System.out.print(drawing);
    }

}
