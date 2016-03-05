package com.epam.preprod.bohdanov.Task2_1.command.console;

import com.epam.preprod.bohdanov.Task2_1.controller.Shop;
import com.epam.preprod.bohdanov.Task2_1.printer.Printer;

public class AddNewProductCommand extends Command {

    public AddNewProductCommand(Printer out) {
        super(out);
    }

    @Override
    public void execute(Shop shop) {
        shop.addNewProductToCatalog();
    }
}
