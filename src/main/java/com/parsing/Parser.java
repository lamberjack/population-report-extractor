package com.parsing;

import java.text.ParseException;

/**
 *
 * Generic interface used to convert a line in a more structured data
 *
 * @param <T> Output data read from the input line
 * @param <E> Input data, that have to read
 */
public interface Parser<T,E> {

    /**
     * Parses the input line information in a more structured output data
     * @param line line to parse
     * @return T parsed data
     */
    T parseLine(E line) throws ParseException;
}
