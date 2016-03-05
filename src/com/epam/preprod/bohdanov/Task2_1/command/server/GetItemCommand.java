package com.epam.preprod.bohdanov.Task2_1.command.server;

import java.util.UUID;

import com.epam.preprod.bohdanov.Task2_1.controller.Shop;
import com.epam.preprod.bohdanov.Task2_1.entity.Building;
import com.epam.preprod.bohdanov.Task2_1.printer.Printer;

public class GetItemCommand extends Command {

    public GetItemCommand(Printer out) {
        super(out);
    }

    @Override
    public void execute(Shop shop, String request) {
        Building product = shop.getProductList().get(UUID.fromString(request));
        out.print(product.getName() + "|" + product.getPrice());
    }

}
