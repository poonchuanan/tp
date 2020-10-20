package seedu.duke;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class GraphProperty {
    //Number of intervals - 10
    private static final int ROW = 11;
    private int Column;
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

    public void initTable(){
        this.Table = new int[ROW][Column];
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
        this.Column = keys.size();
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
        if (targetCalories > maxCalories) {
            maxCalories = targetCalories;
        } else if (targetCalories < minCalories) {
            minCalories = targetCalories;
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
        for (int i = 0; i < Column ; i++) {
            Table[targetRow][i] = 2;
        }
        for (int j = 0; j < Column ; j++) {
            calories[j] = (calories[j] - min_calories)/divisor;
        }
        System.out.println(Arrays.toString(calories));
        for (int i = ROW - 1; i >= 0 ; i--) {
            for (int j = 0; j< Column; j++) {
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
    public String generate_x_axis() {
        String x_axis_line = "|-+";
        for (int i = 0; i < Column - 1; i++) {
            x_axis_line += repeatCharacter("-", 5) + "+";
        }
        return x_axis_line;
    }



    public int getSizeOfCharacters(int number) {
        int size = 0;
        while (number != 0) {
            number /= 10;
            size++;
        }
        return size;
    }
    
    public String repeatCharacter(String character, int size) {
        String characterText = "";
        for (int i = 0 ; i < size; i++) {
            characterText += character;
        }
        return characterText;
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
        String space = repeatCharacter(" ", size);
        for(int i = ROW - 1; i >= 0; i--) {
            if (i == ROW - 1) {
                drawing += Integer.toString(max_calories) + "|";
            } else if (i == targetRow) {
                drawing += Integer.toString(targetCalories) + repeatCharacter(" ", Integer.toString(max_calories).length() - Integer.toString(targetCalories).length()) + "|";
            } else if (i == 0) {
                drawing += Integer.toString(min_calories) + repeatCharacter(" ", Integer.toString(max_calories).length() - Integer.toString(min_calories).length()) + "|";
            } else {
                drawing += space + "|";
            }
            for (int j = 0; j < Column; j++) {
                if (Table[i][j] == 0) {
                    drawing += repeatCharacter(" ", 3);
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
        System.out.println(repeatCharacter(" ", size) + generate_x_axis() + "--");
        System.out.println(repeatCharacter(" ", size - 1) + " " + parseDate());
        System.out.println(repeatCharacter(" ", size));
    }

}
