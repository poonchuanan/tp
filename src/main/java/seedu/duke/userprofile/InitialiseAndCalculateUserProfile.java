package seedu.duke.userprofile;

import java.text.DecimalFormat;
import seedu.duke.ui.Ui;
import static seedu.duke.ui.ExceptionMessages.displayInvalidActivityFactorMessage;

public class InitialiseAndCalculateUserProfile {
    protected String name;
    protected String gender;
    protected String weight;
    protected String height;
    protected String age;
    protected String activityLevel;
    protected String weightGoal;
    protected double calories;

    public InitialiseAndCalculateUserProfile() {
    }

    public InitialiseAndCalculateUserProfile(String name, String gender, String weight, String height,
                                             String age, String activityLevel, String weightGoal) {
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.activityLevel = activityLevel;
        this.weightGoal = weightGoal;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getWeight() {
        return weight;
    }

    public String getHeight() {
        return height;
    }

    public String getAge() {
        return age;
    }

    public String getactivityfactor() {
        return activityLevel;
    }

    public String getWeightGoal() {
        return weightGoal;
    }

    public double getCalories() {
        return calories;
    }

    private static DecimalFormat df2 = new DecimalFormat(".##");


    public String calculateNewUserDetails() {
        double activityMultiple = 0;

        switch (Integer.parseInt(this.getactivityfactor())) {
        case 1:
            activityMultiple = 1.2;
            break;
        case 2:
            activityMultiple = 1.375;
            break;
        case 3:
            activityMultiple = 1.55;
            break;
        case 4:
            activityMultiple = 1.725;
            break;
        case 5:
            activityMultiple = 1.9;
            break;
        default:
            displayInvalidActivityFactorMessage();
            break;
        }

        String details = "";
        double bmi;
        double calories = 0;
        bmi = (Double.parseDouble(this.getWeight())
                / (Double.parseDouble(this.getHeight()) * Double.parseDouble(this.getHeight())))
                * 10000;
        assert bmi > 0 : "bmi should be more than 0";

        details += "\nYour BMI is " + df2.format(bmi) + "\n";

        if (this.getGender().equals("female")) {
            calories = ((10 * Double.parseDouble(this.getWeight()))
                    + (6.25 * Double.parseDouble(this.getHeight()))
                    - (5 * Double.parseDouble(this.getAge())) - 161)
                    * activityMultiple;
        } else {
            calories = ((10 * Double.parseDouble(this.getWeight()))
                    + (6.25 * Double.parseDouble(this.getHeight()))
                    - (5 * Double.parseDouble(this.getAge())) + 5)
                    * activityMultiple;
        }

        assert calories > 0 : "calories should be greater than 0";

        details += "Your recommend daily calories intake is " + calories + " calories." + "\n";

        if (this.getWeightGoal().equals("lose")) {
            calories -= 500;
            details += "To " + this.getWeightGoal() + " weight, you should consume "
                    + calories + " calories instead.\n";
        } else if (this.getWeightGoal().equals("gain")) {
            calories += 500;
            details += "To " + this.getWeightGoal() + " weight, you should consume "
                    + calories + " calories instead.\n";
        }

        this.calories = calories;
        return details;
    }

    public static InitialiseAndCalculateUserProfile editUserInfo(String userInput) {
        InitialiseAndCalculateUserProfile profile = new InitialiseAndCalculateUserProfile(
                (userInput.substring(userInput.indexOf("n/") + 2, userInput.indexOf("g/") - 1)),
                (userInput.substring(userInput.indexOf("g/") + 2, userInput.indexOf("w/") - 1)),
                (userInput.substring(userInput.indexOf("w/") + 2, userInput.indexOf("h/") - 1)),
                (userInput.substring(userInput.indexOf("h/") + 2, userInput.indexOf("a/") - 1)),
                (userInput.substring(userInput.indexOf("a/") + 2, userInput.indexOf("af/") - 1)),
                (userInput.substring(userInput.indexOf("af/") + 3, userInput.indexOf("goal/") - 1)),
                userInput.substring(userInput.indexOf("goal/") + 5));

        Ui.drawDivider();
        System.out.println("Noted, I have edited your user profile. Here are your new details: ");
        System.out.println("Name: " + profile.getName());
        System.out.println("Gender: " + profile.getGender());
        System.out.println("Weight: " + profile.getWeight());
        System.out.println("Height: " + profile.getHeight());
        System.out.println("Age: " + profile.getAge());
        System.out.println("Activity: " + profile.getactivityfactor());
        System.out.println("Weight Goal: " + profile.getWeightGoal());
        System.out.println(profile.calculateNewUserDetails());
        return profile;
    }

    @Override
    public String toString() {
        return getName() + "," + getGender() + "," + getWeight() + ","
                + getHeight() + "," + getAge() + "," + getactivityfactor() + "," + getWeightGoal();
    }
}

