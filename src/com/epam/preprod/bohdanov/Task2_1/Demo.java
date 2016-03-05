package com.epam.preprod.bohdanov.Task2_1;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import com.epam.preprod.bohdanov.Task2_1.adder.AdderContainer;
import com.epam.preprod.bohdanov.Task2_1.adder.ProductAdder;
import com.epam.preprod.bohdanov.Task2_1.command.console.Command;
import com.epam.preprod.bohdanov.Task2_1.command.console.CommandContainer;
import com.epam.preprod.bohdanov.Task2_1.controller.Shop;
import com.epam.preprod.bohdanov.Task2_1.printer.ConsolePrinter;
import com.epam.preprod.bohdanov.Task2_1.server.Server;
import com.epam.preprod.bohdanov.Task2_1.server.client.factory.HTTPClientThreadFactory;
import com.epam.preprod.bohdanov.Task2_1.server.client.factory.TCPClientThreadFactory;

public class Demo {
    private static final String INPUT_TYPE_MESSAGE = "Выберите метод добавление товара";
    private static final String FILE_NAME = "catalog.ser";
    private static AdderContainer adders;

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        adders = new AdderContainer(new ConsolePrinter());
        Shop shop = new Shop(getAdder(in), FILE_NAME);
        startServer(shop);
        startServer2(shop);
        String selected = "";
        CommandContainer container = new CommandContainer(new ConsolePrinter());
        do {
            System.out.println(shop.getMenu());
            try {
                selected = in.next();
                Command command = container.getCommand(Integer.parseInt(selected));
                command.execute(shop);
            } catch (NumberFormatException ex) {
                System.out.println("No such command");
            }

        } while (selected.compareTo("0") != 0);
    }

    private static ProductAdder getAdder(Scanner in) {
        ProductAdder adder = null;
        do {
            adder = adders.getAdder(askForTypeOfAdding(in));
        } while (adder == null);
        return adder;
    }

    private static String askForTypeOfAdding(Scanner in) {
        System.out.print(INPUT_TYPE_MESSAGE);
        printAvalibleAdders();
        return in.next();
    }

    private static void printAvalibleAdders() {
        Map<String, ProductAdder> map = adders.getMap();
        StringBuilder sb = new StringBuilder("(");
        for (String element : map.keySet()) {
            sb.append(element).append("/");
        }
        System.out.println(sb.substring(0, sb.length() - 1) + "):");
    }

    private static void startServer(Shop shop) {
        try {
            Server server = new Server(3000, shop, new TCPClientThreadFactory());
            Thread thread = new Thread(server);
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void startServer2(Shop shop) {
        try {
            Server server = new Server(8080, shop, new HTTPClientThreadFactory());
            Thread thread = new Thread(server);
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
