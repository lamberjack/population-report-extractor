package com.writing;

import com.reading.FileReaderHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class PopulationReportDataWriterTest {

    @AfterEach
    void deleteWrittenfile() {
        File writtenFile = new File(PopulationReportDataWriterTestValues.WRITE_FILE_TEST_FILENAME);
        writtenFile.delete();
    }

    @Test
    void testWritePopulationReportData() throws IOException {
        PopulationReportDataWriter populationReportDataWriter = new PopulationReportDataWriter();
        BufferedWriter writer = populationReportDataWriter.writeBufferFile(PopulationReportDataWriterTestValues.WRITE_FILE_TEST_FILENAME);
        populationReportDataWriter.writeData(Arrays.asList(PopulationReportDataWriterTestValues.WRITE_FILE_TEST_POPULATION_REPORTS), writer);
        if (writer != null) {
            writer.close();
        }

        // reads from the previous written file
        FileReader fr = new FileReader(PopulationReportDataWriterTestValues.WRITE_FILE_TEST_FILENAME);
        BufferedReader reader = new BufferedReader(fr);
        FileReaderHelper fileReaderHelper = new FileReaderHelper();
        List<String> writtenData = fileReaderHelper.readBuffer(reader);
        if (reader != null) {
            reader.close();
        }
        Assertions.assertEquals(3, writtenData.size());

    }
}
