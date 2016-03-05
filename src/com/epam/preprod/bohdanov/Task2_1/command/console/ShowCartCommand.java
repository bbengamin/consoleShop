package com.epam.preprod.bohdanov.Task2_1.command.console;

import com.epam.preprod.bohdanov.Task2_1.controller.Shop;
import com.epam.preprod.bohdanov.Task2_1.printer.Printer;

public class ShowCartCommand extends Command {

    public ShowCartCommand(Printer out) {
        super(out);
    }

    @Override
    public void execute(Shop shop) {
        out.print(shop.getCart());
    }

}
