package com.writing;

import java.io.IOException;

/**
 * Generic interface used for write a source of data in output
 *
 * @param <E> The source of data
 * @param <T> The output where the source of data will be write
 */
public interface Writer <E,T>{

    /**
     * Write an input data on output source
     * @param data data that will be written
     * @param output output source where the data will be written
     */
    void writeData(E data, T output) throws IOException;
}
