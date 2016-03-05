package com.epam.preprod.bohdanov.Task2_1.builder;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.preprod.bohdanov.Task2_1.entity.Building;
import com.epam.preprod.bohdanov.Task2_1.printer.ConsolePrinter;

public class HouseBuilderTest {
	private static StringBuffer sb = null;
	private static HouseBuilder builder = null;

	@BeforeClass
	public static void setUp() {
		builder = new HouseBuilder(new ConsolePrinter());
		sb = new StringBuffer();

		sb.append("House1").append(System.lineSeparator());
		sb.append("159").append(System.lineSeparator());
		sb.append("50000").append(System.lineSeparator());
		sb.append("5").append(System.lineSeparator());
	}

	@Test
	public void testGetInstanceFromStream() {
		Building house = builder.getInstanceFromStream(new Scanner(sb.toString()));
		Assert.assertNotNull(house);
	}

	@Test
	public void testGetInstanceRandom() {
		Building house = builder.getInstanceUsingRandom();
		Assert.assertNotNull(house);
	}
}
