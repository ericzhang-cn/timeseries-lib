package org.codinglabs.timeseries_lib.testers;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Result of Ljung-Box test
 * 
 * @author ericzhang
 */
@Data
@AllArgsConstructor
public class LjungBoxTestResult {

	/**
	 * Whether to reject null hypothesis
	 * 
	 * Null hypothesis is the time series is independent
	 */
	private boolean isRejected;

	/**
	 * p value
	 */
	private double pValue;

}
