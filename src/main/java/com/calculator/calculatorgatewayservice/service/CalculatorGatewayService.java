package com.calculator.calculatorgatewayservice.service;

import com.calculator.calculatorgatewayservice.enums.CalculatorOperationsENUM;
import com.calculator.calculatorgatewayservice.exceptions.APIBaseException;
import com.calculator.calculatorgatewayservice.exceptions.WrongOperationException;
import com.calculator.calculatorgatewayservice.kafka.NotificationProducer;
import com.calculator.calculatorgatewayservice.model.request.CalculationRequest;
import com.calculator.calculatorgatewayservice.model.response.CalculationResultResponse;
import com.calculator.calculatorgatewayservice.model.response.OperationResultResponse;
import com.calculator.calculatorgatewayservice.service.OperationServices.OperationServiceInterface;
import com.calculator.calculatorgatewayservice.service.OperationServices.OperationServiceLocatorFactory;
import com.calculator.calculatorgatewayservice.user.service.UserService;
import com.calculator.calculatorgatewayservice.user.service.model.UserDebitRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by akashdeepnew on 24/12/18.
 */
@Service
public class CalculatorGatewayService {

    @Autowired
    private OperationServiceLocatorFactory operationServiceLocatorFactory;

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationProducer notificationProducer;




    @Cacheable(value = "calculation")
    public CalculationResultResponse cachedCalculate(CalculationRequest request) throws APIBaseException {
        return calculate(request.getFirstNumber(),request.getSecondNumber(),request.getOperation());
    }

    private CalculationResultResponse calculate(Double firstNumber, Double secondNumber, CalculatorOperationsENUM operationsENUM) throws WrongOperationException {
        OperationServiceInterface operationService = getOperationService(operationsENUM);
        if (null == operationService) {
            throw new WrongOperationException();
        }

        OperationResultResponse resultResponse = operationService.calculate(firstNumber, secondNumber);
        notificationProducer.send("testtopic","Calculation is Complete");
        return new CalculationResultResponse(resultResponse.getResult());
    }




    @Cacheable(value = "operationcost", key = "#operationsENUM.name()")
    public Double getCost(CalculatorOperationsENUM operationsENUM) throws WrongOperationException {
        OperationServiceInterface operationService = getOperationService(operationsENUM);
        if (null == operationService) {
            throw new WrongOperationException();
        }
        return operationService.cost();
    }

    private OperationServiceInterface getOperationService(CalculatorOperationsENUM calculatorOperationsENUM) {
        return operationServiceLocatorFactory.getOperationService(calculatorOperationsENUM);
    }

}
