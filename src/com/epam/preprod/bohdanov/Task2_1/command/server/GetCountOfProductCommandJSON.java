package com.epam.preprod.bohdanov.Task2_1.command.server;

import org.json.JSONObject;

import com.epam.preprod.bohdanov.Task2_1.controller.Shop;
import com.epam.preprod.bohdanov.Task2_1.printer.Printer;

public class GetCountOfProductCommandJSON extends Command {

    public GetCountOfProductCommandJSON(Printer out) {
        super(out);
    }

    @Override
    public void execute(Shop shop, String request) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("count", shop.getProductList().size());
        out.print(resultJson);
    }
}
