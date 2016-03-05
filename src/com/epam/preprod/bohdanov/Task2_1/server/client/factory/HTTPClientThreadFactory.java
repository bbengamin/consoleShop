package com.epam.preprod.bohdanov.Task2_1.server.client.factory;

import java.net.Socket;

import com.epam.preprod.bohdanov.Task2_1.controller.Shop;
import com.epam.preprod.bohdanov.Task2_1.server.client.HTTPClientThread;

public class HTTPClientThreadFactory implements ClientThreadFactory {

    @Override
    public Runnable newClientThread(Shop shop, Socket socket) {
        return new HTTPClientThread(socket, shop);
    }

}
