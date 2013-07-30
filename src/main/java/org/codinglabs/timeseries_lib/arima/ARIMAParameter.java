package org.codinglabs.timeseries_lib.arima;

import lombok.Data;

/**
 * ARIMA parameters
 * 
 * @author ericzhang
 */
@Data
public class ARIMAParameter {

    /**
     * Difference
     */
    protected int diff;

    /**
     * Autoregressive
     */
    protected int ar;

    /**
     * Moving average
     */
    protected int ma;

}
