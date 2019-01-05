package com.calculator.calculatorgatewayservice.model.response;

import java.util.LinkedHashMap;

/**
 * Created by akashdeepnew on 27/12/18.
 */
public class OperationResultResponse {
    private Double result;
    private Double cost;

    public OperationResultResponse() {
    }

    public OperationResultResponse(Double result, Double cost) {
        this.result = result;
        this.cost = cost;
    }

    public Double getResult() {
        return result;
    }

    public Double getCost() {
        return cost;
    }

    public static OperationResultResponse buildFromData(Object data) {
        LinkedHashMap<String,Double> map = (LinkedHashMap) data;
        OperationResultResponse response = new OperationResultResponse(map.get("result"),map.get("cost"));
        return response;
    }

    @Override
    public String toString() {
        return "OperationResultResponse{" +
                "result=" + result +
                ", cost=" + cost +
                '}';
    }
}
