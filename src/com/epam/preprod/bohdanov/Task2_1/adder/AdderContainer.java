package com.epam.preprod.bohdanov.Task2_1.adder;

import java.util.HashMap;
import java.util.Map;

import com.epam.preprod.bohdanov.Task2_1.printer.Printer;

/**
 * Container for product adders
 */
public class AdderContainer {
    private static Map<String, ProductAdder> map;

    public AdderContainer(Printer out) {
        map = new HashMap<String, ProductAdder>();
        map.put("m", new CustomProductAdder(out));
        map.put("r", new RandomProductAdder(out));
        map.put("ma", new CustomWithAnnotaionProductAdder(out));
        map.put("ra", new RandomWithAnnotationProductAdder(out));
    }

    public ProductAdder getAdder(String key) {
        ProductAdder adder = map.get(key);
        return adder;
    }

    public Map<String, ProductAdder> getMap() {
        return map;
    }
}