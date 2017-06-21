package com.freemanke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Java8Tests {

    @Test
    public void useInterfaceStaticMethod() {
        assertEquals(4, Mathematical.square(2));
    }

    @Test
    public void useInterfaceDefaultMethod() {
        assertEquals(java.lang.Math.PI, new Calculator().getPi());
    }
}



