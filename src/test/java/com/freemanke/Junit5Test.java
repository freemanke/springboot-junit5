package com.freemanke;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class Junit5Test {

    @BeforeAll
    public static void beforeAll() {

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
        assertTimeout(ofMillis(10), () -> Thread.sleep(3));
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

    enum StatusType {
        CRYING, LAUGHING, OTHERS
    }
}


