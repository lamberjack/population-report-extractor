package com.writing;

import com.model.PopulationReportData;

import java.io.*;
import java.util.List;

public class PopulationReportDataWriter implements Writer<List<PopulationReportData>, BufferedWriter> {

    @Override
    public void writeData(List<PopulationReportData> reports, BufferedWriter writer) throws IOException{
        for (PopulationReportData populationReportData : reports){
            writer.write(populationReportData.toString());
            writer.write("\n");
        }
    }

    public BufferedWriter writeBufferFile(String filename) throws IOException {
        FileWriter fw = new FileWriter(filename);
        BufferedWriter out = new BufferedWriter(fw);
        return out;

    }

}
