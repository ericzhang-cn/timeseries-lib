package org.codinglabs.timeseries_lib.exceptions;

/**
 * Throw this exception when set an invalid value to parameter
 * 
 * @author ericzhang
 */
public class TSLInvalidParameterException extends Exception {

    private static final long serialVersionUID = 1L;

    public TSLInvalidParameterException() {
        super("Invalid parameter");
    }

}
