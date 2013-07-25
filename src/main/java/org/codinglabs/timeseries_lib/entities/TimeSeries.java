package org.codinglabs.timeseries_lib.entities;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

import org.codinglabs.timeseries_lib.exceptions.TSLOutOfRangeException;

@Log4j
public class TimeSeries {

    protected Map<String, Double> memo;

    protected double[] points;

    @Getter
    protected int number;

    public TimeSeries() {
        this(128);
    }

    public TimeSeries(int _number) {
        if (_number <= 0) {
            this.number = 128;

            log.warn("Number of points must greater than zero，use the default value 128");
        } else {
            this.number = _number;
        }
        this.points = new double[this.number];

        this.memo = new HashMap<String, Double>();
    }

    @SneakyThrows
    public void setTimePoint(int index, double value) {
        if (index < 0 || index >= this.number) {
            throw new TSLOutOfRangeException();
        }

        this.points[index] = value;

        if (this.memo.size() > 0) {
            this.memo.clear();
        }
    }

    public double getAverage() {
        if (!this.memo.containsKey("avg")) {
            double total = 0D;

            for (double tp : this.points) {
                total += tp;
            }

            this.memo.put("avg", total / this.number);
        }

        return this.memo.get("avg");
    }

    public double getVariance() {
        if (!this.memo.containsKey("var")) {
            double avg = this.getAverage();
            double total = 0D;

            for (double tp : this.points) {
                total += (tp - avg) * (tp - avg);
            }

            this.memo.put("var", total / this.number);
        }

        return this.memo.get("var");
    }

    @SneakyThrows
    public double getAutocovariance(int k) {
        if (!this.memo.containsKey("acov" + k)) {
            if (k < 0 || k >= this.number) {
                throw new TSLOutOfRangeException();
            }

            if (k == 0) {
                return this.getVariance();
            }

            double total = 0D;
            double avg = this.getAverage();
            for (int i = k; i < this.number; i++) {
                total += (this.points[i - k] - avg) * (this.points[i] - avg);
            }

            this.memo.put("acov" + k, total / (this.number - k));
        }

        return this.memo.get("acov" + k);
    }

    @SneakyThrows
    public double getAutocorrelation(int k) {
        if (!this.memo.containsKey("acor" + k)) {
            this.memo
                    .put("acor" + k,
                            this.getAutocovariance(k)
                                    / (this.getVariance() * this.number / (this.number - k)));
        }

        return this.memo.get("acor" + k);
    }

}
