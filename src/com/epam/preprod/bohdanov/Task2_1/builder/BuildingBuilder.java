package com.epam.preprod.bohdanov.Task2_1.builder;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.epam.preprod.bohdanov.Task2_1.entity.Building;
import com.epam.preprod.bohdanov.Task2_1.printer.Printer;

/**
 * Create a new building
 */
public abstract class BuildingBuilder {
    protected Printer out;

    public BuildingBuilder(Printer out) {
        this.out = out;
    }

    public abstract Building getInstanceFromStream(Scanner scanner);

    public abstract Building getInstanceUsingRandom();

    public static int getPositiveIntRandomValue(int bound) {
        Random rand = ThreadLocalRandom.current();
        int value = -1;
        while (value < 0) {
            value = rand.nextInt(bound);
        }
        return value;
    }
}
