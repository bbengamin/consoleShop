package com.epam.preprod.bohdanov.Task2_1.builder;

import java.util.Scanner;

import com.epam.preprod.bohdanov.Task2_1.entity.Bridge;
import com.epam.preprod.bohdanov.Task2_1.entity.Building;
import com.epam.preprod.bohdanov.Task2_1.printer.Printer;

/**
 * Create a new bridge using ask for data to console
 *
 */
public class BridgeBuilder extends BuildingBuilder {

    private static final String INPUT_NAME_MESSAGE = "Введите имя моста:";
    private static final String INPUT_YEAR_MESSAGE = "Введите год постройки моста:";
    private static final String INPUT_PRICE_MESSAGE = "Введите цену моста:";
    private static final String INPUT_LENGTH_MESSAGE = "Введите длинну моста:";
    private static final String INPUT_TYPE_MESSAGE = "Введите тип моста:";

    public BridgeBuilder(Printer out) {
        super(out);
    }

    @Override
    public Building getInstanceFromStream(Scanner scanner) {
        Bridge building = new Bridge();
        out.print(INPUT_NAME_MESSAGE);
        building.setName(scanner.nextLine());
        out.print(INPUT_YEAR_MESSAGE);
        building.setYear(scanner.nextInt());
        out.print(INPUT_PRICE_MESSAGE);
        building.setPrice(scanner.nextLong());
        out.print(INPUT_LENGTH_MESSAGE);
        building.setLength(scanner.nextInt());
        out.print(INPUT_TYPE_MESSAGE);
        building.setType(scanner.next());
        return building;
    }

    @Override
    public Building getInstanceUsingRandom() {
        Bridge building = new Bridge();
        String name = "Building " + getPositiveIntRandomValue(100);
        String type = "Type " + getPositiveIntRandomValue(100);
        building.setName(name);
        building.setYear(getPositiveIntRandomValue(2015));
        building.setPrice(Long.valueOf(getPositiveIntRandomValue(99999)));
        building.setLength(getPositiveIntRandomValue(500));
        building.setType(type);
        return building;
    }

}
