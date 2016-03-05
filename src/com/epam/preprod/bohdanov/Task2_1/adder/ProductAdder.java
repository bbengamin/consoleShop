package com.epam.preprod.bohdanov.Task2_1.adder;

import java.util.Map;
import java.util.Scanner;

import com.epam.preprod.bohdanov.Task2_1.builder.BuilderContainer;
import com.epam.preprod.bohdanov.Task2_1.builder.BuildingBuilder;
import com.epam.preprod.bohdanov.Task2_1.entity.Building;
import com.epam.preprod.bohdanov.Task2_1.printer.Printer;

/**
 * Create a new product
 *
 */
public abstract class ProductAdder {
    private static final String PRODUCT_TYPE_MESSAGE = "Продукт какого типа вы хотите создать? ";
    private static final String AVALIBLE_TYPE_MESSAGE = "Доступные типы: ";
    private Scanner scanner;
    protected Printer out;
    protected BuilderContainer builders;

    public ProductAdder(Printer out) {
        this.out = out;
        builders = new BuilderContainer(out);
    }

    /**
     * @return - a new generated product
     */
    public Building addProduct() {
        scanner = new Scanner(System.in);
        BuildingBuilder builder = null;
        do {
            builder = builders.getBuilder(askForTypeOfProduct(scanner));
        } while (builder == null);
        return generateProduct(builder);
    }

    protected abstract Building generateProduct(BuildingBuilder builder);

    public String askForTypeOfProduct(Scanner in) {
        out.print(PRODUCT_TYPE_MESSAGE);
        printAvalibleTypes();
        return in.nextLine();
    }

    private void printAvalibleTypes() {
        Map<String, BuildingBuilder> map = builders.getMap();
        StringBuilder sb = new StringBuilder(AVALIBLE_TYPE_MESSAGE);
        for (String element : map.keySet()) {
            sb.append(element).append(", ");
        }
        out.print(sb.substring(0, sb.length() - 2));
    }
}
