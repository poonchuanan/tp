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

    private final String blankWidth = "   ";
    private final String targetWidth = "***";
    private final String barWidth = "| |";
    private final String targetBarWidth = "|*|";
    private final String topBarWidth = "|-|";

    /**
     * Constructor.
     * @param dayMap Hashmap
     * @param targetCalories target calories set by user
     * @param days number of days shown in graph
     */
    public GraphDrawing(DayMap dayMap, int targetCalories) {
        this.graphProperty = new GraphProperty(dayMap, targetCalories);
        this.row = graphProperty.row;
        this.column = graphProperty.column;
        this.targetRow = graphProperty.targetRow;
        this.maxCalories = graphProperty.maxCalories;
        this.minCalories = graphProperty.minCalories;
        this.targetCalories = graphProperty.maxCalories;
    }

    /**
     * Repeats character back to back.
     * @param character character
     * @param size number of times to repeat
     * @return concatenated string
     */
    public String repeatCharacter(String character, int size) {
        String characterText = "";
        for (int i = 0; i < size; i++) {
            characterText += character;
        }
        return characterText;
    }

    /**
     * Generates the x_axis.
     * @return x_axis String
     */
    public String generate_x_axis(int maxCalorieSize) {
        String horizontalLine = "|-+";
        for (int i = 0; i < column - 1; i++) {
            horizontalLine += repeatCharacter("-", 5) + "+";
        }
        horizontalLine = repeatCharacter(" ", maxCalorieSize) + horizontalLine + "--\n";
        return horizontalLine;
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
     * generates the y axis.
     * @param space space width set by number of characters in maximum calories.
     * @param columnNumber column number
     * @return y_axis string for that row
     */
    private String generateVerticalAxis(String space, int columnNumber) {
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
     * adds width based on the row type.
     * @param number row number
     * @return width
     */
    public String addWidth(int number) {
        String width = "";
        if (number == targetRow) {
            width += targetWidth;
        } else {
            width += blankWidth;
        }
        return width;
    }

    /**
     * draws the graph.
     */
    public void drawGraph() {
        int[][] table = graphProperty.table;
        ArrayList<LocalDate> keys = graphProperty.keys;
        int maxCalorieSize = Integer.toString(maxCalories).length();
        String space = repeatCharacter(" ", maxCalorieSize);

        String drawing = "";

        for (int i = row - 1; i >= 0; i--) {
            drawing += generateVerticalAxis(space, i) + "|";
            for (int j = 0; j < column; j++) {
                switch (table[i][j]) {
                case 0:
                    drawing += blankWidth;
                    break;
                case 1:
                    drawing += barWidth;
                    break;
                case 2:
                    drawing += targetWidth;
                    break;
                case 3:
                    drawing += targetBarWidth;
                    break;
                case 4:
                    drawing += topBarWidth;
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
        System.out.println(drawing);
    }

}
