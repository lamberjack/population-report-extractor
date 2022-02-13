package com.parsing;

import com.model.Municipality;
import com.model.User;
import org.junit.jupiter.api.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserParserTest {



    @Test
    void testUserParseLine() throws ParseException {
        UserParser userParser = new UserParser();
        User user = userParser.parseLine(UserParserTestValues.USER_LINE);
        Assertions.assertEquals( UserParserTestValues.USER_CODE, user.getCode());
        Assertions.assertEquals(UserParserTestValues.USER_GENDER, user.getGender());
        SimpleDateFormat formatter = new SimpleDateFormat(UserParser.USER_DATE_FORMAT);
        Date dateOfBirth = formatter.parse(UserParserTestValues.USER_DATE_OF_BIRTH);
        Assertions.assertTrue(user.getDateOfBirth().equals(dateOfBirth));

    }

}
