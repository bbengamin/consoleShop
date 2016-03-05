package com.epam.preprod.bohdanov.Task2_1.controller;

import static org.mockito.Mockito.mock;

import java.io.File;
import java.text.ParseException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.epam.preprod.bohdanov.Task2_1.adder.ProductAdder;
import com.epam.preprod.bohdanov.Task2_1.adder.RandomProductAdder;
import com.epam.preprod.bohdanov.Task2_1.entity.Building;
import com.epam.preprod.bohdanov.Task2_1.entity.House;
import com.epam.preprod.bohdanov.Task2_1.printer.ConsolePrinter;
import com.epam.preprod.bohdanov.Task2_1.repository.Catalog;

public class ShopTest {
    private Shop shop;
    static private File fileMock = mock(File.class);
    static private final long FILE_SIZE_FOR_MOCK = 2;
    static private final String FILE_NAME_FOR_MOCK = "file.txt";
    private static Catalog<Building> catalog;
    private static ProductAdder adder = mock(ProductAdder.class);

    @BeforeClass
    public static void beforeClass() {
        catalog = new Catalog<Building>();
        catalog.add(new House("Building1", 2001, 15000, 1));
        catalog.add(new House("Building2", 2002, 20000, 2));
        catalog.add(new House("Building3", 2003, 25000, 3));
        catalog.add(new House("Building4", 2004, 30000, 4));
        catalog.add(new House("Building5", 2005, 35000, 5));
        catalog.add(new House("Building6", 2006, 40000, 6));

        Mockito.when(fileMock.getName()).thenReturn(FILE_NAME_FOR_MOCK);
        Mockito.when(fileMock.length()).thenReturn(FILE_SIZE_FOR_MOCK);

        Mockito.when(adder.addProduct()).thenReturn(new House("Building1", 2001, 15000, 1));

    };

    @Before
    public void beforeTest() {

        shop = new Shop(catalog, adder);
    }

    @Test
    public void testGetMenu() {
        Assert.assertNotNull(shop.getMenu());
    }

    @Test
    public void testNewShopWithLoadFromFile() {
        new Shop(new RandomProductAdder(new ConsolePrinter()), "test.cer");
    }

    @Test
    public void testGetProductList() {
        Assert.assertNotNull(shop.getProductList());
    }

    @Test
    public void testGetCart() {
        Assert.assertNotNull(shop.getCart());
    }

    @Test
    public void testAddToCartSuccess() {
        Assert.assertEquals(2, shop.addToCart(1, 2));
    }

    @Test
    public void testSaveCatalog() {
        Assert.assertTrue(shop.saveCatalog("test.cer"));
    }

    @Test
    public void testAddNewProductToCatalog() {
        int expected = shop.getProductList().size() + 1;
        shop.addNewProductToCatalog();
        Assert.assertEquals(expected, shop.getProductList().size());
    }

    @Test
    public void testGetLastProductsIfWasAddedMoreThatFive() {
        shop.addToCart(1, 2);
        shop.addToCart(2, 2);
        shop.addToCart(3, 2);
        shop.addToCart(4, 2);
        shop.addToCart(5, 2);
        shop.addToCart(6, 2);
        Assert.assertNotNull(shop.getLastProducts());
    }

    @Test
    public void testGetLastProducts() {
        shop.addToCart(1, 2);
        shop.addToCart(2, 2);
        shop.addToCart(3, 2);
        Assert.assertNotNull(shop.getLastProducts());
    }

    @Test
    public void testMakeOrder() throws ParseException {
        shop.addToCart(1, 2);
        Assert.assertNotNull(shop.makeOrder("2015-09-19"));
    }

    @Test
    public void testGetOrdersByDate() throws ParseException {
        shop.addToCart(1, 2);
        shop.makeOrder("2015-09-19");
        Assert.assertNotNull(shop.getOrdersByDate("2015-09-19", "2015-09-19"));
    }

    @Test
    public void testGetByTheNearestDate() throws ParseException {
        shop.addToCart(1, 2);
        shop.makeOrder("2015-09-19");
        Assert.assertNotNull(shop.getByTheNearestDate("2015-09-19"));
    }
}
