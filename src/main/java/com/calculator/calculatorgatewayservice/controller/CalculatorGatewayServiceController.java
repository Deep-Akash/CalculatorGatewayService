package com.calculator.calculatorgatewayservice.controller;

import com.calculator.calculatorgatewayservice.enums.APIResponseCodeENUM;
import com.calculator.calculatorgatewayservice.enums.CalculatorOperationsENUM;
import com.calculator.calculatorgatewayservice.exceptions.APIBaseException;
import com.calculator.calculatorgatewayservice.model.request.CalculationRequest;
import com.calculator.calculatorgatewayservice.model.response.APIResponse;
import com.calculator.calculatorgatewayservice.model.response.CalculationResultResponse;
import com.calculator.calculatorgatewayservice.service.*;
import io.lettuce.core.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * Created by akashdeepnew on 20/12/18.
 */
@RestController
@RefreshScope
@RequestMapping(value = "/calculator")
public class CalculatorGatewayServiceController {

    @Autowired
    private ValidationService validateService;

    @Autowired
    private CalculatorGatewayService calculatorGatewayService;


    @PostMapping("/calculate")
    @ResponseBody
    public APIResponse calculate(@RequestBody CalculationRequest calculationRequest) throws Exception {
        validateService.validateServiceRequest(calculationRequest);
        return APIResponse.buildSuccess(calculatorGatewayService.calculate(calculationRequest));
    }

    @PostMapping("/balance")
    @ResponseBody
    public APIResponse checkBalance() throws Exception {
        calculatorGatewayService.getCost(CalculatorOperationsENUM.ADD);
        return APIResponse.buildSuccess("DONE");
    }



    @ExceptionHandler
    @ResponseBody
    public APIResponse handleException(Exception ex) {
        if (ex instanceof APIBaseException){
            return APIResponse.buildFailure(((APIBaseException) ex).getApiResponseCodeENUM());
        }
        return APIResponse.buildFailure(APIResponseCodeENUM.GENERAL_FAILURE);
    }
}
