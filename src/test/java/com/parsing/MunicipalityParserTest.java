package com.parsing;

import com.model.Municipality;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MunicipalityParserTest {

    @Test
    void testMunicipalityParseLine(){
        MunicipalityParser municipalityParser = new MunicipalityParser();
        Municipality municipality1 = municipalityParser.parseLine(MunicipalityParserTestValues.MUNICIPALITY_LINE);
        Assertions.assertEquals(MunicipalityParserTestValues.MUNICIPALITY_CODE, municipality1.getCode());
        Assertions.assertEquals(MunicipalityParserTestValues.MUNICIPALITY_NAME, municipality1.getName());
        Assertions.assertEquals(MunicipalityParserTestValues.MUNICIPALITY_REGION, municipality1.getRegion());
        Assertions.assertEquals(MunicipalityParserTestValues.MUNICIPALITY_CITY, municipality1.getCity());
    }

}
