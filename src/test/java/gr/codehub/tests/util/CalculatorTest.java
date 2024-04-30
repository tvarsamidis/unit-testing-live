package gr.codehub.tests.util;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Tests have started!");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Tests have finished");
    }

    @BeforeEach
    void beforeEach() {
        calculator = new Calculator();
        calculator.plus(10);
    }

    @Test
    void plusTest() {
        calculator.plus(1);
        calculator.plus(2);
        assertEquals(13, calculator.getResult());
    }

    @Test
    void divideTest() {
        calculator.divideBy(7);
        assertEquals(1.4285714285714286, calculator.getResult());
    }

    @Test
    void divideByZeroTest() {
        calculator.divideBy(0);
        assertEquals(0, calculator.getResult());
    }

    @Test
    void decimalAccuracy() {
        double number = 5;
        double root = Math.sqrt(number);
        calculator.setResult(0);
        calculator.plus(root);
        calculator.times(root);
        calculator.minus(number);
        assertTrue(calculator.getResult() < 1e-15, "Result must be zero");
    }


}
