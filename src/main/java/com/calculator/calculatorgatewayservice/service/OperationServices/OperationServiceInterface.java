package com.calculator.calculatorgatewayservice.service.OperationServices;

import com.calculator.calculatorgatewayservice.model.response.CalculationResultResponse;
import com.calculator.calculatorgatewayservice.model.response.OperationResultResponse;

/**
 * Created by akashdeepnew on 26/12/18.
 */

public interface OperationServiceInterface {

    public OperationResultResponse calculate(Double firstNumber, Double secondNumber);

    public Double cost();
}
