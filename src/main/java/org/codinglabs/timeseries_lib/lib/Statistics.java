package org.codinglabs.timeseries_lib.lib;

import java.util.ArrayList;

/**
 * Statistical functions
 * 
 * @author ericzhang
 */
public class Statistics {
	/***
	 * Calculate autocorrelation
	 * 
	 * @param series
	 *            Time series
	 * @param k
	 *            Order
	 * @return Autocorrelation coefficient
	 */
	public static double autocorrelation(ArrayList<Double> series, int k) {
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
}
