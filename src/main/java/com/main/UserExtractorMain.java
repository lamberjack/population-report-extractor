package com.main;

import com.calculator.PopulationYoungWomanCalculator;
import com.model.PopulationReportData;
import com.model.User;
import com.parsing.UserMunicipalityParserHelper;
import com.reading.FileReaderHelper;
import com.calculator.PopulationReportDataCalculator;
import com.writing.PopulationReportDataWriter;
import com.writing.PopulationYoungWomanWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class UserExtractorMain {

    public static void main(String[] args) throws IOException {

        /*
         * Parses of the input data passed as arguments (municipalities and input users)
         */
        UserMunicipalityParserHelper userMunicipalityParserHelper = new UserMunicipalityParserHelper();
        userMunicipalityParserHelper.parseMunicipalities(readFileInputData(args[0]));
        userMunicipalityParserHelper.parseUsers(readFileInputData(args[1]));

        /*
         * Generates report with population distribution data
         */
        generatePopulationReport(userMunicipalityParserHelper.getUsers());

        /*
         * Write on the stdout the region with the younger women
         */
        findYoungWomenRegion(userMunicipalityParserHelper.getUsers());


    }

    private static void findYoungWomenRegion(List<User> users) throws IOException {
        PopulationYoungWomanCalculator populationYoungWomanCalculator = new PopulationYoungWomanCalculator();
        String regionWithYoungerWomen = populationYoungWomanCalculator.calculateReport(users);
        PopulationYoungWomanWriter populationYoungWomanWriter = new PopulationYoungWomanWriter();
        populationYoungWomanWriter.writeData(regionWithYoungerWomen, System.out);
    }

    private static void generatePopulationReport(List<User> users) throws IOException {
        /*
         *  Generates the population report data
         */
        PopulationReportDataCalculator populationReportDataCalculator = new PopulationReportDataCalculator();
        List<PopulationReportData> reports = populationReportDataCalculator.calculateReport(users);

        /*
         * Write the report on an output .csv file
         */
        PopulationReportDataWriter populationReportDataWriter = new PopulationReportDataWriter();
        BufferedWriter writer = populationReportDataWriter.writeBufferFile("report.csv");
        populationReportDataWriter.writeData(reports, writer);
        if (writer != null) {
            writer.close();
        }
    }

    private static List<String> readFileInputData(String path) throws IOException {
        FileReaderHelper fileReaderHelper = new FileReaderHelper();
        BufferedReader reader = fileReaderHelper.readInputFile(path);
        List<String> fileReadLines = fileReaderHelper.readBuffer(reader);
        if (reader != null) {
            reader.close();
        }
        return fileReadLines;
    }
}
