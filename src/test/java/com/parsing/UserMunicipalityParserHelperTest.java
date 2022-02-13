package com.parsing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserMunicipalityParserHelperTest {

    UserMunicipalityParserHelper userMunicipalityParserHelper = new UserMunicipalityParserHelper();

    @BeforeAll
    void populateMunicipalitiesData(){
        userMunicipalityParserHelper.parseMunicipalities(Arrays.asList(UserMunicipalityParserHelperTestValues.MUNICIPALITY_LINES));

    }

    @Test
    void testPopulateMunicipalities(){
        Assertions.assertEquals(6, userMunicipalityParserHelper.getMunicipalitiesMap().size());
    }

    @Test
    void testPopulateUsers(){
        userMunicipalityParserHelper.parseUsers(Arrays.asList(UserMunicipalityParserHelperTestValues.USER_LINES));
        Assertions.assertEquals(5, userMunicipalityParserHelper.getUsers().size());
    }

}
