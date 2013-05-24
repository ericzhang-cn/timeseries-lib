package org.codinglabs.timeseries_lib.arima;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.codinglabs.timeseries_lib.arima.Statistics;

import junit.framework.Assert;
import junit.framework.TestCase;

public class StatisticsTest extends TestCase {
    private ArrayList<Double> series;
    private DecimalFormat df;
    private Statistics st;

    protected void setUp() {
        series = new ArrayList<Double>();
        series.add(1D);
        series.add(2D);
        series.add(3D);
        series.add(4D);
        series.add(5D);
        series.add(6D);
        series.add(7D);
        series.add(8D);
        series.add(9D);
        series.add(10D);

        df = new DecimalFormat("0.000");
        st = Statistics.getInstance();
    }

    public void testAutocorrelation() {
        Assert.assertEquals(df.format(1.000),
                df.format(st.autocorrelation(series, 0)));
        Assert.assertEquals(df.format(0.700),
                df.format(st.autocorrelation(series, 1)));
        Assert.assertEquals(df.format(0.412),
                df.format(st.autocorrelation(series, 2)));
    }

    public void testAcf() {
        ArrayList<Double> acf = st.acf(series, 9);

        Assert.assertEquals(df.format(1.000), df.format(acf.get(0)));
        Assert.assertEquals(df.format(0.700), df.format(acf.get(1)));
        Assert.assertEquals(df.format(0.412), df.format(acf.get(2)));
    }

    public void testPacf() {
        ArrayList<Double> pacf = st.pacf(series, 9);

        Assert.assertEquals(df.format(0.700), df.format(pacf.get(1)));
        Assert.assertEquals(df.format(-0.153), df.format(pacf.get(2)));
        Assert.assertEquals(df.format(-0.155), df.format(pacf.get(3)));
    }
}
