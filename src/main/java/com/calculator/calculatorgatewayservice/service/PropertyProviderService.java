package com.calculator.calculatorgatewayservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

/**
 * Created by akashdeepnew on 20/12/18.
 */
@RefreshScope
@Service
public class PropertyProviderService {


    @Value("${operation.calculation.service.add.url:http://localhost:8090/add/calculate}")
    private String addServiceCalculationURL;

    @Value("${operation.cost.service.add.url:http://localhost:8090/add/cost}")
    private String addServiceCostURL;


    @Value("${operation.calculation.service.sub.url:http://localhost:8091/subtract/calculate}")
    private String subServiceCalculationURL;

    @Value("${operation.cost.service.sub.url:http://localhost:8091/subtract/cost}")
    private String subServiceCostURL;



    @Value("${operation.calculation.service.div.url:http://localhost:8092/divide/calculate}")
    private String divServiceCalculationURL;

    @Value("${operation.cost.service.div.url:http://localhost:8092/div/cost}")
    private String divServiceCostURL;



    @Value("${operation.calculation.service.mul.url:http://localhost:8093/multiply/calculate}")
    private String mulServiceCalculationURL;

    @Value("${operation.cost.service.mul.url:http://localhost:8093/mul/cost}")
    private String mulServiceCostURL;


    @Value("${user.service.debit.url:http://localhost:8094/user/debit}")
    private String userServiceDebitURL;

    @Value("${user.service.credit.url:http://localhost:8094/user/credit}")
    private String userServiceCreditURL;

    @Value("${user.service.fetch.url:http://localhost:8094/user/get?email=}")
    private String userServiceFetchURL;



    public String getAddServiceCalculationURL() {
        return addServiceCalculationURL;
    }

    public String getAddServiceCostURL() {
        return addServiceCostURL;
    }

    public String getSubServiceCalculationURL() {
        return subServiceCalculationURL;
    }

    public String getSubServiceCostURL() {
        return subServiceCostURL;
    }

    public String getDivServiceCalculationURL() {
        return divServiceCalculationURL;
    }

    public String getDivServiceCostURL() {
        return divServiceCostURL;
    }

    public String getMulServiceCalculationURL() {
        return mulServiceCalculationURL;
    }

    public String getMulServiceCostURL() {
        return mulServiceCostURL;
    }

    public String getUserServiceDebitURL() {
        return userServiceDebitURL;
    }

    public String getUserServiceCreditURL() {
        return userServiceCreditURL;
    }

    public String getUserServiceFetchURL() {
        return userServiceFetchURL;
    }
}
