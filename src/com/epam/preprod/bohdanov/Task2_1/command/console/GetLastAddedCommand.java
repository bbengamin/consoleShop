package com.epam.preprod.bohdanov.Task2_1.command.console;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.epam.preprod.bohdanov.Task2_1.controller.Shop;
import com.epam.preprod.bohdanov.Task2_1.entity.Building;
import com.epam.preprod.bohdanov.Task2_1.printer.Printer;

public class GetLastAddedCommand extends Command {

    public GetLastAddedCommand(Printer out) {
        super(out);
    }

    @Override
    public void execute(Shop shop) {
        printLastProducts(shop.getLastProducts());
    }

    private void printLastProducts(Collection<Building> productList) {
        List<Building> list = new ArrayList<Building>(productList);
        for (int i = list.size() - 1; i >= 0; i--) {
            out.print(list.get(i));
        }
    }

}
