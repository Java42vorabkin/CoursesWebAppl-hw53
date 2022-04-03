package telran.spring.calculator.dto;

import javax.validation.constraints.*;

public class CalculateData {
	@NotEmpty
public String operation;
	@Size(min = 1, max = 2)
public double[] operands;
public CalculateData(String operation, double[] operands) {
	this.operation = operation;
	this.operands = operands;
}
public CalculateData() {
}
}
