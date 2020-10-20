package seedu.duke;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class GraphPropertyTest {
    private LocalDate date1 = LocalDate.of(2020, Month.AUGUST, 9);
    private LocalDate date2 = LocalDate.of(2020, Month.MARCH, 12);

    public DayMap setDummyMap(int days, int startCalories, LocalDate date, int divisor) {
        int calories = startCalories;
        DayMap dayMap = new DayMap();
        generateDays(days, date, calories, dayMap, divisor);
        return dayMap;
    }

    private void generateDays(int days, LocalDate date, int calories, DayMap dayMap, int divisor) {
        for (int i = 0; i < days; i++) {
            if ((i % divisor != 0) || (i == 0)) {
                dayMap.addActivity(date.atStartOfDay(), new Food("Apple", calories, false));
                date = date.plusDays(1);
                calories += 100;
            } else {
                dayMap.addActivity(date.atStartOfDay(), new Food("Apple", calories - 500, false));
                date = date.plusDays(1);
            }
        }
    }

    @Test
    public void plotgraph_success() {
        DayMap dummyMap = setDummyMap(7, 1800, date1, 4);
        GraphProperty hello = new GraphProperty(dummyMap, 2000);
        hello.drawGraph();
        hello.parseDate();

    }

    @Test
    public void plotgraph2_success() {
        DayMap dummyMap = setDummyMap(7, 2200, date2, 2);
        GraphProperty hello = new GraphProperty(dummyMap, 2300);
        hello.drawGraph();
        hello.parseDate();
    }

    @Test
    public void plotgraph3_success() {
        DayMap dummyMap = setDummyMap(7, 2200, date2, 2);
        GraphProperty hello = new GraphProperty(dummyMap, 3500);
        hello.drawGraph();
        hello.parseDate();
    }

    @Test
    public void plotgraph4_success() {
        DayMap dummyMap = setDummyMap(5, 2200, date2, 3);
        GraphProperty hello = new GraphProperty(dummyMap, 2000);
        hello.drawGraph();
        hello.parseDate();
    }
}