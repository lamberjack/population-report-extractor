package com.calculator;

import com.model.PopulationReportData;
import com.model.User;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PopulationReportDataCalculator implements ReportCalculator<List<User>, List<PopulationReportData>> {


    @Override
    public List<PopulationReportData> calculateReport(List<User> users) {
        final List<PopulationReportData> populationReportsData = new LinkedList<>();
        populateRegionReportData(populationReportsData, users);
        populateCityReportData(populationReportsData, users);

        return populationReportsData.stream()
                .sorted(Comparator.comparing(PopulationReportData::getRegion))
                .collect(Collectors.toList());
    }

    private void populateRegionReportData(List<PopulationReportData> populationReportsData, List<User> users) {
        users.stream()
                .filter(user -> user.getMunicipalityOpt().isPresent())
                .collect(Collectors.groupingBy(user -> user.getMunicipalityOpt().get().getRegion()))
                .forEach((region, relatedUsers) -> {
                    PopulationReportData regionReport = new PopulationReportData();
                    regionReport.setRegion(region);
                    regionReport.setCityOpt(Optional.empty());
                    regionReport.setUserPercentage(((double) relatedUsers.size() / users.size()) * 100);
                    populationReportsData.add(regionReport);
                });
    }

    private void populateCityReportData(List<PopulationReportData> populationReportsData, List<User> users) {
        users.stream()
                .filter(user -> user.getMunicipalityOpt().isPresent())
                .collect(Collectors.groupingBy(user -> user.getMunicipalityOpt().get().getCity()))
                .forEach((city, relatedUsers) -> {
                    PopulationReportData regionReport = new PopulationReportData();
                    regionReport.setRegion(relatedUsers.get(0).getMunicipalityOpt().get().getRegion());
                    regionReport.setCityOpt(Optional.of(city));
                    regionReport.setUserPercentage(((double) relatedUsers.size() / users.size()) * 100);
                    populationReportsData.add(regionReport);
                });


    }


}
