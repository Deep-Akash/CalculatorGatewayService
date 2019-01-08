package com.calculator.calculatorgatewayservice.model.response;

import java.io.Serializable;

/**
 * Created by akashdeepnew on 20/12/18.
 */
public class CalculationResultResponse implements Serializable {
    private static final long serialVersionUID = 7156526077993281623L;

    private Double result;

    public CalculationResultResponse() {
    }

    public CalculationResultResponse(Double result) {
        this.result = result;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "CalculationResultResponse{" +
                "result=" + result +
                '}';
    }
}
