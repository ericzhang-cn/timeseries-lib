package org.codinglabs.timeseries_lib.lib;

import java.util.ArrayList;

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

	public ArrayList<Double> difference(ArrayList<Double> series, int k) {
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

		return difference(df, k - 1);
	}
}
