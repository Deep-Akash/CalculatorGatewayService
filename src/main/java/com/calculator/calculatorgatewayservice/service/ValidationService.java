package com.calculator.calculatorgatewayservice.service;

import com.calculator.calculatorgatewayservice.exceptions.FaultyRequestException;
import com.calculator.calculatorgatewayservice.exceptions.NumberMissingException;
import com.calculator.calculatorgatewayservice.model.request.CalculationRequest;
import com.calculator.calculatorgatewayservice.model.request.CalculationRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by akashdeepnew on 21/12/18.
 */
@Service
public class ValidationService {
    private static final Logger logger = LogManager.getLogger(ValidationService.class);

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
    }
}
