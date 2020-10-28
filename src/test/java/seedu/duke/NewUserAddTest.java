package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.userprofile.InitialiseAndCalculateUserProfile;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewUserAddTest {
    @Test
    void addNewUserTest_success() {
        InitialiseAndCalculateUserProfile userinfo =
                new InitialiseAndCalculateUserProfile("Sam","Female","50","130","20","2","maintain");
        String output = userinfo.toString();
        assertEquals(output, "Sam,Female,50,130,20,2,maintain");
    }
}