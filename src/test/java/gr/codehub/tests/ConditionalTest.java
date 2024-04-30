package gr.codehub.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class ConditionalTest {

    @Test
    // @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_21)
    @EnabledOnJre(JRE.JAVA_17)
    @DisabledOnJre(JRE.OTHER)
    void jreCorrectVersion() {
        fail("Cannot run in version below 22");
    }

    @Test
    @DisabledIfSystemProperty(named = "file.separator", matches = "[/]")
    void runOnWindowsFilesystem(){

    }

    @Test
    void finishIn1Second() {
        assertTimeoutPreemptively(Duration.of(1200, ChronoUnit.MILLIS), () -> Thread.sleep(1000) );
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void finishAllIn1Second() {
        for (long i = 0; i < 1_000_000_000L; i++);
    }


}
