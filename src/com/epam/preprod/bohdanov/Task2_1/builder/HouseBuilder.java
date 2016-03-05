package com.epam.preprod.bohdanov.Task2_1.builder;

import java.util.Scanner;

import com.epam.preprod.bohdanov.Task2_1.entity.Building;
import com.epam.preprod.bohdanov.Task2_1.entity.House;
import com.epam.preprod.bohdanov.Task2_1.printer.Printer;

/**
 * Create a new house using ask for data to console
 *
 */
public class HouseBuilder extends BuildingBuilder {
    private static final String INPUT_NAME_MESSAGE = "Введите имя дома:";
    private static final String INPUT_YEAR_MESSAGE = "Введите год постройки дома:";
    private static final String INPUT_PRICE_MESSAGE = "Введите цену дома:";
    private static final String INPUT_LEVELS_MESSAGE = "Введите количество этажей в доме:";

    public HouseBuilder(Printer out) {
        super(out);
    }

    @Override
    public Building getInstanceFromStream(Scanner scanner) {
        House building = new House();
        out.print(INPUT_NAME_MESSAGE);
        building.setName(scanner.nextLine());
        out.print(INPUT_YEAR_MESSAGE);
        building.setYear(scanner.nextInt());
        out.print(INPUT_PRICE_MESSAGE);
        building.setPrice(scanner.nextLong());
        out.print(INPUT_LEVELS_MESSAGE);
        building.setLevels(scanner.nextInt());
        return building;
    }

    @Override
    public Building getInstanceUsingRandom() {
        House house = new House();
        String name = "Building " + getPositiveIntRandomValue(100);
        house.setName(name);
        house.setYear(getPositiveIntRandomValue(2015));
        house.setPrice(Long.valueOf(getPositiveIntRandomValue(99999)));
        house.setLevels(getPositiveIntRandomValue(100));
        return house;
    }

}
