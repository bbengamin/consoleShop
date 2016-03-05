package com.epam.preprod.bohdanov.Task2_1.adder;

import java.util.Scanner;

import com.epam.preprod.bohdanov.Task2_1.builder.BuildingBuilder;
import com.epam.preprod.bohdanov.Task2_1.entity.Building;
import com.epam.preprod.bohdanov.Task2_1.printer.Printer;

/**
 * Created new products using {@link BuildingBuilder}
 */
public class CustomProductAdder extends ProductAdder {

    public CustomProductAdder(Printer out) {
        super(out);
    }

    @Override
    protected Building generateProduct(BuildingBuilder builder) {
        return builder.getInstanceFromStream(new Scanner(System.in));
    }
}
