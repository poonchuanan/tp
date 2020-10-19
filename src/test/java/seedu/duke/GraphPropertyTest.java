package seedu.duke;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class GraphPropertyTest {
    private final static int DAYS = 7;
    int targetCalories = 2000;

    public DayMap setDummyMap() {
        int calories = 1800;
        LocalDate date = LocalDate.of(2020, Month.AUGUST, 9);
        DayMap dayMap = new DayMap();
        for (int i = 0; i < DAYS; i++) {
            dayMap.addActivity(date.atStartOfDay(), new Food("Apple", calories, false));
            date = date.plusDays(1);
            calories += 100;
        }
        return dayMap;
    }

    @Test
    public void plotgraph_success() {
        DayMap dummyMap = setDummyMap();
        new GraphProperty(dummyMap, targetCalories).drawGraph();
    }
}