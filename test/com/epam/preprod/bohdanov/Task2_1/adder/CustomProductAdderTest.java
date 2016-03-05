package com.epam.preprod.bohdanov.Task2_1.adder;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.input.CharSequenceInputStream;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.epam.preprod.bohdanov.Task2_1.adder.CustomProductAdder;
import com.epam.preprod.bohdanov.Task2_1.adder.ProductAdder;
import com.epam.preprod.bohdanov.Task2_1.builder.BuilderContainer;
import com.epam.preprod.bohdanov.Task2_1.builder.BuildingBuilder;
import com.epam.preprod.bohdanov.Task2_1.builder.HouseBuilder;
import com.epam.preprod.bohdanov.Task2_1.entity.Building;
import com.epam.preprod.bohdanov.Task2_1.entity.House;
import com.epam.preprod.bohdanov.Task2_1.printer.ConsolePrinter;

public class CustomProductAdderTest {
    private static ProductAdder adder;
    private final static InputStream SYSTEM_IN = System.in;
    private static Building expectedHouse;
    private static HouseBuilder mockHouseBuilder;
    private static BuilderContainer container;
    private static Map<String, BuildingBuilder> mapBackUp;

    @BeforeClass
    public static void setUp() {
        container = new BuilderContainer(new ConsolePrinter());
        mapBackUp = container.getMap();
        adder = new CustomProductAdder(new ConsolePrinter());
        container = new BuilderContainer(new ConsolePrinter());
        expectedHouse = new House("House1", 2015, 5000, 5);
        mockHouseBuilder = Mockito.mock(HouseBuilder.class);
        Mockito.when(mockHouseBuilder.getInstanceFromStream(Mockito.anyObject())).thenReturn(expectedHouse);
        Map<String, BuildingBuilder> mockedMap = new HashMap<String, BuildingBuilder>();
        mockedMap.put("House", mockHouseBuilder);
        try {
            FieldUtils.writeStaticField(container.getClass(), "map", mockedMap, true);
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }
    }

    @AfterClass
    public static void shutDown() {
        try {
            FieldUtils.writeStaticField(container.getClass(), "map", mapBackUp, true);
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }
    }

    @Test
    public void addProduct() {
        StringBuilder sb = new StringBuilder();
        sb.append("House").append(System.lineSeparator());
        System.setIn(new CharSequenceInputStream(sb.toString(), "UTF-8"));
        Assert.assertEquals(expectedHouse, adder.addProduct());
        System.setIn(SYSTEM_IN);
    }

    @Test
    public void addProductNotExistProductType() {
        StringBuilder sb = new StringBuilder();
        sb.append("FAIl").append(System.lineSeparator());
        sb.append("House").append(System.lineSeparator());
        System.setIn(new CharSequenceInputStream(sb.toString(), "UTF-8"));
        Assert.assertEquals(expectedHouse, adder.addProduct());
        System.setIn(SYSTEM_IN);
    }
}
