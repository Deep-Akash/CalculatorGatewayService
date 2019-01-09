package com.calculator.calculatorgatewayservice.controller;

import com.calculator.calculatorgatewayservice.enums.APIResponseCodeENUM;
import com.calculator.calculatorgatewayservice.enums.CalculatorOperationsENUM;
import com.calculator.calculatorgatewayservice.exceptions.APIBaseException;
import com.calculator.calculatorgatewayservice.kafka.NotificationProducer;
import com.calculator.calculatorgatewayservice.model.request.CalculationRequest;
import com.calculator.calculatorgatewayservice.model.response.APIResponse;
import com.calculator.calculatorgatewayservice.model.response.CalculationResultResponse;
import com.calculator.calculatorgatewayservice.service.*;
import com.calculator.calculatorgatewayservice.user.service.UserService;
import com.calculator.calculatorgatewayservice.user.service.model.UserCreditRequest;
import io.lettuce.core.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * Created by akashdeepnew on 20/12/18.
 */
@RestController
@RequestMapping(value = "/calculator")
public class CalculatorGatewayServiceController {

    @Autowired
    private ValidationService validateService;

    @Autowired
    private CalculatorGatewayService calculatorGatewayService;

    @Autowired
    private UserService userService;

    @PostMapping("/calculate")
    @ResponseBody
    public APIResponse calculate(@RequestBody CalculationRequest calculationRequest) throws Exception {
        validateService.validateServiceRequest(calculationRequest);
        return APIResponse.buildSuccess(calculatorGatewayService.calculate(calculationRequest));
    }

    @GetMapping("/user/balance")
    @ResponseBody
    public APIResponse checkBalance(@RequestParam("email") String email) throws Exception {
        return APIResponse.buildSuccess(userService.getUser(email).getCreditBalance());
    }


    @GetMapping("/user")
    @ResponseBody
    public APIResponse fetchUser(@RequestParam("email") String email) throws Exception {
        return APIResponse.buildSuccess(userService.getUser(email));
    }


    @PostMapping("/topup")
    @ResponseBody
    public APIResponse toupUser(@RequestBody UserCreditRequest userCreditRequest) throws Exception {
        userService.topUpUser(userCreditRequest);
        return APIResponse.buildSuccess("SUCCESS");
    }




    @ExceptionHandler
    @ResponseBody
    public APIResponse handleException(Exception ex) {
        if (ex instanceof APIBaseException){
            if (null==((APIBaseException) ex).getApiResponseCodeENUM()){
                return APIResponse.buildFailure(((APIBaseException) ex).code,((APIBaseException) ex).message);
            }
            return APIResponse.buildFailure(((APIBaseException) ex).getApiResponseCodeENUM());
        }
        return APIResponse.buildFailure(APIResponseCodeENUM.GENERAL_FAILURE);
    }
}
