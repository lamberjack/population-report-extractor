package com.reading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Helper class for the reading of the files.
 */
public class FileReaderHelper {

  /**
   * Reading method invoked by main(); It reads a requests.log file that must be inside a logfiles folder.
   *
   * @return buffer reader of the external file
   */
  public BufferedReader readInputFile(String path) throws IOException {
    FileReader fr = new FileReader(path);
    return new BufferedReader(fr);
  }

  /**
   * @param reader BufferReader object that contains the file to read
   * @return list of strings where every element represents a line of the file
   */
  public List<String> readBuffer(BufferedReader reader) throws IOException {
    LinkedList<String> readStrings = new LinkedList<>();
    while (reader.ready()) {
      readStrings.add(reader.readLine());
    }
    return readStrings;
  }
}
