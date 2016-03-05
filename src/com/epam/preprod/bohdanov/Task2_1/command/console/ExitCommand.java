package com.epam.preprod.bohdanov.Task2_1.command.console;

import com.epam.preprod.bohdanov.Task2_1.controller.Shop;
import com.epam.preprod.bohdanov.Task2_1.printer.Printer;

public class ExitCommand extends Command {

    private static final String FILE_NAME = "catalog.ser";

    public ExitCommand(Printer out) {
        super(out);
    }

    @Override
    public void execute(Shop shop) {
        if (shop.saveCatalog(FILE_NAME)) {
            out.print("Catalog was successfully saved!");
        }
        System.exit(0);
    }

}
