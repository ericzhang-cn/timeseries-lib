package org.codinglabs.timeseries_lib.arima;

import java.util.ArrayList;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TransformationTest extends TestCase {
    private ArrayList<Double> series;
    private Transformation tf;

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

        tf = Transformation.getInstance();
    }

    public void testDifference() {
        ArrayList<Double> df0 = tf.diff(series, 0);
        ArrayList<Double> df1 = tf.diff(series, 1);
        ArrayList<Double> df2 = tf.diff(series, 2);

        Assert.assertEquals(1D, df0.get(0));
        Assert.assertEquals(1D, df1.get(0));
        Assert.assertEquals(0D, df2.get(0));

        Assert.assertEquals(10D, df0.get(9));
        Assert.assertEquals(1D, df1.get(8));
        Assert.assertEquals(0D, df2.get(7));
    }

    public void testLog() {
        ArrayList<Double> log = tf.log(series);
        
        Assert.assertEquals(Math.log(1D), log.get(0));
        Assert.assertEquals(Math.log(2D), log.get(1));
        Assert.assertEquals(Math.log(3D), log.get(2));
    }
}
