package com.calculator.calculatorgatewayservice.model.request;


/**
 * Created by akashdeepnew on 27/12/18.
 */
public class OperationRequest {
    private Double firstNumber;
    private Double secondNumber;

    public OperationRequest() {
    }

    public OperationRequest(Double firstNumber, Double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public Double getFirstNumber() {
        return firstNumber;
    }

    public Double getSecondNumber() {
        return secondNumber;
    }

    @Override
    public String toString() {
        return "OperationRequest{" +
                "firstNumber=" + firstNumber +
                ", secondNumber=" + secondNumber +
                '}';
    }
}
