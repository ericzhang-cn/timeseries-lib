package org.codinglabs.timeseries_lib.arima;

import java.util.ArrayList;

/**
 * Statistical functions
 * 
 * @author ericzhang
 */
public class Statistics {
    private static Statistics instance;

    private Statistics() {
    }

    public static synchronized Statistics getInstance() {
	if (instance == null) {
	    instance = new Statistics();
	}

	return instance;
    }

    /**
     * Calculate autocorrelation
     * 
     * @param series
     *            Time series
     * @param k
     *            Order
     * @return Autocorrelation coefficient
     */
    public double autocorrelation(ArrayList<Double> series, int k) {
	if (k < 0 || series.size() <= k) {
	    return 0D;
	}

	double sum = 0D;
	for (Double s : series) {
	    sum += s;
	}
	double avg = sum / series.size();

	double a = 0D, b = 0D;
	for (int i = 0; i < series.size(); i++) {
	    b += (series.get(i) - avg) * (series.get(i) - avg);
	    if (i >= k) {
		a += (series.get(i) - avg) * (series.get(i - k) - avg);
	    }
	}

	return a / b;
    }

    /**
     * Autocorrelation function
     * 
     * @param series
     *            Time series
     * @param lag
     *            Lag
     * @return Autocorrelation function values
     */
    public ArrayList<Double> acf(ArrayList<Double> series, int lag) {
	if (series.size() == 0 || lag < 0) {
	    return null;
	}

	ArrayList<Double> ac = new ArrayList<Double>();
	for (int i = 0; i <= lag; i++) {
	    ac.add(autocorrelation(series, i));
	}

	return ac;
    }

    /**
     * Partial autocorrelation function
     * 
     * @param series
     *            Time series
     * @param lag
     *            Lag
     * @return Partial autocorrelation function values
     */
    public ArrayList<Double> pacf(ArrayList<Double> series, int lag) {
	if (series.size() == 0 || lag <= 0) {
	    return null;
	}

	ArrayList<Double> ac = acf(series, lag);
	Double[][] c = new Double[lag + 1][lag + 1];

	ArrayList<Double> pac = new ArrayList<Double>();
	pac.add(-1D);
	pac.add(ac.get(1));
	c[1][1] = ac.get(1);
	for (int i = 2; i <= lag; i++) {
	    double a = 0D, b = 0D;
	    for (int j = 1; j < i; j++) {
		a += c[i - 1][j] * ac.get(i - j);
		b += c[i - 1][j] * ac.get(j);
	    }
	    c[i][i] = (ac.get(i) - a) / (1 - b);
	    pac.add(c[i][i]);

	    for (int j = 1; j < i; j++) {
		c[i][j] = c[i - 1][j] - c[i][i] * c[i - 1][i - j];
	    }
	}

	return pac;
    }
}
