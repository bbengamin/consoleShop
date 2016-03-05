package com.epam.preprod.bohdanov.Task2_1.builder;

import java.util.Scanner;

import com.epam.preprod.bohdanov.Task2_1.entity.Building;
import com.epam.preprod.bohdanov.Task2_1.entity.Skyscraper;
import com.epam.preprod.bohdanov.Task2_1.printer.Printer;

/**
 * Create a new skyscraper using ask for data to console
 */
public class SkyscraperBuilder extends BuildingBuilder {

    private static final String INPUT_NAME_MESSAGE = "Введите имя дома:";
    private static final String INPUT_YEAR_MESSAGE = "Введите год постройки дома:";
    private static final String INPUT_PRICE_MESSAGE = "Введите цену дома:";
    private static final String INPUT_LEVELS_MESSAGE = "Введите количество этажей в доме:";
    private static final String INPUT_PARKING_MESSAGE = "Есть ли парковка(д/н):";
    private static final String INPUT_HELIPORT_MESSAGE = "Есть ли вертолетная площадка(д/н):";

    public SkyscraperBuilder(Printer out) {
        super(out);
    }

    @Override
    public Building getInstanceFromStream(Scanner scanner) {
        Skyscraper building = new Skyscraper();
        out.print(INPUT_NAME_MESSAGE);
        building.setName(scanner.nextLine());
        out.print(INPUT_YEAR_MESSAGE);
        building.setYear(scanner.nextInt());
        out.print(INPUT_PRICE_MESSAGE);
        building.setPrice(scanner.nextLong());
        out.print(INPUT_LEVELS_MESSAGE);
        building.setLevels(scanner.nextInt());
        building.setParking(askForParking(scanner));
        building.setHeliport(askForHeliport(scanner));
        return building;

    }

    private boolean askForParking(Scanner in) {
        out.print(INPUT_PARKING_MESSAGE);
        in.nextLine();
        String inputType = in.nextLine();
        if (inputType != null && inputType.compareTo("д") == 0) {
            return true;
        }
        return false;
    }

    private boolean askForHeliport(Scanner in) {
        out.print(INPUT_HELIPORT_MESSAGE);
        String inputType = in.nextLine();
        if (inputType != null && inputType.compareTo("д") == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Building getInstanceUsingRandom() {
        Skyscraper building = new Skyscraper();
        String name = "Building " + getPositiveIntRandomValue(100);
        building.setName(name);
        building.setYear(getPositiveIntRandomValue(2015));
        building.setPrice(Long.valueOf(getPositiveIntRandomValue(99999)));
        building.setLevels(getPositiveIntRandomValue(100));
        building.setParking((getPositiveIntRandomValue(1) == 1) ? true : false);
        building.setHeliport((getPositiveIntRandomValue(1) == 1) ? true : false);
        return building;
    }
}
