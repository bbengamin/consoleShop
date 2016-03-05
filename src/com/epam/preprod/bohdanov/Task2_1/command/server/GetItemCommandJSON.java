package com.epam.preprod.bohdanov.Task2_1.command.server;

import java.util.UUID;

import org.json.JSONObject;

import com.epam.preprod.bohdanov.Task2_1.controller.Shop;
import com.epam.preprod.bohdanov.Task2_1.entity.Building;
import com.epam.preprod.bohdanov.Task2_1.printer.Printer;

public class GetItemCommandJSON extends Command {

    public GetItemCommandJSON(Printer out) {
        super(out);
    }

    @Override
    public void execute(Shop shop, String request) {
        Building product = shop.getProductList().get(UUID.fromString(request));
        JSONObject resultJson = new JSONObject();
        resultJson.put("name", product.getName());
        resultJson.put("price", product.getPrice());
        out.print(resultJson);
    }

}
