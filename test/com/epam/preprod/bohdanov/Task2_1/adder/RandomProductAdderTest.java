package com.epam.preprod.bohdanov.Task2_1.adder;

import java.io.InputStream;

import org.apache.commons.io.input.CharSequenceInputStream;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.preprod.bohdanov.Task2_1.printer.ConsolePrinter;

public class RandomProductAdderTest {
    private final static InputStream SYSTEM_IN = System.in;
    private static ProductAdder adder;

    @BeforeClass
    public static void setUp() {
        adder = new RandomProductAdder(new ConsolePrinter());
    }

    @Test
    public void testAddProduct() {
        StringBuilder sb = new StringBuilder();
        sb.append("House").append(System.lineSeparator());
        System.setIn(new CharSequenceInputStream(sb.toString(), "UTF-8"));
        Assert.assertNotNull(adder.addProduct());
        System.setIn(SYSTEM_IN);
    }

    @Test
    public void testAddProductNotExistProductType() {
        StringBuilder sb = new StringBuilder();
        sb.append("FAIL").append(System.lineSeparator());
        sb.append("House").append(System.lineSeparator());
        System.setIn(new CharSequenceInputStream(sb.toString(), "UTF-8"));
        Assert.assertNotNull(adder.addProduct());
        System.setIn(SYSTEM_IN);
    }

}
