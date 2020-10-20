package seedu.duke;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class GraphProperty {
    //Number of intervals - 10
    private static final int ROW = 11;
    //Number of Days = 7
    private static final int COLUMN = 7;
    private static final String WIDTH = "   ";
    DayMap dayMap;
    ArrayList<LocalDate> keys;
    int targetCalories;
    int max_calories;
    int min_calories;
    int[][] Table;
    int targetRow;
    int[] calories;
    private final int DIVISOR = 10;

    //Appropirate division for y axis -> assume 10 for now
    //Round of each calories of the day
    //Assume x axis length to be always 7 for now

    public GraphProperty(DayMap dayMap, int targetCalories) {
        this.dayMap = dayMap;
        this.targetCalories = targetCalories;
    }
    public void setColumn() {

    }
    public void initTable(){
        this.Table = new int[ROW][COLUMN];
        for(int[] row : Table) {
            Arrays.fill(row, 0);
        }
    }

    public void setSortedKeys() {
        ArrayList<LocalDate> keys = new ArrayList<>();
        for (LocalDate key : dayMap.getHashMap().keySet()) {
            keys.add(key);
        }
        //sort the keys by date
        keys.sort(LocalDate::compareTo);
        this.keys = keys;
    }

    public void setCaloriesBound() {
        int minCalories = dayMap.getNetCalorieOfDay(keys.get(0));
        int maxCalories = dayMap.getNetCalorieOfDay(keys.get(0));
        this.calories = new int[keys.size()];
        calories[0] = dayMap.getNetCalorieOfDay(keys.get(0));
        for (int i = 1; i < keys.size(); i++) {
            if (minCalories > dayMap.getNetCalorieOfDay(keys.get(i))) {
                minCalories = dayMap.getNetCalorieOfDay(keys.get(i));
            } else if (maxCalories < dayMap.getNetCalorieOfDay(keys.get(i))) {
                maxCalories = dayMap.getNetCalorieOfDay(keys.get(i));
            }
            calories[i] = dayMap.getNetCalorieOfDay(keys.get(i));
        }
        this.min_calories = minCalories;
        this.max_calories = maxCalories;
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

    public int calculateDivisor() {
        return (max_calories - min_calories)/DIVISOR;
    }

    public void fillTable() {
        int divisor = calculateDivisor();
        int target = round(targetCalories, divisor) ;
        int low = round(min_calories, divisor);
        int high = round(max_calories, divisor);
        System.out.println(target-low);
        this.targetRow = (targetCalories - min_calories)/divisor;
        for (int i = 0; i < COLUMN ; i++) {
            Table[targetRow][i] = 2;
        }
        for (int j = 0; j < 7 ; j++) {
            calories[j] = (calories[j] - min_calories)/divisor;
        }
        System.out.println(Arrays.toString(calories));
        for (int i = ROW - 1; i >= 0 ; i--) {
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

    public int getSizeOfCharacters(int number) {
        int size = 0;
        while (number != 0) {
            number /= 10;
            size++;
        }
        return size;
    }

    public String whiteSpace_generator(int size) {
        String whitespace = "";
        for (int i = 0 ; i < size; i++) {
            whitespace += " ";
        }
        return whitespace;
    }
    public String parseDate() {
        String formattedDate = "";
        for (LocalDate key : keys) {
            formattedDate += key.format(DateTimeFormatter.ofPattern("dd/MM"));
            formattedDate += " ";
        }
        return formattedDate;
    }

    //Draws out the graph
    public void drawGraph() {
        setSortedKeys();
        setCaloriesBound();
        initTable();
        fillTable();
        String drawing = "";
        int round_max = round(max_calories, calculateDivisor());
        int round_target = round(targetCalories, calculateDivisor());
        int round_min = round(min_calories, calculateDivisor());
        int size = getSizeOfCharacters(round_max);
        String space = whiteSpace_generator(size);
        for(int i = ROW - 1; i >= 0; i--) {
            if (i == ROW - 1) {
                drawing += Integer.toString(round_max) + "|";
            } else if (i == targetRow) {
                drawing += Integer.toString(targetCalories) + whiteSpace_generator(Integer.toString(round_max).length() - Integer.toString(round_target).length()) + "|";
            } else if (i == 0) {
                drawing += Integer.toString(round_min) + whiteSpace_generator(Integer.toString(round_max).length() - Integer.toString(round_min).length()) + "|";
            } else {
                drawing += space + "|";
            }
            for (int j = 0; j < COLUMN; j++) {
                if (Table[i][j] == 0) {
                    drawing += WIDTH;
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
                    drawing += "|*|";
                }
                if (i == targetRow) {
                    drawing += "***";
                } else {
                    drawing += "   ";
                }
            }
            drawing += "\n";
        }
        System.out.print(drawing);
        System.out.println(whiteSpace_generator(size - 1) + " " + parseDate());
    }

    public String plot_y_axis() {
        String y_axis = "";
        int round_max = round(max_calories, calculateDivisor());
        int size = getSizeOfCharacters(round_max);
        String space = whiteSpace_generator(size);
        for(int i = 10; i >= 1; i--) {
            if (i == 10) {
                y_axis += Integer.toString(round_max) + "|\n";
            } else {
                y_axis += whiteSpace_generator(size) + "|\n";
            }
        }
        return y_axis;
    }
}
