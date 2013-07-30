package org.codinglabs.timeseries_lib.arima;

import org.codinglabs.timeseries_lib.entities.TimeSeries;

/**
 * Interface for ARIMA model recognizer
 * 
 * @author ericzhang
 */
public interface IARIMARecognizer {

    /**
     * Recognize ARIMA model
     * 
     * @param ts
     *            Time series
     * @return ARIMA model parameters
     */
    ARIMAParameter recognize(TimeSeries ts);

}
