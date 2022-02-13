package com.calculator;

import com.model.PopulationReportData;
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
public class PopulationReportDataCalculatorTest {

    List<User> usersTestData;

    @BeforeAll
    void configureUsersData() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(UserParser.USER_DATE_FORMAT);
        User[] users = {
                new User("USER00001", "M", formatter.parse("1972-05-23"),
                        PopulationReportDataCalculatorTestValues.MUNICIPALITY_1.getCode(),
                        Optional.of(PopulationReportDataCalculatorTestValues.MUNICIPALITY_1)),
                new User("USER00002", "M", formatter.parse("1980-01-04"),
                        PopulationReportDataCalculatorTestValues.MUNICIPALITY_1.getCode(),
                        Optional.of(PopulationReportDataCalculatorTestValues.MUNICIPALITY_1)),
                new User("USER00003", "F", formatter.parse("2001-06-15"),
                        PopulationReportDataCalculatorTestValues.MUNICIPALITY_1.getCode(),
                        Optional.of(PopulationReportDataCalculatorTestValues.MUNICIPALITY_1)),
                new User("USER00004", "F", formatter.parse("1997-04-18"),
                        PopulationReportDataCalculatorTestValues.MUNICIPALITY_2.getCode(),
                        Optional.of(PopulationReportDataCalculatorTestValues.MUNICIPALITY_2)),
                new User("USER00005", "F", formatter.parse("1995-02-22"),
                        PopulationReportDataCalculatorTestValues.MUNICIPALITY_3.getCode(),
                        Optional.of(PopulationReportDataCalculatorTestValues.MUNICIPALITY_3)),
                new User("USER00006", "M", formatter.parse("1995-02-22"),
                        PopulationReportDataCalculatorTestValues.MUNICIPALITY_3.getCode(),
                        Optional.of(PopulationReportDataCalculatorTestValues.MUNICIPALITY_3)),
                new User("USER00007", "F", formatter.parse("1995-02-22"),
                        PopulationReportDataCalculatorTestValues.MUNICIPALITY_3.getCode(),
                        Optional.of(PopulationReportDataCalculatorTestValues.MUNICIPALITY_3))
        };
        usersTestData = Arrays.asList(users);


    }

    @Test
    void testPopulationReportDataCalculator() {
        PopulationReportDataCalculator populationReportDataCalculator = new PopulationReportDataCalculator();
        List<PopulationReportData> populationReportsData = populationReportDataCalculator.calculateReport(usersTestData);
        Assertions.assertEquals(populationReportsData.size(), 5);
        Assertions.assertEquals(populationReportsData.get(0).getRegion(), "Sicilia");
        Assertions.assertEquals(populationReportsData.get(0).getUserPercentage(), 57.1);
        Assertions.assertTrue(populationReportsData.get(1).getCityOpt().isPresent());
        Assertions.assertEquals(populationReportsData.get(1).getCityOpt().get(), "PA");
        Assertions.assertEquals(populationReportsData.get(1).getUserPercentage(), 14.3);

    }
}
