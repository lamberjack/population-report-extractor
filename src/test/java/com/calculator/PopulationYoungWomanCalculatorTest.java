package com.calculator;

import com.model.User;
import com.parsing.UserParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PopulationYoungWomanCalculatorTest {

    List<User> usersTestData;

    @BeforeAll
    void configureUsersData() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(UserParser.USER_DATE_FORMAT);
        User[] users = {
                //tuscany
                new User("USER00001", "M", formatter.parse("1972-05-23"),
                        PopulationYoungWomanCalculatoTestValues.MUNICIPALITY_1.getCode(),
                        Optional.of(PopulationYoungWomanCalculatoTestValues.MUNICIPALITY_1)),
                new User("USER00002", "M", formatter.parse("1980-01-04"),
                        PopulationYoungWomanCalculatoTestValues.MUNICIPALITY_1.getCode(),
                        Optional.of(PopulationYoungWomanCalculatoTestValues.MUNICIPALITY_1)),

                //sicily
                new User("USER00003", "M", formatter.parse("2001-06-15"),
                        PopulationYoungWomanCalculatoTestValues.MUNICIPALITY_2.getCode(),
                        Optional.of(PopulationYoungWomanCalculatoTestValues.MUNICIPALITY_2)),
                new User("USER00004", "F", formatter.parse("1997-04-18"),
                        PopulationYoungWomanCalculatoTestValues.MUNICIPALITY_2.getCode(),
                        Optional.of(PopulationYoungWomanCalculatoTestValues.MUNICIPALITY_2)),

                //sardinia
                new User("USER00005", "F", formatter.parse("1995-02-22"),
                        PopulationYoungWomanCalculatoTestValues.MUNICIPALITY_3.getCode(),
                        Optional.of(PopulationYoungWomanCalculatoTestValues.MUNICIPALITY_3)),
                new User("USER00006", "M", formatter.parse("2009-12-12"),
                        PopulationYoungWomanCalculatoTestValues.MUNICIPALITY_3.getCode(),
                        Optional.of(PopulationYoungWomanCalculatoTestValues.MUNICIPALITY_3)),
                new User("USER00007", "F", formatter.parse("1956-08-01"),
                        PopulationYoungWomanCalculatoTestValues.MUNICIPALITY_3.getCode(),
                        Optional.of(PopulationYoungWomanCalculatoTestValues.MUNICIPALITY_3)),
                new User("USER00008", "F", formatter.parse("1995-02-22"),
                        PopulationYoungWomanCalculatoTestValues.MUNICIPALITY_3.getCode(),
                        Optional.of(PopulationYoungWomanCalculatoTestValues.MUNICIPALITY_4)),
                new User("USER00009", "M", formatter.parse("1995-02-22"),
                        PopulationYoungWomanCalculatoTestValues.MUNICIPALITY_4.getCode(),
                        Optional.of(PopulationYoungWomanCalculatoTestValues.MUNICIPALITY_3)),
                new User("USER000010", "M", formatter.parse("1922-02-22"),
                        PopulationYoungWomanCalculatoTestValues.MUNICIPALITY_4.getCode(),
                        Optional.of(PopulationYoungWomanCalculatoTestValues.MUNICIPALITY_4))

        };
        usersTestData = Arrays.asList(users);
    }

    @Test
    void testPopulationYoungWomanCalculator(){
        PopulationYoungWomanCalculator populationYoungWomanCalculator = new PopulationYoungWomanCalculator();
        String reportResult = populationYoungWomanCalculator.calculateReport(usersTestData);
        Assertions.assertEquals("Sicilia", reportResult);
    }

}
