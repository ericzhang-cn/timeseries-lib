package org.codinglabs.timeseries_lib.detectors;

import org.codinglabs.timeseries_lib.entities.TimeSeries;

/**
 * Interface for detectors
 * 
 * One detector can be used to determine if time series has some natures.
 * 
 * @author ericzhang
 */
public interface IDetector {
    
    /**
     * Determine if time series has some natures
     * 
     * @param ts
     *            Time series
     * @return Is the time series has some natures
     */
    boolean detect(TimeSeries ts);
    
}
