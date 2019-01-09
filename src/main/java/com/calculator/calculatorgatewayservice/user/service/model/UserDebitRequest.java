package com.calculator.calculatorgatewayservice.user.service.model;

import com.calculator.calculatorgatewayservice.enums.CalculatorOperationsENUM;

public class UserDebitRequest {
    private String userEmailId;
    private CalculatorOperationsENUM operation;
    private Double cost;

    public UserDebitRequest(String userEmailId, CalculatorOperationsENUM operation, Double cost) {
        this.userEmailId = userEmailId;
        this.operation = operation;
        this.cost = cost;
    }

    public UserDebitRequest() {
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public CalculatorOperationsENUM getOperation() {
        return operation;
    }

    public Double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "UserDebitRequest{" +
                "userEmailId='" + userEmailId + '\'' +
                ", operation=" + operation +
                ", cost=" + cost +
                '}';
    }
}
