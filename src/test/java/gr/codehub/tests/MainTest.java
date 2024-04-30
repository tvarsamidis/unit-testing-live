package gr.codehub.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {


    @Test
    void test1() {
        System.out.println("this is test 1");
    }

    @Test
    void test2() {
        if (Math.random() >= 0.001) {
            fail("This test fails 50% of the time");
        }
    }

    @Test
    void test3() {
        int input = 8;
        int output = 4;
        assertEquals(input, output);
    }


    @Test
    void test4() {
        assertEquals(Main.getANumber(8), 16);
    }

    @Test
    void test5() {
        boolean[] input = {true, true, false};
        boolean[] output = {true, false, false};
        assertArrayEquals(input, output, "The two arrays must be equal");
    }

    @Test
    void test6() {
        int input = 7;
        int output = 8;
        assertTrue(input == output, "Input must be 10% more than the output");
    }

    @Test
    void helloStringEqualToResultTest() {
        String result = "Hello";
        assertAll("Must be equal", () -> assertEquals("Hello", result), () -> assertNotEquals(result, "goodbye") );
    }


}
