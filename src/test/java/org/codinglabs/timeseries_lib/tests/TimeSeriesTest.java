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
        Assert.assertEquals(5.50D, ts.getAverage(), 0.01);
    }

    @Test
    public void testGetVariance() {
        Assert.assertEquals(8.25D, ts.getVariance(), 0.01);
    }

    @Test
    public void testGetAutocovariance() {
        Assert.assertEquals(8.25D, ts.getAutocovariance(0), 0.01);
        Assert.assertEquals(5.78D, ts.getAutocovariance(1), 0.01);
        Assert.assertEquals(3.40D, ts.getAutocovariance(2), 0.01);
    }

    @Test
    public void testGetAutocorrelation() {
        Assert.assertEquals(1.00D, ts.getAutocorrelation(0), 0.01);
        Assert.assertEquals(0.70D, ts.getAutocorrelation(1), 0.01);
        Assert.assertEquals(0.42D, ts.getAutocorrelation(2), 0.01);
    }

    @Test
    public void testGetACF() {
        double[] acf = ts.acf(2);

        Assert.assertEquals(1.00D, acf[0], 0.01);
        Assert.assertEquals(0.70D, acf[1], 0.01);
        Assert.assertEquals(0.42D, acf[2], 0.01);
    }

    @Test
    public void testGetPACF() {
        double[] pacf = ts.pacf(3);

        Assert.assertEquals(0.70D, pacf[1], 0.01);
        Assert.assertEquals(-0.15D, pacf[2], 0.01);
        Assert.assertEquals(-0.15D, pacf[3], 0.01);
    }

}
