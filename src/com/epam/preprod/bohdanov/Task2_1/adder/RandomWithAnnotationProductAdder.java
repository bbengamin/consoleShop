package com.epam.preprod.bohdanov.Task2_1.adder;

import com.epam.preprod.bohdanov.Task2_1.builder.BuildingBuilder;
import com.epam.preprod.bohdanov.Task2_1.entity.Building;
import com.epam.preprod.bohdanov.Task2_1.printer.Printer;

/**
 * Create a new product using random generator with annotation
 */
public class RandomWithAnnotationProductAdder extends ProductAdderWithAnnotation {

    public RandomWithAnnotationProductAdder(Printer out) {
        super(out);
    }

    @Override
    protected Building generateProduct(BuildingBuilder builder) {
        return builder.getInstanceUsingRandom();
    }
}
