package com.epam.preprod.bohdanov.Task2_1.command.console;

import java.util.Scanner;

import com.epam.preprod.bohdanov.Task2_1.controller.Shop;
import com.epam.preprod.bohdanov.Task2_1.printer.Printer;

class AddToCartCommand extends Command {

    private static final String GET_INDEX_MESSAGE = "Enter product index: ";
    private static final String GET_COUNT_MESSAGE = "Enter count of product: ";
    private static final String COUNT_ERROR_MESSAGE = "Nothing to add...";
    private static final String INDEX_ERROR_MESSAGE = "Bad index";
    private static final String SUCCESS_MESSAGE = " was added to cart";

    public AddToCartCommand(Printer out) {
        super(out);
    }

    @Override
    public void execute(Shop shop) {
        Scanner console = new Scanner(System.in);
        int index, count;

        out.print(shop.getProductList());
        index = getProductIndex(console);
        if (index < 1 || index > shop.getProductList().size()) {
            out.print(INDEX_ERROR_MESSAGE);
            return;
        }

        count = getCountOfProdutcs(console);
        if (count < 1) {
            out.print(COUNT_ERROR_MESSAGE);
            return;
        }

        out.print(shop.addToCart(index, count) + SUCCESS_MESSAGE);
    }

    private int getProductIndex(Scanner console) {
        out.print(GET_INDEX_MESSAGE);
        return console.nextInt();
    }

    private int getCountOfProdutcs(Scanner console) {
        out.print(GET_COUNT_MESSAGE);
        return console.nextInt();
    }

}
