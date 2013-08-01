package org.codinglabs.timeseries_lib.tests;

import junit.framework.Assert;

import org.codinglabs.timeseries_lib.entities.TimeSeries;
import org.codinglabs.timeseries_lib.testers.LjungBoxTestResult;
import org.codinglabs.timeseries_lib.testers.LjungBoxTester;
import org.junit.Test;

public class TestersTest {

	@Test
	public void test() {
		TimeSeries ts1 = new TimeSeries(10);
		for (int i = 0; i < 10; i++) {
			ts1.setTimePoint(i, i + 1);
		}

		LjungBoxTester tester = new LjungBoxTester();

		LjungBoxTestResult result = tester.test(ts1, 5, 2, 0.05);
		Assert.assertEquals(true, result.isRejected());
		Assert.assertEquals(0.01, result.getPValue(), 0.01);
	}

}
