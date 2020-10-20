package seedu.duke;
;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class GraphProperty {
    public final int ROW = 11;
    private final String dateStyle= "dd/MM";
    private final int INTERVAL_PRECISION = 2;
    private static  int TARGET_TYPE = 2;
    private static int LIMIT_TYPE = 4;
    public int targetRow;
    public final int Column;
    public final DayMap dayMap;
    ArrayList<LocalDate> keys;
    public int targetCalories;
    public int max_calories;
    public int min_calories;
    public int[][] Table;
    private final int DIVISOR = 10;

    /**
     * Constructor for the graph.
     * @param dayMap hashmap containing dates
     * @param targetCalories tagret calories from userprofile
     */
    public GraphProperty(DayMap dayMap, int targetCalories, int days) {
        this.dayMap = dayMap;
        this.targetCalories = targetCalories;
        this.Column = days;
        setProperties();

    }

    /**
     * set othere properties by calculation.
     */
    public void setProperties() {
        this.keys = sortKeys();
        ArrayList<Integer> calories = getCalories();
        this.Table = initiateTable(calories);
    }

    /**
     * Initiates a 2 dimension table and fills the table with 0.
     */
    public int[][] setEmptyTable(int[][] table){
        for(int[] row : table) {
            Arrays.fill(row, 0);
        }
        return table;
    }

    /**
     * get and sort keys from hashmap.
     * @return sorted keys in arraylist
     */
    public ArrayList<LocalDate> sortKeys() {
        ArrayList<LocalDate> keys = new ArrayList<>();
        for (LocalDate key : dayMap.getHashMap().keySet()) {
            keys.add(key);
        }
        //sort the keys by date
        keys.sort(LocalDate::compareTo);
        return keys;
    }

    /**
     * get calories from the dates.
     * @return array of calories
     */
    public ArrayList<Integer> getCalories() {
        int currentCalories;
        int minCalories = targetCalories;
        int maxCalories = targetCalories;
        ArrayList<Integer> calories = new ArrayList<>();
        for (LocalDate date : keys) {
            currentCalories = dayMap.getNetCalorieOfDay(date);
            calories.add(currentCalories);
            maxCalories = findMaximum(maxCalories, currentCalories);
            minCalories = findMinimum(minCalories, currentCalories);
        }
        this.min_calories = minCalories;
        this.max_calories = maxCalories;
        return calories;
    }

    /**
     * Compares and finds the minimum between 2 numbers.
     * @param number1 first number to compare
     * @param number2 second number to compare
     * @return the lesser number
     */
    public int findMinimum(int number1, int number2) {
        if (number1 < number2) {
            return number1;
        } else {
            return number2;
        }
    }

    /**
     * Compares and finds the maximum between 2 numbers.
     * @param number1 first number to compare
     * @param number2 second number to compare
     * @return the greater number
     */
    public int findMaximum(int number1, int number2) {
        if (number1 < number2) {
            return number2;
        }
        return number1;
    }

    /**
     * Calculates interval of the graph.
     * @return interval value
     */
    public int calculateInterval() {
        return (max_calories - min_calories)/DIVISOR;
    }


    /**
     * fills up the table with appropriate values.
     * 0 -> empty spaces.
     * 1 -> middle portion of the bar.
     * 2 -> target row.
     * 3 -> target row  + middle portion of the bar.
     * 4 -> top symbol of the bar.
     * @param table representation of graph in 2d array.
     * @param calories calories list
     */
    public void fillTable(int[][] table, ArrayList<Integer> calories) {
        this.targetRow = calculateRowNumber(targetCalories);
        int rowNumber;
        for (int i = ROW - 1; i >= 0 ; i--) {
            for (int j = 0; j< Column; j++) {
                rowNumber = calculateRowNumber(calories.get(j));
                if (rowNumber == i) {
                    table[i][j] = LIMIT_TYPE;
                } else if (targetRow == i) {
                    table[i][j] = TARGET_TYPE;
                }
                if (rowNumber > i) {
                    table[i][j]++;
                }
            }
        }
    }

    /**
     * Parses the date into string.
     * @return date in dd/MM formate
     */
    public String parseDate(ArrayList<LocalDate> keys) {
        String formattedDate = "";
        for (LocalDate key : keys) {
            formattedDate += key.format(DateTimeFormatter.ofPattern(dateStyle));
            formattedDate += " ";
        }
        return formattedDate;
    }

    /**
     * Initiates a table.
     * @return table
     */
    public int[][] initiateTable(ArrayList<Integer> calories) {
        int [][]table = new int[ROW][Column];
        setEmptyTable(table);
        fillTable(table, calories);
        return table;
    }

    /**
     * find the row number corresponding to the calories
     */
    public int calculateRowNumber(int calories) {
        int interval = calculateInterval();
        return (calories - min_calories)/interval;
    }

}
