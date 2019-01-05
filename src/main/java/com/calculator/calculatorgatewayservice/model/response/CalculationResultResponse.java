package com.calculator.calculatorgatewayservice.model.response;

/**
 * Created by akashdeepnew on 20/12/18.
 */
public class CalculationResultResponse {
    private Double result;

    public CalculationResultResponse() {
    }

    public CalculationResultResponse(Double result) {
        this.result = result;
    }

    public Double getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "CalculationResultResponse{" +
                "result=" + result +
                '}';
    }
}
