package telran.spring.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import telran.spring.calculator.dto.CalculateData;
import telran.spring.calculator.service.Calculator;

@RestController
@RequestMapping("/calculator")
public class CalculatorApplicationController {
	@Autowired
	Calculator calculator;
	@PostMapping
	double calculate(@RequestBody CalculateData calculateData) {
		return calculator.calculate(calculateData.operation, calculateData.operands);
	}
}
