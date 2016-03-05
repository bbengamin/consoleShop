package com.epam.preprod.bohdanov.Task2_1.repository;

import java.io.InputStream;

import org.apache.commons.io.input.CharSequenceInputStream;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.epam.preprod.bohdanov.Task2_1.adder.ProductAdder;
import com.epam.preprod.bohdanov.Task2_1.adder.RandomProductAdder;
import com.epam.preprod.bohdanov.Task2_1.entity.Building;
import com.epam.preprod.bohdanov.Task2_1.printer.ConsolePrinter;

public class LastProductsTest {
	private LastProducts products;
	private final static InputStream SYSTEM_IN = System.in;

	@Before
	public void beforeTest() {
		products = new LastProducts();
	}

	@Test
	public void testPut() {
        ProductAdder adder = new RandomProductAdder(new ConsolePrinter());
		StringBuilder sb = new StringBuilder();
		sb.append("House").append(System.lineSeparator());
		System.setIn(new CharSequenceInputStream(sb.toString(), "UTF-8"));
		Building house = adder.addProduct();
		System.setIn(SYSTEM_IN);
		products.put(house.getId(), house);
		Assert.assertEquals(1, products.getLastProducts().size());
	}

	@Test
	public void testPutMoreThanFive() {
		ProductAdder adder = new RandomProductAdder(new ConsolePrinter());

		for (int i = 0; i < 10; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append("House").append(System.lineSeparator());
			System.setIn(new CharSequenceInputStream(sb.toString(), "UTF-8"));
			Building house = adder.addProduct();
			products.put(house.getId(), house);
		}
		System.setIn(SYSTEM_IN);
		Assert.assertEquals(5, products.getLastProducts().size());
	}
}
