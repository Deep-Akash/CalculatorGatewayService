package com.calculator.calculatorgatewayservice.user.service;

import com.calculator.calculatorgatewayservice.exceptions.APIBaseException;
import com.calculator.calculatorgatewayservice.model.response.APIResponse;
import com.calculator.calculatorgatewayservice.service.PropertyProviderService;
import com.calculator.calculatorgatewayservice.user.service.model.User;
import com.calculator.calculatorgatewayservice.user.service.model.UserCreditRequest;
import com.calculator.calculatorgatewayservice.user.service.model.UserDebitRequest;
import com.calculator.calculatorgatewayservice.utils.CalculatorConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private PropertyProviderService propertyProviderService;

    @Autowired
    private CalculatorConnectionService calculatorConnectionService;

    public void topUpUser(UserCreditRequest userCreditRequest) throws APIBaseException {
        APIResponse response = calculatorConnectionService.POST(propertyProviderService.getUserServiceCreditURL(),userCreditRequest);
        if (!response.getSuccess()){
            throw new APIBaseException(response.getCode(),response.getMessage());
        }
    }

    public void debitUser(UserDebitRequest userDebitRequest) throws APIBaseException {
        APIResponse response = calculatorConnectionService.POST(propertyProviderService.getUserServiceDebitURL(),userDebitRequest);
        if (!response.getSuccess()){
            throw new APIBaseException(response.getCode(),response.getMessage());
        }
    }

    public User getUser(String emailId) throws APIBaseException {
        APIResponse response = calculatorConnectionService.GET(propertyProviderService.getUserServiceFetchURL().concat(emailId));
        if (!response.getSuccess()){
            throw new APIBaseException(response.getCode(),response.getMessage());
        }
        return User.buildFromData(response.getData());
    }
}
