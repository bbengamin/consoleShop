package com.epam.preprod.bohdanov.Task2_1.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.epam.preprod.bohdanov.Task2_1.controller.Shop;
import com.epam.preprod.bohdanov.Task2_1.server.client.factory.ClientThreadFactory;

public class Server implements Runnable {
    private ServerSocket serverSocket;
    private volatile boolean stop;
    private Shop shop;
    private ClientThreadFactory factory;

    public Server(int port, Shop shop, ClientThreadFactory factory) throws IOException {
        serverSocket = new ServerSocket(port);
        this.factory = factory;
        this.shop = shop;
        stop = false;
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                Socket clientSocket = serverSocket.accept();
                Thread thread = new Thread(factory.newClientThread(shop, clientSocket));
                thread.start();
            } catch (IOException ex) {
                System.out.println("Server stoped");
            }
        }
    }

    public void stop() throws IOException {
        stop = true;
        Thread.currentThread().interrupt();
        serverSocket.close();
    }

}
