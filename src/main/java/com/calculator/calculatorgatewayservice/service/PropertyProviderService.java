package com.calculator.calculatorgatewayservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by akashdeepnew on 20/12/18.
 */
@Service
public class PropertyProviderService {


    @Value("${operation.calculation.service.add.url:http://localhost:8090/add/calculate}")
    private String addServiceCalculationURL;

    @Value("${operation.cost.service.add.url:http://localhost:8090/add/cost}")
    private String addServiceCostURL;


    @Value("${operation.calculation.service.sub.url:http://localhost:8080/subtract/calculate}")
    private String subServiceCalculationURL;

    @Value("${operation.cost.service.sub.url:http://localhost:8080/subtract/cost}")
    private String subServiceCostURL;



    @Value("${operation.calculation.service.div.url:http://localhost:8080/divide/calculate}")
    private String divServiceCalculationURL;

    @Value("${operation.cost.service.div.url:http://localhost:8080/div/cost}")
    private String divServiceCostURL;



    @Value("${operation.calculation.service.mul.url:http://localhost:8080/multiply/calculate}")
    private String mulServiceCalculationURL;

    @Value("${operation.cost.service.mul.url:http://localhost:8080/mul/cost}")
    private String mulServiceCostURL;




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
}
