package com.epam.preprod.bohdanov.Task2_1.command.console;

import com.epam.preprod.bohdanov.Task2_1.controller.Shop;
import com.epam.preprod.bohdanov.Task2_1.printer.Printer;

public class NoCommand extends Command {

    private static final String NO_COMMAND_MESSAGE = "No such command";

    public NoCommand(Printer out) {
        super(out);
    }

    @Override
    public void execute(Shop shop) {
        out.print(NO_COMMAND_MESSAGE);
    }

}
