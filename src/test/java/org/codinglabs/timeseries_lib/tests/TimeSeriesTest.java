package org.codinglabs.timeseries_lib.tests;

import junit.framework.Assert;

import org.codinglabs.timeseries_lib.entities.TimeSeries;
import org.junit.BeforeClass;
import org.junit.Test;

public class TimeSeriesTest {

    private static TimeSeries ts;

    @BeforeClass
    public static void beforeClass() {
        ts = new TimeSeries(10);
        for (int i = 0; i < 10; i++) {
            ts.setTimePoint(i, i + 1);
        }
    }

    @Test
    public void testGetAverage() {
        Assert.assertEquals(5.50, ts.getAverage(), 0.01);
    }

    @Test
    public void testGetVariance() {
        Assert.assertEquals(8.25, ts.getVariance(), 0.01);
    }

    @Test
    public void testGetAutocovariance() {
        Assert.assertEquals(8.25, ts.getAutocovariance(0), 0.01);
        Assert.assertEquals(5.78, ts.getAutocovariance(1), 0.01);
        Assert.assertEquals(3.40, ts.getAutocovariance(2), 0.01);
    }

    @Test
    public void testGetAutocorrelation() {
        Assert.assertEquals(1.00, ts.getAutocorrelation(0), 0.01);
        Assert.assertEquals(0.70, ts.getAutocorrelation(1), 0.01);
        Assert.assertEquals(0.42, ts.getAutocorrelation(2), 0.01);
    }

    @Test
    public void testGetACF() {
        double[] acf = ts.acf(2);

        Assert.assertEquals(1.00, acf[0], 0.01);
        Assert.assertEquals(0.70, acf[1], 0.01);
        Assert.assertEquals(0.42, acf[2], 0.01);
    }

    @Test
    public void testGetPACF() {
        double[] pacf = ts.pacf(3);

        Assert.assertEquals(0.70, pacf[1], 0.01);
        Assert.assertEquals(-0.15, pacf[2], 0.01);
        Assert.assertEquals(-0.15, pacf[3], 0.01);
    }

}
