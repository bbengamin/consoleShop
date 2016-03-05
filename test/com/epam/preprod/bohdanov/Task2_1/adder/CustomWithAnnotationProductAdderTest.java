package com.epam.preprod.bohdanov.Task2_1.adder;

import java.io.InputStream;

import org.apache.commons.io.input.CharSequenceInputStream;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.preprod.bohdanov.Task2_1.printer.ConsolePrinter;

public class CustomWithAnnotationProductAdderTest {
    private static ProductAdder adder;
    private final static InputStream SYSTEM_IN = System.in;

    @BeforeClass
    public static void setUp() {
        adder = new CustomWithAnnotaionProductAdder(new ConsolePrinter());
    }

    @Test
    public void addProduct() {
        StringBuffer sb = new StringBuffer();
        sb.append("House").append(System.lineSeparator());
        sb.append("ru").append(System.lineSeparator());
        sb.append("5").append(System.lineSeparator());
        sb.append("House1").append(System.lineSeparator());
        sb.append("159").append(System.lineSeparator());
        sb.append("50000").append(System.lineSeparator());
        System.setIn(new CharSequenceInputStream(sb.toString(), "UTF-8"));
        Assert.assertNotNull(adder.addProduct());
        System.setIn(SYSTEM_IN);
    }

    @Test
    public void addProductNotExistProductType() {
        StringBuilder sb = new StringBuilder();
        sb.append("FAIl").append(System.lineSeparator());
        sb.append("House").append(System.lineSeparator());
        sb.append("ru").append(System.lineSeparator());
        sb.append("5").append(System.lineSeparator());
        sb.append("House1").append(System.lineSeparator());
        sb.append("159").append(System.lineSeparator());
        sb.append("50000").append(System.lineSeparator());
        System.setIn(new CharSequenceInputStream(sb.toString(), "UTF-8"));
        Assert.assertNotNull(adder.addProduct());
        System.setIn(SYSTEM_IN);
    }
}
