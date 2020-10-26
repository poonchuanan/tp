package seedu.duke;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class listDrawer {
    private String date;
    private ActivityList activityList;
    private final String INDENT = "        ";
    private final String DIVIDER = "-";
    private final String DELIMITER = ",";
    private final String DESCRIPTION = "Description";
    private final String DATE = "Date";
    private final String NUMBERS = "No.";
    private final String NEWLINE = "\n";
    private final String ACTIVITY_TYPE = "Type";
    private final String FOOD_TYPE = "Food";
    private final String EXERCISE_TYPE ="Exercise";
    private final String CALORIES_GAIN_OR_LOST = "Calories gain or lost";
    private final int START_INDEX_FOR_DESCRIPTION = 14 + INDENT.length() + ACTIVITY_TYPE.length();
    private final int START_INDEX_FOR_CALORIES = 72 + INDENT.length() + ACTIVITY_TYPE.length();
    private final int MAX_STRING_FOR_DESCRIPTION = 36 + DESCRIPTION.length();
    private final int START_INDEX_FOR_FOOD_TYPE = 11;
    private final int START_INDEX_FOR_EXERCISE_TYPE = 9;



    public listDrawer(LocalDate date, ActivityList activityList) {
        this.date = date.toString();
        this.activityList = activityList;
    }

    public void printListDrawing() {
        System.out.println(dateHeaderString()
                + listHeaderString()
                + allActivityString());
    }


    private String increaseStringLength(String stringToIncrease, int length) {

        return String.join("", Collections.nCopies(length, stringToIncrease));
    }

    private String listHeaderString() {
        String toPrint = NUMBERS + increaseStringLength(INDENT, 1) + ACTIVITY_TYPE + increaseStringLength(INDENT, 3) + DESCRIPTION + increaseStringLength(INDENT,3) + CALORIES_GAIN_OR_LOST;
        String startDivider = increaseStringLength(DIVIDER, toPrint.length());
        return toPrint + NEWLINE + startDivider + NEWLINE;
    }

    private String dateHeaderString() {
        String dateHeaderString = "|  " + date + "  |";
        String dividerString = increaseStringLength(DIVIDER, dateHeaderString.length());
        return dividerString + NEWLINE + dateHeaderString + NEWLINE + dividerString + NEWLINE;
    }

    private String singleActivityString(int index) {
        ArrayList<String> descriptions = new ArrayList<>();
        String descriptions2="";

        String indexString = Integer.toString(index + 1);
        String descriptionString = activityList.getActivity(index).description;
        String calorieString = Integer.toString(activityList.getActivity(index).calories);
        String typeString;
        int lengthOfType;
        int lengthLeftForWhiteSpaceType;


        int lengthOfIndex = indexString.length();

        if(activityList.getActivity(index) instanceof Food) {
            typeString = FOOD_TYPE;
            lengthOfType = FOOD_TYPE.length();
            lengthLeftForWhiteSpaceType = START_INDEX_FOR_FOOD_TYPE - lengthOfIndex;

        } else {
            typeString = EXERCISE_TYPE;
            lengthOfType = EXERCISE_TYPE.length();
            lengthLeftForWhiteSpaceType = START_INDEX_FOR_EXERCISE_TYPE - lengthOfIndex;
        }




        int lengthLeftForWhiteSpaceDescription = START_INDEX_FOR_DESCRIPTION - lengthOfIndex - lengthLeftForWhiteSpaceType - lengthOfType;




        int lengthOfDescription = descriptionString.length();
        int lengthLeftForWhiteSpace;

        if(lengthOfDescription > MAX_STRING_FOR_DESCRIPTION) {
            lengthLeftForWhiteSpace = START_INDEX_FOR_CALORIES - lengthOfIndex - lengthOfType - lengthLeftForWhiteSpaceType - lengthLeftForWhiteSpaceDescription - MAX_STRING_FOR_DESCRIPTION;
        } else {
            lengthLeftForWhiteSpace = START_INDEX_FOR_CALORIES - lengthOfIndex - lengthOfType - lengthLeftForWhiteSpaceType  - lengthLeftForWhiteSpaceDescription - lengthOfDescription;
        }


        //-------------------------------------------
        while (lengthOfDescription > MAX_STRING_FOR_DESCRIPTION) {
            String description = descriptionString.substring(0, MAX_STRING_FOR_DESCRIPTION);
            descriptions.add(description);
            System.out.println(Arrays.toString(descriptions.toArray()));
            descriptionString = descriptionString.substring(MAX_STRING_FOR_DESCRIPTION);
            lengthOfDescription = descriptionString.length();

        }
        descriptions.add(descriptionString);


        if(descriptions.size()>1) {
            for (int i = 1; i < descriptions.size(); i++){
                descriptions2 = descriptions2 + increaseStringLength(" ", START_INDEX_FOR_DESCRIPTION)+ descriptions.get(i) + NEWLINE;
            }
            System.out.println(descriptions2);


        }
        //    ----------------------------------------

            String singleActivity = indexString + increaseStringLength(" ", lengthLeftForWhiteSpaceType) + typeString+ increaseStringLength(" ", lengthLeftForWhiteSpaceDescription) + descriptions.get(0) + increaseStringLength("_", lengthLeftForWhiteSpace) + calorieString + NEWLINE + descriptions2;
            return singleActivity;

    }

    private String allActivityString() {
        String allActivityString = "";
        for(int i=0; i<activityList.getNumberOfActivities(); i++) {
            allActivityString = allActivityString + singleActivityString(i) + NEWLINE;
        }
        return allActivityString;
    }
}
