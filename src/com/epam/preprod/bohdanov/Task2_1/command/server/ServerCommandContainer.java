package com.epam.preprod.bohdanov.Task2_1.command.server;

import java.util.HashMap;
import java.util.Map;

import com.epam.preprod.bohdanov.Task2_1.printer.Printer;

public class ServerCommandContainer {
    private Map<String, Command> commands;
    private Printer out;

    public ServerCommandContainer(Printer out) {
        this.out = out;
        commands = new HashMap<String, Command>();
        commands.put("get count", new GetCountOfProductCommand(out));
        commands.put("/shop/count", new GetCountOfProductCommandJSON(out));
        commands.put("get item", new GetItemCommand(out));
        commands.put("/shop/item?get_info", new GetItemCommandJSON(out));
    }

    public Command getCommand(String str) {
        Command command = commands.get(str);
        if (command == null) {
            return new NoCommand(out);
        }
        return command;
    }
}
