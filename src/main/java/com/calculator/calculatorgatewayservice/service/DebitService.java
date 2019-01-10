package com.calculator.calculatorgatewayservice.service;

import com.calculator.calculatorgatewayservice.enums.CalculatorOperationsENUM;
import com.calculator.calculatorgatewayservice.exceptions.APIBaseException;
import com.calculator.calculatorgatewayservice.user.service.UserService;
import com.calculator.calculatorgatewayservice.user.service.model.UserDebitRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DebitService {

    @Autowired
    private UserService userService;

    @Autowired
    private CalculatorGatewayService calculatorGatewayService;

    public void debitUserCredits(String userEmailId, CalculatorOperationsENUM operation) throws APIBaseException {
        Double cost = calculatorGatewayService.getCost(operation);
        userService.debitUser(new UserDebitRequest(userEmailId,operation,cost));
    }
}
