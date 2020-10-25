package seedu.duke.userprofile;

import java.text.DecimalFormat;
import seedu.duke.Ui;
import static seedu.duke.ExceptionMessages.displayInvalidActivityFactorMessage;

public class Userinfo {
    protected String name;
    protected String gender;
    protected String weight;
    protected String height;
    protected String age;
    protected String activityfactor;
    protected String weightGoal;
    protected double calories;

    public Userinfo() {
    }

    public Userinfo(String name, String gender, String weight, String height,
                    String age, String activityfactor, String weightGoal) {
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.activityfactor = activityfactor;
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
        return activityfactor;
    }

    public String getWeightGoal() {
        return weightGoal;
    }

    public double getCalories() {
        return calories;
    }

    private static DecimalFormat df2 = new DecimalFormat("##.##");


    public String calculateNewUserDetails() {
        double activityMultiple;

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
            activityMultiple = 1.55;
            //Throw exception here or sth
            break;
        }

        String details = "";
        double bmi;
        double calories = 0;
        bmi = (Double.parseDouble(this.getWeight())
                / (Double.parseDouble(this.getHeight()) * Double.parseDouble(this.getHeight())))
                * 10000;
        assert bmi > 0 : "bmi should be more than 0";

        details += "Your BMI is " + df2.format(bmi) + "\n";

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
        } else {
            details += "\n";
        }
        this.calories = calories;
        return details;
    }

    public void editUserInfo(String userInput) {
        Userinfo profile = new Userinfo((userInput.substring(userInput.indexOf("n/") + 2, userInput.indexOf("g/") - 1)),
                (userInput.substring(userInput.indexOf("g/") + 2, userInput.indexOf("w/") - 1)),
                (userInput.substring(userInput.indexOf("w/") + 2, userInput.indexOf("h/") - 1)),
                (userInput.substring(userInput.indexOf("h/") + 2, userInput.indexOf("a/") - 1)),
                (userInput.substring(userInput.indexOf("a/") + 2, userInput.indexOf("af/") - 1)),
                (userInput.substring(userInput.indexOf("af/") + 3, userInput.indexOf("goal/") - 1)),
                userInput.substring(userInput.indexOf("goal/") + 5));

        Ui.drawDivider();
        System.out.println("Noted, I have edited your user profile. Here are your new details: ");
        System.out.println("Name: " + this.getName());
        System.out.println("Gender: " + this.getGender());
        System.out.println("Weight: " + this.getWeight());
        System.out.println("Height: " + this.getHeight());
        System.out.println("Age: " + this.getAge());
        System.out.println("Activity: " + this.getactivityfactor());
        System.out.println("Weight Goal: " + this.getWeightGoal());
        System.out.println(profile.calculateNewUserDetails());

    }

    @Override
    public String toString() {
        return getName() + "," + getGender() + "," + getWeight() + ","
                + getHeight() + "," + getAge() + "," + getactivityfactor() + "," + getWeightGoal();
    }
}

