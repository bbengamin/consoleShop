package com.epam.preprod.bohdanov.Task2_1.adder;

import java.util.Locale;
import java.util.Scanner;

import com.epam.preprod.bohdanov.Task2_1.builder.AnnotationBuilder;
import com.epam.preprod.bohdanov.Task2_1.entity.Building;
import com.epam.preprod.bohdanov.Task2_1.printer.Printer;

public abstract class ProductAdderWithAnnotation extends ProductAdder {
    public ProductAdderWithAnnotation(Printer out) {
        super(out);
    }

    private static final String LANGUAGE_MESSAGE = "Выберите язык(ru/en):";
    protected Scanner scanner;

    public Building addProduct() {
        scanner = new Scanner(System.in);
        String building = null;
        do {
            building = askForTypeOfProduct(scanner);
        } while (builders.getBuilder(building) == null);

        return generateProduct(new AnnotationBuilder(building, askForLocale(scanner), out));
    }

    private Locale askForLocale(Scanner in) {
        out.print(LANGUAGE_MESSAGE);
        String lang = in.next();
        if (lang.compareTo("ru") == 0) {
            return new Locale("ru", "RU");
        }
        return new Locale("en", "US");
    }
}
