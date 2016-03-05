package com.epam.preprod.bohdanov.Task2_1.command.console;

import java.text.ParseException;
import java.util.Scanner;

import com.epam.preprod.bohdanov.Task2_1.controller.Shop;
import com.epam.preprod.bohdanov.Task2_1.printer.Printer;

public class MakeOrderCommand extends Command {

    private static final String GET_DATE_MESSAGE = "Enter date (yyyy-mm-dd) : ";
    private static final String ERROR_MESSAGE = "Bad data format ";

    public MakeOrderCommand(Printer out) {
        super(out);
    }

    @Override
    public void execute(Shop shop) {
        Scanner console = new Scanner(System.in);
        String dateString = getDate(console);

        try {
            printTotal(shop.makeOrder(dateString));
        } catch (ParseException e) {
            out.print(ERROR_MESSAGE);
        }
    }

    private String getDate(Scanner console) {
        out.print(GET_DATE_MESSAGE);
        return console.next();
    }

    private void printTotal(Long total) {
        out.print(total / 100.);
    }

}
