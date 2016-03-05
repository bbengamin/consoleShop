package com.epam.preprod.bohdanov.Task2_1.builder.generator;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {
    private final static int MAX_RANDOM_VALUE = 1000;
    private final static int MAX_RANDOM_VALUE_FOR_BOOLEAN = 2;

    public static String getRandomWithPrefix(String prefix) {
        return prefix + ThreadLocalRandom.current().nextInt(0, MAX_RANDOM_VALUE);
    }

    public static Boolean getRandomBoolean() {
        return (ThreadLocalRandom.current().nextInt(0, MAX_RANDOM_VALUE_FOR_BOOLEAN) == 0) ? true : false;
    }

    public static Integer getRandomValue() {
        return ThreadLocalRandom.current().nextInt(0, MAX_RANDOM_VALUE);
    }

}
