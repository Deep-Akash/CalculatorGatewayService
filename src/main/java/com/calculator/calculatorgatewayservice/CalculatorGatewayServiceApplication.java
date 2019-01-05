package com.calculator.calculatorgatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CalculatorGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorGatewayServiceApplication.class, args);
	}


}

