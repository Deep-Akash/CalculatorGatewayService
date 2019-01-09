package com.calculator.calculatorgatewayservice.user.service.model;

public class UserCreditRequest {
    private String userEmailId;
    private Double topUp;

    public UserCreditRequest(String userEmailId, Double topUp) {
        this.userEmailId = userEmailId;
        this.topUp = topUp;
    }

    public UserCreditRequest() {
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public Double getTopUp() {
        return topUp;
    }

    @Override
    public String toString() {
        return "UserCreditRequest{" +
                "userEmailId='" + userEmailId + '\'' +
                ", topUp=" + topUp +
                '}';
    }
}
