package com.freemanke;

public interface Mathematical {

    static double square(double number) {
        return number * number;
    }

    default double getPi() {
        return java.lang.Math.PI;
    }
}
