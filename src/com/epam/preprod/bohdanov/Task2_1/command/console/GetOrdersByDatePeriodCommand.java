package com.epam.preprod.bohdanov.Task2_1.command.console;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

import com.epam.preprod.bohdanov.Task2_1.controller.Shop;
import com.epam.preprod.bohdanov.Task2_1.entity.Building;
import com.epam.preprod.bohdanov.Task2_1.printer.Printer;
import com.epam.preprod.bohdanov.Task2_1.repository.Cart;

public class GetOrdersByDatePeriodCommand extends Command {

    private static final String GET_FROM_DATE_MESSAGE = "Enter from (yyyy-mm-dd) : ";
    private static final String GET_TO_DATE_MESSAGE = "Enter to (yyyy-mm-dd) : ";
    private static final String ERROR_MESSAGE = "Bad data format ";

    public GetOrdersByDatePeriodCommand(Printer out) {
        super(out);
    }

    @Override
    public void execute(Shop shop) {
        Scanner console = new Scanner(System.in);

        String from = getDateFrom(console);
        String to = getDateTo(console);
        try {
            printOrders(shop.getOrdersByDate(from, to));
        } catch (ParseException e) {
            out.print(ERROR_MESSAGE);
        }
    }

    private String getDateFrom(Scanner console) {
        out.print(GET_FROM_DATE_MESSAGE);
        return console.next();
    }

    private String getDateTo(Scanner console) {
        out.print(GET_TO_DATE_MESSAGE);
        return console.next();
    }

    private void printOrders(Map<Date, Cart<Building>> orders) {
        for (Date order : orders.keySet()) {
            out.print(order);
            out.print(orders.get(order));
        }
    }
}
