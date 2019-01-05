package com.calculator.calculatorgatewayservice.model.request;

import com.calculator.calculatorgatewayservice.enums.CalculatorOperationsENUM;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by akashdeepnew on 20/12/18.
 */
public class CalculationRequest{
    private Double firstNumber;
    private Double secondNumber;
    private CalculatorOperationsENUM operation;

    public CalculationRequest() {
    }

    public CalculationRequest(Double firstNumber, Double secondNumber, CalculatorOperationsENUM operation) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operation = operation;
    }

    public CalculationRequest(Double firstNumber, Double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public Double getFirstNumber() {
        return firstNumber;
    }

    public Double getSecondNumber() {
        return secondNumber;
    }

    public CalculatorOperationsENUM getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        return "CalculationRequest{" +
                "firstNumber=" + firstNumber +
                ", secondNumber=" + secondNumber +
                ", operation='" + operation + '\'' +
                '}';
    }
}
