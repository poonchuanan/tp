package seedu.duke;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * This class is used to create a responsive interface for the listing feature
 */

public class listDrawer {
    private String date;
    protected ActivityList activityList;
    protected final String INDENT = "        ";
    protected final String DIVIDER = "-";
    protected final String DELIMITER = ",";
    protected final String DESCRIPTION = "Description";
    protected final String DATE = "Date";
    protected final String NUMBERS = "No.";
    protected final String NEWLINE = "\n";
    protected final String ACTIVITY_TYPE = "Type";
    protected final String FOOD_TYPE = "Food";
    protected final String EXERCISE_TYPE ="Exercise";
    protected final String CALORIES_GAIN_OR_LOST = "Calories gain or lost";
    protected final int START_INDEX_FOR_DESCRIPTION = 14 + INDENT.length() + ACTIVITY_TYPE.length();
    protected final int START_INDEX_FOR_CALORIES = 72 + INDENT.length() + ACTIVITY_TYPE.length();
    protected final int MAX_STRING_FOR_DESCRIPTION = 36 + DESCRIPTION.length();
    protected final int START_INDEX_FOR_EXERCISE_TYPE = 9;
    protected final int START_INDEX_FOR_FOOD_TYPE = 11;


    /**
     * Sets the date and activity list to be printed
     * @param date date which activity list to be used
     * @param activityList is the list to be used when creating the list
     */
    public listDrawer(LocalDate date, ActivityList activityList) {
        this.date = date.toString();
        this.activityList = activityList;
    }

    public listDrawer(ActivityList lastSeenList) {
        this.activityList = lastSeenList;
    }

    public void printListDrawing() {
        System.out.println(dateHeaderString()
                + listHeaderString()
                + NEWLINE
                + increaseStringLength(DIVIDER, listHeaderString().length())
                + NEWLINE
                + allActivityString());
    }


    protected String increaseStringLength(String stringToIncrease, int length) {

        return String.join("", Collections.nCopies(length, stringToIncrease));
    }

    protected String listHeaderString() {
        String header = NUMBERS
                + increaseStringLength(INDENT, 1) + ACTIVITY_TYPE
                + increaseStringLength(INDENT, 3) + DESCRIPTION
                + increaseStringLength(INDENT,3) + CALORIES_GAIN_OR_LOST;
        return header;
    }

    protected String dateHeaderString() {
        String dateHeaderString = "|  " + date + "  |";
        String dividerString = increaseStringLength(DIVIDER, dateHeaderString.length());
        return dividerString + NEWLINE + dateHeaderString + NEWLINE + dividerString + NEWLINE;
    }

    protected String singleActivityString(int index) {
        ArrayList<String> descriptions = new ArrayList<>();
        String restOfDescription="";

        String indexString = Integer.toString(index + 1);
        int lengthOfIndex = indexString.length();

        String descriptionString = activityList.getActivity(index).description;
        int lengthOfDescription = descriptionString.length();

        String calorieString = Integer.toString(activityList.getActivity(index).calories);
        String typeString;
        int lengthOfType;

        int lengthLeftForWhiteSpaceType;
        int lengthLeftForWhiteSpaceDescription;
        int lengthLeftForWhiteSpace;



        if(activityList.getActivity(index) instanceof Food) {
            typeString = FOOD_TYPE;
            lengthOfType = FOOD_TYPE.length();
            lengthLeftForWhiteSpaceType = START_INDEX_FOR_FOOD_TYPE - lengthOfIndex;

        } else {
            typeString = EXERCISE_TYPE;
            lengthOfType = EXERCISE_TYPE.length();
            lengthLeftForWhiteSpaceType = START_INDEX_FOR_EXERCISE_TYPE - lengthOfIndex;
        }

        lengthLeftForWhiteSpaceDescription = START_INDEX_FOR_DESCRIPTION
                - lengthOfIndex - lengthLeftForWhiteSpaceType - lengthOfType;



        if(lengthOfDescription > MAX_STRING_FOR_DESCRIPTION) {
            lengthLeftForWhiteSpace = START_INDEX_FOR_CALORIES - lengthOfIndex - lengthOfType
                    - lengthLeftForWhiteSpaceType - lengthLeftForWhiteSpaceDescription - MAX_STRING_FOR_DESCRIPTION;
        } else {
            lengthLeftForWhiteSpace = START_INDEX_FOR_CALORIES - lengthOfIndex - lengthOfType
                    - lengthLeftForWhiteSpaceType  - lengthLeftForWhiteSpaceDescription - lengthOfDescription;
        }


        //if the length of the description exceeds the maximum length, extract the rest of the description
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
                restOfDescription = restOfDescription
                        + increaseStringLength(" ", START_INDEX_FOR_DESCRIPTION)
                        + descriptions.get(i)
                        + NEWLINE;
            }


        }
        //    ----------------------------------------

        return indexString
                + increaseStringLength(" ", lengthLeftForWhiteSpaceType) + typeString
                + increaseStringLength(" ", lengthLeftForWhiteSpaceDescription) + descriptions.get(0)
                + increaseStringLength("_", lengthLeftForWhiteSpace) + calorieString
                + NEWLINE
                + restOfDescription;

    }

    protected String allActivityString() {
        String allActivityString = "";
        for(int i = 0; i < activityList.getNumberOfActivities(); i++) {
            allActivityString = allActivityString + singleActivityString(i) + NEWLINE;
        }
        return allActivityString;
    }
}
