package com.epam.preprod.bohdanov.Task2_1.builder;

import java.util.HashMap;
import java.util.Map;

import com.epam.preprod.bohdanov.Task2_1.printer.Printer;

public class BuilderContainer {
    private Map<String, BuildingBuilder> map;

    public BuilderContainer(Printer out) {
        map = new HashMap<String, BuildingBuilder>();
        map.put("House", new HouseBuilder(out));
        map.put("Bridge", new BridgeBuilder(out));
        map.put("Skyscraper", new SkyscraperBuilder(out));
    }

    public BuildingBuilder getBuilder(String key) {
        BuildingBuilder command = map.get(key);
        return command;
    }

    public Map<String, BuildingBuilder> getMap() {
        return map;
    }

}
