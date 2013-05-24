package org.codinglabs.timeseries_lib.lib;

import java.util.ArrayList;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TransformationTest extends TestCase {
    public void testDifference() {
	ArrayList<Double> series = new ArrayList<Double>();
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

	Transformation tf = Transformation.getInstance();
	ArrayList<Double> df0 = tf.difference(series, 0);
	ArrayList<Double> df1 = tf.difference(series, 1);
	ArrayList<Double> df2 = tf.difference(series, 2);

	Assert.assertEquals(1D, df0.get(0));
	Assert.assertEquals(1D, df1.get(0));
	Assert.assertEquals(0D, df2.get(0));

	Assert.assertEquals(10D, df0.get(9));
	Assert.assertEquals(1D, df1.get(8));
	Assert.assertEquals(0D, df2.get(7));
    }
}
