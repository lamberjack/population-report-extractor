package com.calculator;

/**
 * Generic class to calculate a report
 * @param <E> Input data from which the report will be elaborated
 * @param <T> Output data returned after calculations
 */
public interface ReportCalculator <E,T>{

    /**
     * calculate a report based on an input data
     * @param e input parameter data from which a report is calculated
     * @return T output result of calculation
     */
    T calculateReport(E e);
}
