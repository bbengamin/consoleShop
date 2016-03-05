package com.epam.preprod.bohdanov.Task2_1.server.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

import com.epam.preprod.bohdanov.Task2_1.command.server.Command;
import com.epam.preprod.bohdanov.Task2_1.command.server.ServerCommandContainer;
import com.epam.preprod.bohdanov.Task2_1.controller.Shop;
import com.epam.preprod.bohdanov.Task2_1.printer.StreamPrinter;

public class TCPClientThread implements Runnable {
    private Socket socket;
    private Shop shop;
    ServerCommandContainer container;

    public TCPClientThread(Socket socket, Shop shop) {
        this.socket = socket;
        this.shop = shop;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            container = new ServerCommandContainer(new StreamPrinter(pw));

            byte[] buffer = new byte[1024];
            int read = is.read(buffer);
            String commandString = new String(buffer, 0, read).trim();
            String request = null;
            if (commandString.contains("=")) {
                request = commandString.split("=")[1];
                commandString = commandString.split("=")[0];
            }
            Command command = container.getCommand(commandString);
            command.execute(shop, request);
            socket.close();
            System.out.println("client finish");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
