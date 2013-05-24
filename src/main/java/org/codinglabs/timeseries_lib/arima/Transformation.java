package org.codinglabs.timeseries_lib.arima;

import java.util.ArrayList;

/**
 * Transformations in common use
 * 
 * @author ericzhang
 */
public class Transformation {
    private static Transformation instance;

    private Transformation() {
    }

    public static synchronized Transformation getInstance() {
	if (instance == null) {
	    instance = new Transformation();
	}

	return instance;
    }

    /**
     * Difference
     * 
     * @param series
     *            Time series
     * @param k
     *            Order
     * @return Differential time series
     */
    public ArrayList<Double> diff(ArrayList<Double> series, int k) {
	if (k < 0 || series.size() == 0) {
	    return null;
	}

	if (k == 0) {
	    return series;
	}

	ArrayList<Double> df = new ArrayList<Double>();
	for (int i = 1; i < series.size(); i++) {
	    df.add(series.get(i) - series.get(i - 1));
	}

	return diff(df, k - 1);
    }

    /**
     * Logarithm transformation
     * 
     * @param series
     *            Time series
     * @return Log time series
     */
    public ArrayList<Double> log(ArrayList<Double> series) {
	ArrayList<Double> result = new ArrayList<Double>();
	for (Double s : series) {
	    result.add(Math.log(s));
	}

	return result;
    }
}
