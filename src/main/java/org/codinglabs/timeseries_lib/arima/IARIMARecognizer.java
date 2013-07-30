package org.codinglabs.timeseries_lib.arima;

import org.codinglabs.timeseries_lib.entities.TimeSeries;

/**
 * Interface for ARIMA model recognizer
 * 
 * @author ericzhang
 */
public interface IARIMARecognizer {
    ARIMAParameter recognize(TimeSeries ts);
}
