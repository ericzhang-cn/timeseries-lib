package org.codinglabs.timeseries_lib.lib;

import java.text.DecimalFormat;
import java.util.ArrayList;

import junit.framework.Assert;
import junit.framework.TestCase;

public class StatisticsTest extends TestCase {
    public void testAutocorrelation() {
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

	DecimalFormat df = new DecimalFormat("0.000");
	Statistics st = Statistics.getInstance();

	Assert.assertEquals(df.format(1.000),
		df.format(st.autocorrelation(series, 0)));
	Assert.assertEquals(df.format(0.700),
		df.format(st.autocorrelation(series, 1)));
	Assert.assertEquals(df.format(0.412),
		df.format(st.autocorrelation(series, 2)));
    }
}
