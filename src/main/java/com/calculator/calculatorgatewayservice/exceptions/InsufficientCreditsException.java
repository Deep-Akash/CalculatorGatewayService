package com.calculator.calculatorgatewayservice.exceptions;

import com.calculator.calculatorgatewayservice.enums.APIResponseCodeENUM;

public class InsufficientCreditsException extends APIBaseException {
    public InsufficientCreditsException() {
        super(APIResponseCodeENUM.INSUFFICIENT_CREDITS);
    }
}
