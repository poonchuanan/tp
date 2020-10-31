package seedu.duke.userprofile;

import java.text.DecimalFormat;
import static seedu.duke.ui.ExceptionMessages.displayInvalidActivityFactorMessage;

public class InitialiseUserProfile {
    protected String name;
    protected String gender;
    protected String weight;
    protected String height;
    protected String age;
    protected String activityLevel;
    protected String weightGoal;
    protected double calories;

    public InitialiseUserProfile() {}

    public InitialiseUserProfile(String name, String gender, String weight, String height,
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

    public String getActivityLevel() {
        return activityLevel;
    }

    public String getWeightGoal() {
        return weightGoal;
    }

    public double getCalories() {
        return calories;
    }

    private static DecimalFormat df2 = new DecimalFormat("#.00");


    public String calculateNewUserDetails() {
        double activityMultiple = 0;

        switch (Integer.parseInt(this.getActivityLevel())) {
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

    public void printList() {
        System.out.println("Here is your user profile:");
        System.out.println("Name : " + getName());
        System.out.println("Gender : " + getGender());
        System.out.println("Weight : " + getWeight());
        System.out.println("Height : " + getHeight());
        System.out.println("Age : " + getAge());
        System.out.println("Activity Level : " + getActivityLevel());
        System.out.println("Weight Goal : " + getWeightGoal());
    }

    @Override
    public String toString() {
        return getName() + "," + getGender() + "," + getWeight() + ","
                + getHeight() + "," + getAge() + "," + getActivityLevel() + "," + getWeightGoal();
    }
}

