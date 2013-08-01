package org.codinglabs.timeseries_lib.testers;

import lombok.SneakyThrows;

import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.codinglabs.timeseries_lib.entities.TimeSeries;
import org.codinglabs.timeseries_lib.exceptions.TSLOutOfRangeException;

/**
 * Tester for Ljung-Box test
 * 
 * @author ericzhang
 */
public class LjungBoxTester {

	/**
	 * Ljung-Box test
	 * 
	 * @param ts
	 *            Time series
	 * @param m
	 *            Lag
	 * @param fDiff
	 *            Substracted from lag for freedom
	 * @param alpha
	 *            Confidence level
	 * @return Test result
	 */
	@SneakyThrows
	public LjungBoxTestResult test(TimeSeries ts, int m, int fDiff, double alpha) {
		int freedom = m - fDiff;
		if (m <= 1 || m >= ts.getNumber() || freedom < 1 || alpha < 0D
				|| alpha > 1D) {
			throw new TSLOutOfRangeException();
		}

		int n = ts.getNumber();
		double[] rho = ts.acf(m);
		double total = 0D;
		for (int i = 1; i <= m; i++) {
			total += (rho[i] * rho[i]) / (n - i);
		}
		double Q = n * (n + 2) * total;

		ChiSquaredDistribution chiSquared = new ChiSquaredDistribution(freedom);
		double pr = chiSquared.cumulativeProbability(Q);

		LjungBoxTestResult result = new LjungBoxTestResult((1 - pr) < alpha,
				1 - pr);
		return result;
	}

}
