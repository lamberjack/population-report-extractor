package com.calculator;

import com.model.PopulationReportData;
import com.model.User;

import java.util.*;
import java.util.stream.Collectors;

public class PopulationYoungWomanCalculator implements ReportCalculator<List<User>, String> {

    @Override
    public String calculateReport(List<User> users) {

        Map<String, Double> regionWithAgeMap = users.stream()
                .filter(user -> user.getMunicipalityOpt().isPresent())
                .filter(user -> user.getGender().equals("F"))
                .collect(Collectors.groupingBy(user -> user.getMunicipalityOpt().get().getRegion()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> calculateAverageAge(entry.getValue())));

        Map.Entry<String, Double> min = Collections.min(regionWithAgeMap.entrySet(),   Comparator.comparing(Map.Entry::getValue));
        return min.getKey();
    }

    private Double calculateAverageAge(List<User> users){
        return users.stream()
                .mapToLong(User::getAge)
                .average()
                .getAsDouble();
    }

}
