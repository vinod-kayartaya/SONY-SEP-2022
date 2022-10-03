package com.sony.utils.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sony.utils.MathUtils;
import com.sony.utils.MathsException;

class MathUtilsTests {
	MathUtils mu;

	@BeforeEach
	void setup() {
		mu = new MathUtils();
	}

	@AfterEach
	void tearDown() {
	}
	
	@Test
	void shouldReturnFactorial() {
		Long f = mu.factorial(5);
		assertEquals(120, f);
	}

	@Test
	void shouldGetOneAsFactorialForZero() {
		Long f = mu.factorial(0);
		assertEquals(1, f);
	}

	@Test
	void shouldCauseErrorForNegativeInput() {
		// assertThrows(MathsException.class, ()->{})
		
		assertThrows(MathsException.class, () -> {
			mu.factorial(-12);
		});
	}

	@Test
	void shouldThrowMathsExceptionForNegativeInput() {
		try {
			mu.factorial(-12);
			fail("Expected to catch a MathsException, but did not!");
		} catch (MathsException me) {
			// no problem
		}
	}
}
