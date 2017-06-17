package com.freemanke.springbootjunit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Properties;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class Junit5PractiseTest {

    @BeforeAll
    public static void beforeAll() {
        Properties props = new Properties();
        props.setProperty("ENV", "DEV");
        System.setProperties(props);
    }

    @Test
    @DisplayName("Standard assertions")
    public void standardAssertions() {
        assertEquals(2, 1 + 1);
    }

    @Test
    @Tag("groups")
    public void groupAssertions() {
        assertAll("full name",
                () -> assertEquals("freeman", "freeman"),
                () -> assertEquals("ke", "ke"));
    }

    @Test
    public void timeoutNotExceeded() {
        assertTimeout(ofMillis(2), () -> Thread.sleep(1));
    }

    @Test
    public void timeoutNotExceededWithResult() {
        String result = assertTimeout(ofMillis(2), () -> "value");
        assertEquals("value", result);
    }

    @Test
    public void exceptionTesting() {
        assertThrows(IllegalAccessException.class, () -> {
            throw new IllegalAccessException("acl error");
        });
    }

    @Test
    public void assumption() {
        System.out.println(System.getProperty("ENV"));
        assumeTrue("DEV".equals(System.getProperty("ENV")));
    }

    @Test
    @Disabled
    public void disabledTesting() {

    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    public void testWithStringParameter(String argument) {
        assertNotNull(argument);
    }

    @ParameterizedTest
    @EnumSource(StatusType.class)
    public void testWithEnumParameter(StatusType argument) {
        System.out.println(argument);
        assertNotNull(argument);
    }
}

enum StatusType {
    CRYING,LAUGHING,OTHERS
}
