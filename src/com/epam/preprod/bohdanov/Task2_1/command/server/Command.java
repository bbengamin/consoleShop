package com.epam.preprod.bohdanov.Task2_1.command.server;

import com.epam.preprod.bohdanov.Task2_1.controller.Shop;
import com.epam.preprod.bohdanov.Task2_1.printer.Printer;

public abstract class Command {
    protected Printer out;

    public Command(Printer out) {
        this.out = out;
    }

    public abstract void execute(Shop shop, String request);
}
