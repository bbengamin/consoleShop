package com.epam.preprod.bohdanov.Task2_1.repository;

import java.text.ParseException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.preprod.bohdanov.Task2_1.entity.Building;
import com.epam.preprod.bohdanov.Task2_1.entity.House;

public class OrdersTest {
	private Orders<Building> orders;
	private static Cart<Building> cart;

	@BeforeClass
	public static void beforeClass() {
		Building house = new House("Building1", 2001, 15000, 1);
		Building house1 = new House("Building2", 2002, 20000, 2);
		Catalog<Building> catalog = new Catalog<Building>();
		catalog.add(house);
		catalog.add(house1);

		cart = new Cart<Building>(catalog);
		cart.addToCart(house.getId(), 1);
		cart.addToCart(house1.getId(), 2);
	}

	@Before
	public void beforeTest() {
		orders = new Orders<Building>();
	}

	@Test
	public void testMakeOrder() throws ParseException {
		Assert.assertEquals(cart.getTotal(), orders.makeOrder("2015-08-19", cart));
	}

	@Test(expected = ParseException.class)
	public void testMakeOrderExceptionDateEQNULL() throws ParseException {
		orders.makeOrder(null, cart);
	}

	@Test
	public void testGetOrdersByDate() throws ParseException {
		orders.makeOrder("2015-08-19", cart);
		Assert.assertNotNull(orders.getOrdersByDate("2014-08-19", "2016-08-19"));
	}

	@Test(expected = ParseException.class)
	public void testGetOrdersByDateExceptionFromEQNULL() throws ParseException {
		orders.getOrdersByDate(null, "2016-08-19");
	}

	@Test(expected = ParseException.class)
	public void testGetOrdersByDateExceptionToEQNUll() throws ParseException {
		orders.getOrdersByDate("2016-08-19", null);
	}

	@Test
	public void testGetByTheNearestDateIfOrdersContainsOneValueAndDateLeast() throws ParseException {
		orders.makeOrder("2015-08-19", cart);
		Assert.assertEquals(cart, orders.getByTheNearestDate("2016-08-19"));
	}

	@Test
	public void testGetByTheNearestDateIfOrdersContainsOneValueAndDateGreate() throws ParseException {
		orders.makeOrder("2015-08-19", cart);
		Assert.assertEquals(cart, orders.getByTheNearestDate("2014-08-19"));
	}

	@Test
	public void testGetByTheNearestDate() throws ParseException {
		orders.makeOrder("2015-08-19", cart);
		orders.makeOrder("2015-08-05", cart);
		Assert.assertEquals(cart, orders.getByTheNearestDate("2015-08-06"));
	}

	@Test(expected = ParseException.class)
	public void testGetByTheNearestDateExceptionDateEQNull() throws ParseException {
		orders.getByTheNearestDate(null);
	}

}
