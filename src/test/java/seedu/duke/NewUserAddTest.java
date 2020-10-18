package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.userprofile.Userinfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewUserAddTest {
    @Test
    void addNewUserTest_success() {
        Userinfo userinfo = new Userinfo("Sam","Female","50","130","20","2","maintain");
        String output = userinfo.toString();
        assertEquals(output, "Sam,Female,50,130,20,2,maintain");
    }
}