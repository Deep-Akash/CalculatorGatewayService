package com.calculator.calculatorgatewayservice.exceptions;

import com.calculator.calculatorgatewayservice.enums.APIResponseCodeENUM;

/**
 * Created by akashdeepnew on 20/12/18.
 */
public class WrongFormatException extends APIBaseException {
    public WrongFormatException() {
        super(APIResponseCodeENUM.WRONG_OPERATION);
    }
}
