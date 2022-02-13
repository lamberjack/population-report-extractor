package com.reading;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileReaderTest {


  @Test
  void testReadMultipleLine() throws IOException {
    Path resourceDirectory = Paths.get("src","test", "resources",FileReaderTestValues.MUNICIPALITY_FILENAME);
    String absolutePath = resourceDirectory.toFile().getAbsolutePath();

    FileReaderHelper fileReaderHelper = new FileReaderHelper();
    BufferedReader readerTest = fileReaderHelper.readInputFile(absolutePath);

    List<String> readLines = fileReaderHelper.readBuffer(readerTest);
    assertEquals(6, readLines.size());
    Assertions.assertEquals(FileReaderTestValues.MUNICIPALITY_FILE_HEADER, readLines.get(0));
    Assertions.assertEquals(FileReaderTestValues.MUNICIPALITY_FILE_ROW_1, readLines.get(1));
    Assertions.assertEquals(FileReaderTestValues.MUNICIPALITY_FILE_ROW_2, readLines.get(2));
    Assertions.assertEquals(FileReaderTestValues.MUNICIPALITY_FILE_ROW_3, readLines.get(3));
    Assertions.assertEquals(FileReaderTestValues.MUNICIPALITY_FILE_ROW_4, readLines.get(4));
    Assertions.assertEquals(FileReaderTestValues.MUNICIPALITY_FILE_ROW_5, readLines.get(5));

    if (readerTest != null) {
      readerTest.close();
    }
  }

}
