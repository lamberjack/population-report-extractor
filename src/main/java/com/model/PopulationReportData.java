package com.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

/**
 * Represent a report data that will be written on the output file
 */
public class PopulationReportData {

    private String region;

    private Optional<String> cityOpt;

    private Double userPercentage;

    public PopulationReportData(){ };

    public PopulationReportData(String region, Optional<String> cityOpt, Double userPercentage) {
        this.region = region;
        this.cityOpt = cityOpt;
        this.userPercentage = this.roundPercentages(userPercentage);
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Optional<String> getCityOpt() {
        return cityOpt;
    }

    public void setCityOpt(Optional<String> cityOpt) {
        this.cityOpt = cityOpt;
    }

    public Double getUserPercentage() {
        return userPercentage;
    }

    public void setUserPercentage(Double userPercentage) {

        this.userPercentage = this.roundPercentages(userPercentage);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.region);
        sb.append(',');
        sb.append(this.cityOpt.orElse(""));
        sb.append(',');
        sb.append(this.userPercentage+"%");
        return sb.toString();
    }

    private Double roundPercentages(Double percentage) {
        BigDecimal bigDecimal = new BigDecimal(percentage);
        bigDecimal = bigDecimal.setScale(1, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

}
