package com.epam.preprod.bohdanov.Task2_1.server.client.factory;

import java.net.Socket;

import com.epam.preprod.bohdanov.Task2_1.controller.Shop;
import com.epam.preprod.bohdanov.Task2_1.server.client.TCPClientThread;

public class TCPClientThreadFactory implements ClientThreadFactory {

    @Override
    public Runnable newClientThread(Shop shop, Socket socket) {
        return new TCPClientThread(socket, shop);
    }

}
