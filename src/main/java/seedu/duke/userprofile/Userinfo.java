package seedu.duke.userprofile;

public class Userinfo {
    protected static String name;
    protected static String gender;
    protected static String weight;
    protected static String height;

    public Userinfo() {
    }

    public Userinfo(String name, String gender, String weight, String height) {
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
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

    public void printNewUserCalculatedDetails() {
        double bmi;
        bmi = Double.parseDouble(this.getWeight())
                 / (Double.parseDouble(this.getHeight()) * Double.parseDouble(this.getHeight()));
        System.out.println("Your BMI is " + bmi);

        if (this.getGender().equals("female")) {
            System.out.println("Your recommend calories requirements is 2000 calories\n"
                    + "We recommend 1500 calories to lose weight!\n");
        } else {
            System.out.println("Your recommend calories requirements is 2500 calories\n"
                    + "We recommend 2000 calories to lose weight!\n");
        }
    }

    public void editUserInfo(String userInput) {
        new Userinfo((userInput.substring(userInput.indexOf("n/") + 2, userInput.indexOf("g/") - 1)),
                (userInput.substring(userInput.indexOf("g/") + 2, userInput.indexOf("w/") - 1)),
                (userInput.substring(userInput.indexOf("w/") + 2, userInput.indexOf("h/") - 1)),
                userInput.substring(userInput.indexOf("h/") + 2));

        System.out.println("Noted, I have edited your user profile. Here are your new details: ");
        System.out.println("Name: " + this.getName());
        System.out.println("Gender: " + this.getGender());
        System.out.println("Weight: " + this.getWeight());
        System.out.println("Height: " + this.getHeight());
        printNewUserCalculatedDetails();
    }

    @Override
    public String toString() {
        return getName() + "," + getGender() + "," + getWeight() + "," + getHeight();
    }
}

