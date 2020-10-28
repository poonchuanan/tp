package seedu.duke.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class GraphDrawing {


    public GraphProperty graphProperty;

    private final int targetRow;
    private final int maxCalories;
    private final int minCalories;
    private final int targetCalories;

    private static final String BLANK_WIDTH = "   ";
    private static final String TARGET_WIDTH = "***";
    private static final String BAR_WIDTH = "| |";
    private static final String targetBarWidth = "|*|";
    private static final String TOP_BAR_WIDTH = "|-|";

    /**
     * Constructor.
     *
     * @param graphProperty properties of graph
     */
    public GraphDrawing(GraphProperty graphProperty) {
        this.graphProperty = graphProperty;
        this.targetRow = graphProperty.targetRow;
        this.maxCalories = graphProperty.maxCalories;
        this.minCalories = graphProperty.minCalories;
        this.targetCalories = graphProperty.targetCalories;
    }

    /**
     * Repeats character back to back.
     *
     * @param character character
     * @param size number of times to repeat
     * @return concatenated string
     */
    public String repeatCharacter(String character, int size) {
        assert size >= 0;
        String characterText = "";
        for (int i = 0; i < size; i++) {
            characterText += character;
        }
        return characterText;
    }

    /**
     * Generates the x_axis.
     *
     * @return x_axis String
     */
    public String generate_x_axis(int maxCalorieSize, int column) {
        String horizontalLine = "|-+";
        for (int i = 0; i < column - 1; i++) {
            horizontalLine += repeatCharacter("-", 5) + "+";
        }
        horizontalLine = repeatCharacter(" ", maxCalorieSize) + horizontalLine + "--\n";
        return horizontalLine;
    }

    /**
     * Generates date labels for the x-axis.
     *
     * @param maxCalorieSize Character length of maxCalorieSize
     * @return date labels
     */
    public String generateDateLabels(int maxCalorieSize,  ArrayList<LocalDate> keys) {
        assert keys != null;
        assert maxCalorieSize >= 1;
        return repeatCharacter(" ", maxCalorieSize - 1) + " " + graphProperty.parseDate(keys);
    }

    /**
     * Generates the y axis.
     * @param space space width set by number of characters in maximum calories.
     * @param columnNumber column number
     * @return y_axis string for that row
     */
    private String generateVerticalAxis(String space, int columnNumber, int row) {
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
     *
     * @param firstString first string
     * @param secondString second string
     * @return string length differemnce
     */
    public int calculateSizeDifference(String firstString, String secondString) {
        if (firstString.length() > secondString.length()) {
            return firstString.length() - secondString.length();
        } else {
            return firstString.length() - secondString.length();
        }
    }

    /**
     * Adds width based on the row type.
     *
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
     * Draws the graph.
     */
    public String drawGraph() {
        int[][] table = graphProperty.table;
        assert table != null;
        ArrayList<LocalDate> keys = graphProperty.keys;
        assert keys != null;
        int maxCalorieSize = Integer.toString(maxCalories).length();
        String space = repeatCharacter(" ", maxCalorieSize);
        int column = graphProperty.column;
        int row = GraphProperty.ROW;
        String drawing = "";

        for (int i = row - 1; i >= 0; i--) {
            drawing += generateVerticalAxis(space, i, row) + "|";
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
                    drawing += targetBarWidth;
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

        drawing += generate_x_axis(maxCalorieSize, column);
        drawing += generateDateLabels(maxCalorieSize, keys);
        return drawing;
    }

}
