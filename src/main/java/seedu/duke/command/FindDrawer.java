package seedu.duke.command;

import seedu.duke.ActivityList;
import seedu.duke.Food;
import seedu.duke.listDrawer;

import java.util.ArrayList;
import java.util.Arrays;

public class FindDrawer extends listDrawer {

    private final int START_INDEX_FOR_DATE = START_INDEX_FOR_CALORIES + INDENT.length();
    private final String ACTIVITY_DATE = "Date";
    private final int START_INDEX_FOR_ACTIVITY_DATE = START_INDEX_FOR_CALORIES + 5;


    public FindDrawer(ActivityList lastSeenList) {
        super(lastSeenList);

    }

    @Override
    public void printListDrawing() {
        System.out.println(listHeaderString()
                + NEWLINE
                + increaseStringLength(DIVIDER, listHeaderString().length())
                + NEWLINE
                + allActivityString());
    }

    @Override
    protected String singleActivityString(int index) {
        ArrayList<String> descriptions = new ArrayList<>();
        String descriptions2="";

        String indexString = Integer.toString(index + 1);
        String descriptionString = activityList.getActivity(index).getActivityDescription();
        String calorieString = Integer.toString(activityList.getActivity(index).getActivityCalories());
        String dateString = activityList.getActivity(index).getActivityDate().toString();
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


        int lengthOfDateString = dateString.length();
        int lengthOfCalorieString = calorieString.length();
        int lengthLeftForWhiteSpaceDate;

        if(lengthOfDescription > MAX_STRING_FOR_DESCRIPTION) {
            lengthLeftForWhiteSpace = START_INDEX_FOR_CALORIES - lengthOfIndex - lengthOfType - lengthLeftForWhiteSpaceType - lengthLeftForWhiteSpaceDescription - MAX_STRING_FOR_DESCRIPTION;

        } else {
            lengthLeftForWhiteSpace = START_INDEX_FOR_CALORIES - lengthOfIndex - lengthOfType - lengthLeftForWhiteSpaceType  - lengthLeftForWhiteSpaceDescription - lengthOfDescription;
            //lengthLeftForWhiteSpaceDate = START_INDEX_FOR_ACTIVITY_DATE - lengthOfIndex - lengthOfType - lengthLeftForWhiteSpaceType  - lengthLeftForWhiteSpaceDescription - lengthOfDescription - lengthOfCalorieString;
        }
        lengthLeftForWhiteSpaceDate = START_INDEX_FOR_ACTIVITY_DATE - lengthOfIndex - lengthOfType - lengthLeftForWhiteSpaceType  - lengthLeftForWhiteSpaceDescription - MAX_STRING_FOR_DESCRIPTION - lengthOfCalorieString;


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

        String singleActivity = indexString + increaseStringLength(" ", lengthLeftForWhiteSpaceType) + typeString+ increaseStringLength(" ", lengthLeftForWhiteSpaceDescription) + descriptions.get(0) + increaseStringLength("_", lengthLeftForWhiteSpace) + calorieString + increaseStringLength("_", lengthLeftForWhiteSpaceDate) + dateString + NEWLINE + descriptions2;
        return singleActivity;

    }

    @Override
    protected String listHeaderString() {
        return super.listHeaderString() + INDENT + ACTIVITY_DATE;
    }


}
