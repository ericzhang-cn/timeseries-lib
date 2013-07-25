package org.codinglabs.timeseries_lib.exceptions;

public class TSLOutOfRangeException extends Exception {

    public TSLOutOfRangeException() {
        super("Index or length out of range");
    }

}
