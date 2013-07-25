package org.codinglabs.timeseries_lib.exceptions;

public class TSLOutOfRangeException extends Exception {

    private static final long serialVersionUID = 1L;

    public TSLOutOfRangeException() {
        super("Index or length out of range");
    }

}
