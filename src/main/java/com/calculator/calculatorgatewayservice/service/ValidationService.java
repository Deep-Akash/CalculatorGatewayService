package com.calculator.calculatorgatewayservice.service;

import com.calculator.calculatorgatewayservice.exceptions.FaultyRequestException;
import com.calculator.calculatorgatewayservice.exceptions.InsufficientCreditsException;
import com.calculator.calculatorgatewayservice.exceptions.NumberMissingException;
import com.calculator.calculatorgatewayservice.model.request.CalculationRequest;
import com.calculator.calculatorgatewayservice.model.request.CalculationRequest;
import com.calculator.calculatorgatewayservice.user.service.UserService;
import com.calculator.calculatorgatewayservice.user.service.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by akashdeepnew on 21/12/18.
 */
@Service
public class ValidationService {
    private static final Logger logger = LogManager.getLogger(ValidationService.class);

    @Autowired
    private UserService userService;

    @Autowired
    private CalculatorGatewayService calculatorGatewayService;

    public void validateServiceRequest(CalculationRequest request) throws Exception {
        if (null == request) {
            throw new FaultyRequestException();
        }
        if (null == request.getFirstNumber()) {
            throw new NumberMissingException();
        }
        if (null == request.getSecondNumber()) {
            throw new NumberMissingException();
        }

        User user = userService.getUser(request.getUserEmail());
        Double cost = calculatorGatewayService.getCost(request.getOperation());
        if (cost > user.getCreditBalance()) {
            throw new InsufficientCreditsException();
        }

    }
}
