package com.parsing;

import com.model.Municipality;
import java.util.HashMap;

/**
 * Parser for municipality data.
 */
public class MunicipalityParser implements Parser<Municipality, String>{


    @Override
    public Municipality parseLine(String line){
        Municipality municipality = new Municipality();
        String[] municipalityStrValues = line.split(",");
        municipality.setCode(municipalityStrValues[0]);
        municipality.setName(municipalityStrValues[1]);
        municipality.setCity(municipalityStrValues[2]);
        municipality.setRegion(municipalityStrValues[3]);
        return municipality;
    }

}
