package com.epam.preprod.bohdanov.Task2_1.server.client.factory;

import java.net.Socket;

import com.epam.preprod.bohdanov.Task2_1.controller.Shop;

public interface ClientThreadFactory {
    public Runnable newClientThread(Shop shop, Socket socket);
}
