package com.calculator.calculatorgatewayservice.exceptions;

import com.calculator.calculatorgatewayservice.enums.APIResponseCodeENUM;

/**
 * Created by akashdeepnew on 26/12/18.
 */
public class WrongOperationException extends APIBaseException {
    public WrongOperationException() {
        super(APIResponseCodeENUM.WRONG_FORMAT);
    }
}