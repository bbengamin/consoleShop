package com.epam.preprod.bohdanov.Task2_1.repository;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.input.CharSequenceInputStream;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.preprod.bohdanov.Task2_1.adder.ProductAdder;
import com.epam.preprod.bohdanov.Task2_1.adder.RandomProductAdder;
import com.epam.preprod.bohdanov.Task2_1.entity.Building;
import com.epam.preprod.bohdanov.Task2_1.entity.House;
import com.epam.preprod.bohdanov.Task2_1.printer.ConsolePrinter;

public class CatalogTest {
    private final static InputStream SYSTEM_IN = System.in;
    private Catalog<Building> catalog;
    private static Building house;
    private static Building house1;

    @BeforeClass
    public static void beforeClass() {
        house = new House("Building1", 2001, 15000, 1);
        house1 = new House("Building1", 2001, 15000, 1);
    }

    @Before
    public void beforeTest() {
        catalog = new Catalog<Building>();
    }

    @Test
    public void testSize() {
        catalog.add(house);
        catalog.add(house1);
        Assert.assertEquals(2, catalog.size());
    }

    @Test
    public void testAdd() {
        catalog.add(house);
        Assert.assertEquals(1, catalog.size());
    }

    @Test
    public void testGetById() {
        catalog.add(house);
        catalog.add(house1);
        Assert.assertEquals(house, catalog.get(house.getId()));
    }

    @Test
    public void testGetByIndex() {
        catalog.add(house);
        catalog.add(house1);
        Assert.assertNotNull(catalog.get(1));
    }

    @Test
    public void testGetAll() {
        List<Building> list = new ArrayList<>(catalog.getAll());
        Assert.assertEquals(catalog.size(), list.size());
    }

    @Test
    public void testToString() {
        catalog.add(house);
        Assert.assertNotNull(catalog.toString());
    }

    @Test
    public void testSaveInGZip() {
        Catalog<Building> temp = new Catalog<Building>();
        ProductAdder adder = new RandomProductAdder(new ConsolePrinter());
        String fileName = "gzip.ser";
        for (int i = 0; i < 100; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("House").append(System.lineSeparator());
            System.setIn(new CharSequenceInputStream(sb.toString(), "UTF-8"));
            temp.add(adder.addProduct());
        }
        System.setIn(SYSTEM_IN);
        temp.serializateCatalogInGZip(fileName);
        File file = new File(fileName);
        Assert.assertTrue(file.length() > 0);
    }

    @Test
    public void testSerializateCatalogNRaz() {
        Catalog<Building> temp = new Catalog<Building>();
        ProductAdder adder = new RandomProductAdder(new ConsolePrinter());
        String fileName = "nraz.ser";
        for (int i = 0; i < 100; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("House").append(System.lineSeparator());
            System.setIn(new CharSequenceInputStream(sb.toString(), "UTF-8"));
            temp.add(adder.addProduct());
        }
        System.setIn(SYSTEM_IN);
        temp.serializateCatalog(fileName, 100);
        File file = new File(fileName);
        Assert.assertTrue(file.length() > 0);
    }

    @Test
    public void testSerializateCatalog() {
        Catalog<Building> temp = new Catalog<Building>();
        ProductAdder adder = new RandomProductAdder(new ConsolePrinter());
        String fileName = "testSer.ser";
        for (int i = 0; i < 100; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("House").append(System.lineSeparator());
            System.setIn(new CharSequenceInputStream(sb.toString(), "UTF-8"));
            temp.add(adder.addProduct());
        }
        System.setIn(SYSTEM_IN);
        temp.serializateCatalog(fileName);
        File file = new File(fileName);
        Assert.assertTrue(file.length() > 0);
    }

    @Test
    public void testDeserializateCatalog() {
        Catalog<Building> temp = new Catalog<Building>();
        ProductAdder adder = new RandomProductAdder(new ConsolePrinter());
        String fileName = "testSer.ser";
        for (int i = 0; i < 100; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("House").append(System.lineSeparator());
            System.setIn(new CharSequenceInputStream(sb.toString(), "UTF-8"));
            temp.add(adder.addProduct());
        }
        System.setIn(SYSTEM_IN);
        temp.serializateCatalog(fileName);
        temp.deserializateCatalog(fileName);
        Assert.assertEquals(100, temp.size());
    }

}
