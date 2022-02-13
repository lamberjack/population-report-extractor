package com.writing;

import com.model.PopulationReportData;

import javax.swing.text.html.Option;
import java.util.LinkedList;
import java.util.Optional;

public class PopulationReportDataWriterTestValues {

    static final String WRITE_FILE_TEST_FILENAME = "src/test/resources/write-report";

    static final PopulationReportData[] WRITE_FILE_TEST_POPULATION_REPORTS = {
            new PopulationReportData("Toscana",
                    Optional.empty(),36.4 ),
            new PopulationReportData("Toscana",
                    Optional.of("FI"),25.1 ),
            new PopulationReportData("Toscana",
                    Optional.of("LI"),11.3 )
    };



}
