package org.codinglabs.timeseries_lib.entities;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

import org.codinglabs.timeseries_lib.exceptions.TSLOutOfRangeException;

@Log4j
public class TimeSeries {

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
    }

    @SneakyThrows
    public void setTimePoint(int index, double value) {
        if (index < 0 || index >= this.number) {
            throw new TSLOutOfRangeException();
        }

        this.points[index] = value;
    }

    public double getAverage() {
        double total = 0D;

        for (double tp : this.points) {
            total += tp;
        }

        return total / this.number;
    }

    public double getVariance() {
        double avg = this.getAverage();
        double total = 0D;

        for (double tp : this.points) {
            total += (tp - avg) * (tp - avg);
        }

        return total / this.number;
    }

    @SneakyThrows
    public double getAutocovariance(int k) {
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

        return total / (this.number - k);
    }

    @SneakyThrows
    public double getAutocorrelation(int k) {
        return this.getAutocovariance(k)
                / (this.getVariance() * this.number / (this.number - k));
    }

}
