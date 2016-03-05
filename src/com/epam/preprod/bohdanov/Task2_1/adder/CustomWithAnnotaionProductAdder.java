package com.epam.preprod.bohdanov.Task2_1.adder;

import com.epam.preprod.bohdanov.Task2_1.builder.BuildingBuilder;
import com.epam.preprod.bohdanov.Task2_1.entity.Building;
import com.epam.preprod.bohdanov.Task2_1.printer.Printer;

/**
 * Created new products using annotation
 */
public class CustomWithAnnotaionProductAdder extends ProductAdderWithAnnotation {

    public CustomWithAnnotaionProductAdder(Printer out) {
        super(out);
    }

    @Override
    protected Building generateProduct(BuildingBuilder builder) {
        return builder.getInstanceFromStream(scanner);
    }
}
