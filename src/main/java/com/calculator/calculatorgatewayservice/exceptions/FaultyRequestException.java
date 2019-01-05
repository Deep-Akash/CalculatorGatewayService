package com.calculator.calculatorgatewayservice.exceptions;

import com.calculator.calculatorgatewayservice.enums.APIResponseCodeENUM;

/**
 * Created by akashdeepnew on 21/12/18.
 */
public class FaultyRequestException extends APIBaseException {
    public FaultyRequestException() {
        super(APIResponseCodeENUM.FAULTY_OPERATION_REQUEST);
    }
}
