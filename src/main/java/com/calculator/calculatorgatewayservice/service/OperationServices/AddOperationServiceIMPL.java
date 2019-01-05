package com.calculator.calculatorgatewayservice.service.OperationServices;

import com.calculator.calculatorgatewayservice.model.request.OperationRequest;
import com.calculator.calculatorgatewayservice.model.response.APIResponse;
import com.calculator.calculatorgatewayservice.model.response.OperationResultResponse;
import com.calculator.calculatorgatewayservice.service.PropertyProviderService;
import com.calculator.calculatorgatewayservice.utils.CalculatorConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by akashdeepnew on 26/12/18.
 */
@Service
public class AddOperationServiceIMPL implements OperationServiceInterface {

    @Autowired
    private CalculatorConnectionService calculatorConnectionService;

    @Autowired
    private PropertyProviderService propertyProviderService;


    @Override
    public OperationResultResponse calculate(Double firstNumber, Double secondNumber) {
        OperationRequest request = new OperationRequest(firstNumber,secondNumber);
        APIResponse response = calculatorConnectionService.POST(propertyProviderService.getAddServiceCalculationURL(),request);
        return OperationResultResponse.buildFromData(response.getData());
    }

    @Override
    public Double cost() {
        APIResponse response = calculatorConnectionService.GET(propertyProviderService.getAddServiceCostURL());
        return (Double) response.getData();
    }
}
