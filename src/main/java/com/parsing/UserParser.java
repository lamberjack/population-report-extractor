package com.parsing;

import com.model.Municipality;
import com.model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Parser for the user data
 */
public class UserParser implements Parser<User, String>{

    public static final String USER_DATE_FORMAT = "yyyy-MM-dd";


    @Override
    public User parseLine(String line) throws ParseException {
        User user = new User();
        String[] userStringValues = line.split(",");
        user.setCode(userStringValues[0]);
        user.setGender(userStringValues[1]);
        SimpleDateFormat formatter = new SimpleDateFormat(USER_DATE_FORMAT);
        user.setDateOfBirth(formatter.parse(userStringValues[2]));
        user.setMunicipalityCode(userStringValues[3]);
        return user;
    }


}
