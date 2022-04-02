package com.company;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class CarUtil {
    public static Car @NotNull [] generateCars(int count) {
        Car[] result = new Car[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = new Car();

        }
        return result;
    }
}
