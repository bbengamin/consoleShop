package com.epam.preprod.bohdanov.Task2_1.builder;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.preprod.bohdanov.Task2_1.entity.Building;
import com.epam.preprod.bohdanov.Task2_1.printer.ConsolePrinter;

public class BridgeBuilderTest {
    private static StringBuffer sb = null;
    private static BridgeBuilder builder = null;

    @BeforeClass
    public static void setUp() {
        builder = new BridgeBuilder(new ConsolePrinter());
        sb = new StringBuffer();

        sb.append("Bridge1").append(System.lineSeparator());
        sb.append("159").append(System.lineSeparator());
        sb.append("50000").append(System.lineSeparator());
        sb.append("500").append(System.lineSeparator());
        sb.append("type").append(System.lineSeparator());
    }

    @Test
    public void testGetInstanceFromStream() {
        Building bridge = builder.getInstanceFromStream(new Scanner(sb.toString()));
        Assert.assertNotNull(bridge);
    }

    @Test
    public void testGetInstanceRandom() {
        Building bridge = builder.getInstanceUsingRandom();
        Assert.assertNotNull(bridge);
    }
}
