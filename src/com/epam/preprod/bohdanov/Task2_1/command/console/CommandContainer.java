package com.epam.preprod.bohdanov.Task2_1.command.console;

import java.util.HashMap;
import java.util.Map;

import com.epam.preprod.bohdanov.Task2_1.printer.Printer;

/**
 * Container for commands
 */
public class CommandContainer {
    private Map<Integer, Command> commands;
    private Printer out;

    public CommandContainer(Printer out) {
        this.out = out;
        commands = new HashMap<Integer, Command>();
        commands.put(1, new ShowProductListCommand(out));
        commands.put(2, new AddToCartCommand(out));
        commands.put(3, new ShowCartCommand(out));
        commands.put(4, new MakeOrderCommand(out));
        commands.put(5, new GetLastAddedCommand(out));
        commands.put(6, new GetOrdersByDatePeriodCommand(out));
        commands.put(7, new GetOrderByNearestDateCommand(out));
        commands.put(8, new AddNewProductCommand(out));
        commands.put(0, new ExitCommand(out));
    }

    public Command getCommand(int index) {
        Command command = commands.get(index);
        if (command == null) {
            return new NoCommand(out);
        }
        return command;
    }
}
