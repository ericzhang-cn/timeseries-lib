package org.codinglabs.timeseries_lib.testers;

import org.codinglabs.timeseries_lib.entities.TimeSeries;

/**
 * Interface for testers
 * 
 * One tester can be used to determine if time series has some natures.
 * 
 * @author ericzhang
 */
public interface ITester {
    
    /**
     * Determine if time series has some natures
     * 
     * @param ts
     *            Time series
     * @return Is the time series has some natures
     */
    boolean test(TimeSeries ts);
    
}
