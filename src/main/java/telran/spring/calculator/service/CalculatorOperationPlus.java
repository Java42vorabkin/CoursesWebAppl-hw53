package telran.spring.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorOperationPlus implements CalculatorOperation {

	@Override
	public double calculate(double operands[]) {
		CalculatorOperation.checkOperandsNumber(operands, 2);
		return operands[0] + operands[1];
	}

	@Override
	public String getOperation() {
		
		return "+";
	}

}
