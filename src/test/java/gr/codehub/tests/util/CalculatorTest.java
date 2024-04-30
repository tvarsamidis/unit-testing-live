package gr.codehub.tests.util;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    Calculator calculator;

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



}
