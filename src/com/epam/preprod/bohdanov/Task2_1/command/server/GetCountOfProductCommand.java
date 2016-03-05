package com.epam.preprod.bohdanov.Task2_1.command.server;

import com.epam.preprod.bohdanov.Task2_1.controller.Shop;
import com.epam.preprod.bohdanov.Task2_1.printer.Printer;

public class GetCountOfProductCommand extends Command {

    public GetCountOfProductCommand(Printer out) {
        super(out);
    }

    @Override
    public void execute(Shop shop, String request) {
        out.print(shop.getProductList().size());
    }
}
