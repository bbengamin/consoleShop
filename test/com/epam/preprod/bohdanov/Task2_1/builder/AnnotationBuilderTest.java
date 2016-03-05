package com.epam.preprod.bohdanov.Task2_1.builder;

import java.util.Locale;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.preprod.bohdanov.Task2_1.entity.Building;
import com.epam.preprod.bohdanov.Task2_1.printer.ConsolePrinter;

public class AnnotationBuilderTest {
    private static AnnotationBuilder builder;

    @BeforeClass
    public static void setUp() {
        builder = new AnnotationBuilder("Skyscraper", new Locale("ru", "RU"), new ConsolePrinter());
    }

    @Test
    public void testGetInstanceFromStream() {
        StringBuffer sb = new StringBuffer();
        sb.append("ä").append(System.lineSeparator());
        sb.append("ä").append(System.lineSeparator());
        sb.append("5").append(System.lineSeparator());
        sb.append("Skyscraper1").append(System.lineSeparator());
        sb.append("2015").append(System.lineSeparator());
        sb.append("50000").append(System.lineSeparator());
        Building skyscraper = builder.getInstanceFromStream(new Scanner(sb.toString()));
        Assert.assertNotNull(skyscraper);
    }

    @Test
    public void testGetInstanceFromStreamWithOutParkingAndHeliport() {
        StringBuffer sb = new StringBuffer();
        sb.append("í").append(System.lineSeparator());
        sb.append("í").append(System.lineSeparator());
        sb.append("5").append(System.lineSeparator());
        sb.append("Skyscraper1").append(System.lineSeparator());
        sb.append("2015").append(System.lineSeparator());
        sb.append("50000").append(System.lineSeparator());
        Building skyscraper = builder.getInstanceFromStream(new Scanner(sb.toString()));
        Assert.assertNotNull(skyscraper);
    }

    @Test
    public void testGetInstanceRandom() {
        Building skyscraper = builder.getInstanceUsingRandom();
        Assert.assertNotNull(skyscraper);
    }
}
