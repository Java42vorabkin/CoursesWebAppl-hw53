package telran.spring.calculator.service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Calculator {
	Map<String, CalculatorOperation> mapOperations;
	@Autowired
	public Calculator(List<CalculatorOperation> listOperations) {
		mapOperations = listOperations.stream()
				.collect(Collectors.toMap(CalculatorOperation::getOperation, co -> co));
	}
	public double calculate(String operation, double operands[]) {
		CalculatorOperation calculatorOperation = mapOperations.get(operation);
		return calculatorOperation.calculate(operands);
	}
}
