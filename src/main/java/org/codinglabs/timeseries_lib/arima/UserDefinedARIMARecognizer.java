package org.codinglabs.timeseries_lib.arima;

import lombok.SneakyThrows;

import org.codinglabs.timeseries_lib.entities.TimeSeries;
import org.codinglabs.timeseries_lib.exceptions.TSLInvalidParameterException;

/**
 * Recognize ARIMA model by user defined parameters
 * 
 * @author ericzhang
 */
public class UserDefinedARIMARecognizer implements IARIMARecognizer {

    /**
     * ARIMA parameters
     */
    private ARIMAParameter parameters;

    /**
     * Constructor with ARIMAParameter object
     * 
     * @param _parameters
     *            Parameter object
     */
    public UserDefinedARIMARecognizer(ARIMAParameter _parameters) {
        this.parameters = _parameters;
    }

    /**
     * Constructor with values
     * 
     * @param diff
     *            Difference
     * @param ar
     *            Autoregressive
     * @param ma
     *            Moving average
     */
    @SneakyThrows
    public UserDefinedARIMARecognizer(int diff, int ar, int ma) {
        if (diff < 0 || ar < 0 || ma < 0) {
            throw new TSLInvalidParameterException();
        }

        this.parameters = new ARIMAParameter();

        this.parameters.setDiff(diff);
        this.parameters.setAr(ar);
        this.parameters.setMa(ma);
    }

    @Override
    public ARIMAParameter recognize(TimeSeries ts) {
        return parameters;
    }

}
