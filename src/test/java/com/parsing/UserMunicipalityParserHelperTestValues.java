package com.parsing;

public class UserMunicipalityParserHelperTestValues {



    static final String[] MUNICIPALITY_LINES = {
            "G825,Pontassieve,FI,Toscana",
            "I158,San Severo,FG,Puglia",
            "A465,Asiago,VI,Veneto",
            "H384,Roccabianca,PR,Emilia-Romagna",
            "B645,Capaci,PA,Sicilia",
            "L331,Trapani,TP,Sicilia"
    };

    static final String[] USER_LINES = {
            "USER0001,M,1972-05-18,B645",
            "USER0002,M,1980-06-20,A465",
            "USER0003,F,2000-08-01,H384",
            "USER0004,M,1998-11-03,B645",
            "USER0005,F,1993-03-21,B645"
    };

    static final String USER_MUNICIPALITY_NAME = "Capaci";

    static final String USER_MUNICIPALITY_CITY = "PA";

    static final String USER_MUNICIPALITY_REGION = "Sicilia";
}
