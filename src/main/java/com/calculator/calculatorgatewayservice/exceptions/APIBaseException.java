package com.calculator.calculatorgatewayservice.exceptions;

import com.calculator.calculatorgatewayservice.enums.APIResponseCodeENUM;

/**
 * Created by akashdeepnew on 20/12/18.
 */
public class APIBaseException extends Exception{
    private APIResponseCodeENUM apiResponseCodeENUM;
    public String code;
    public String message;

    public APIBaseException(APIResponseCodeENUM apiResponseCodeENUM) {
        this.apiResponseCodeENUM = apiResponseCodeENUM;
    }

    public APIBaseException(String code, String message) {
        this.code=code;
        this.message=message;
    }

    public APIResponseCodeENUM getApiResponseCodeENUM() {
        return apiResponseCodeENUM;
    }
}
