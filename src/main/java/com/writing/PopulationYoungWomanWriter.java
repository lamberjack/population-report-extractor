package com.writing;

import java.io.IOException;
import java.io.PrintStream;

public class PopulationYoungWomanWriter implements Writer<String, PrintStream> {

    @Override
    public void writeData(String regionWithYoungWoman, PrintStream output) throws IOException {
        output.println(regionWithYoungWoman);
    }


}
