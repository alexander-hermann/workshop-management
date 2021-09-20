package de.hs_kl.staab.assignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	public Calculator calculator;

	@BeforeEach
	void setUp() {
		this.calculator = new Calculator();
	}

	@Test
	public void squareTest() {
		assertEquals(25, this.calculator.square(5));
	}

}
