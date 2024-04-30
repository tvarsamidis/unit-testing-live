package gr.codehub.tests;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AssertionDemoTest {

    @Test
    void testException() {
        assertThrows(ArithmeticException.class, () -> {
                    System.out.println("Hello");
                    int divisionResult = 1 / 1;
                    System.out.println(divisionResult);
                }
        );
    }

    @Test
    void testNull() {
        File f = null;
        assertNull(f, "The file at this point must be null");
        assertTrue(f == null);
    }

    @Test
    @DisplayName("Testing for non-Windows Systems")
    @DisabledOnOs(OS.WINDOWS)
    void runsOnNonWindows() {
        double d = 0.1;
        double e = 0.2;
        assertEquals(d + e, 0.3);
    }


    @RepeatedTest(100)
    void validRandomSpread(RepetitionInfo ri) {
        System.out.println("Rrepeat no. " + ri.getCurrentRepetition());
        Random random = new Random();
        assertEquals(3, random.nextInt(5));
    }
    private static String[] words = {"hi", "bye", "welcome"};

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void testEvenNumbers(int value) {
        assertEquals(3, words[value].length(), "word '" + words[value] + "' must have " + 3 + " characters" );
    }

    private static Stream<Arguments> peopleGroups() {
        return  Stream.of(
                arguments(2, List.of("Thomas", "Maria")),
                arguments(1, List.of("Lefteris")),
                arguments(3, List.of("Thomas", "Maria", "Eleni", "Dimitra"))
                );
    }

    @ParameterizedTest
    @MethodSource("peopleGroups")
    @DisplayName("Check size of groups of people")
    void checkSizeOfGroupsOfPeople(int number, List<String> peopleNames) {
        assertEquals(number, peopleNames.size());
    }


}
