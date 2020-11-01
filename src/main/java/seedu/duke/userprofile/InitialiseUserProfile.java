package seedu.duke.userprofile;

import java.text.DecimalFormat;

public class InitialiseUserProfile {
    protected String name;
    protected String gender;
    protected String weight;
    protected String height;
    protected String age;
    protected String activityLevel;
    protected String weightGoal;
    protected double calories;

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

    public void calculateEditedUserDetails() {
        double activityMultiple = calculateActivityMultiple(this.activityLevel);
        double bmi = calculateBmi(this.weight, this.height);
        assert bmi > 0 : "bmi should be more than 0";

        calories = calculateCalories(this.gender, this.weight, this.height, this.age) * activityMultiple;
        assert calories > 0 : "calories should be greater than 0";
    }

    public String calculateNewUserDetails() {
        double activityMultiple = calculateActivityMultiple(this.activityLevel);

        String details = "";
        double bmi = calculateBmi(this.weight, this.height);
        assert bmi > 0 : "bmi should be more than 0";

        details += "\nYour BMI is " + df2.format(bmi) + "\n";

        calories = calculateCalories(this.gender, this.weight, this.height, this.age) * activityMultiple;
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
        return details;
    }

    public double calculateActivityMultiple(String activityLevel) {
        switch (Integer.parseInt(activityLevel)) {
        case 1:
            return 1.2;
        case 2:
            return 1.375;
        case 3:
            return 1.55;
        case 4:
            return 1.725;
        case 5:
            return 1.9;
        default:
        }
        return 1;
    }

    public double calculateBmi(String weight, String height) {
        return (Double.parseDouble(weight)
                / (Double.parseDouble(height) * Double.parseDouble(height)))
                * 10000;
    }

    public double calculateCalories(String gender, String weight, String height, String age) {
        double v = (10 * Double.parseDouble(weight))
                + (6.25 * Double.parseDouble(height));

        if (gender.equals("female")) {
            return ((v) - (5 * Double.parseDouble(age)) - 161);
        } else {
            return (v - (5 * Double.parseDouble(age)) + 5);
        }
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

