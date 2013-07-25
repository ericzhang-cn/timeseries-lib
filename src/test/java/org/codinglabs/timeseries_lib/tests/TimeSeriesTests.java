package org.codinglabs.timeseries_lib.tests;

import lombok.extern.log4j.Log4j;

import org.codinglabs.timeseries_lib.entities.TimeSeries;
import org.junit.Test;

@Log4j
public class TimeSeriesTests {

    @Test
    public void test() {
        TimeSeries ts = new TimeSeries(10);
        for (int i = 0; i < 10; i++) {
            ts.setTimePoint(i, i + 1);
        }
        
        log.info(ts.getAutocorrelation(1));
        log.info(ts.getAutocorrelation(2));
        log.info(ts.getAutocorrelation(3));
    }

}
