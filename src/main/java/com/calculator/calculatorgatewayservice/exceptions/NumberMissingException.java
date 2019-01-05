package com.calculator.calculatorgatewayservice.exceptions;

import com.calculator.calculatorgatewayservice.enums.APIResponseCodeENUM;

/**
 * Created by akashdeepnew on 20/12/18.
 */
public class NumberMissingException extends APIBaseException {
    public NumberMissingException() {
        super(APIResponseCodeENUM.NUMBER_MISSING);
    }
}
