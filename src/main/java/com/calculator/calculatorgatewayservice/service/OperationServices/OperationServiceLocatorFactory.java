package com.calculator.calculatorgatewayservice.service.OperationServices;

import com.calculator.calculatorgatewayservice.enums.CalculatorOperationsENUM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by akashdeepnew on 26/12/18.
 */
@Service
public class OperationServiceLocatorFactory {

    @Autowired
    private AddOperationServiceIMPL addOperationServiceIMPL;

    @Autowired
    private SubtractOperationServiceIMPL subtractOperationServiceIMPL;

    @Autowired
    private MultiplyOperationServiceIMPL multiplyOperationServiceIMPL;

    @Autowired
    private DivideOperationServiceIMPL divideOperationServiceIMPL;

    public OperationServiceInterface getOperationService(CalculatorOperationsENUM calculatorOperationsENUM) {
        switch (calculatorOperationsENUM) {
            case ADD: return addOperationServiceIMPL;
            case SUB: return subtractOperationServiceIMPL;
            case MUL: return multiplyOperationServiceIMPL;
            case DIV: return divideOperationServiceIMPL;
            default: return null;
        }
    }
}
