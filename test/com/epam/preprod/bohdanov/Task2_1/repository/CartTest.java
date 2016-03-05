package com.epam.preprod.bohdanov.Task2_1.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.preprod.bohdanov.Task2_1.entity.Building;
import com.epam.preprod.bohdanov.Task2_1.entity.House;

public class CartTest {
	private Cart<Building> cart;
	private static Catalog<Building> catalog;
	private static Building house;
	private static Building house1;

	@BeforeClass
	public static void beforeClass() {
		house = new House("Building1", 2001, 15000, 1);
		house1 = new House("Building1", 2001, 15000, 1);
		catalog = new Catalog<Building>();
		catalog.add(house);
		catalog.add(house1);
	}

	@Before
	public void beforeTest() {
		cart = new Cart<Building>(catalog);
	}

	@Test
	public void testAddToCart() {
		Assert.assertEquals(2, cart.addToCart(house.getId(), 2));
	}

	@Test
	public void testAddToCartProductWhichIsAllreadyExistInCart() {
		cart.addToCart(house.getId(), 2);
		Assert.assertEquals(4, cart.addToCart(house.getId(), 2));
	}

	@Test
	public void testAddToCartWithNullProductId() {
		Assert.assertEquals(0, cart.addToCart(null, 2));
	}

	@Test
	public void testAddToCartWithCountLessOne() {
		Assert.assertEquals(0, cart.addToCart(house.getId(), 0));
	}

	@Test
	public void testGetTotal() {
		Long expected = house1.getPrice() + house.getPrice();
		cart.addToCart(house.getId(), 1);
		cart.addToCart(house1.getId(), 1);
		Assert.assertEquals(expected, cart.getTotal());
	}

	@Test
	public void testGetTotalEmptyCart() {
		Assert.assertEquals(new Long(0), cart.getTotal());
	}

	@Test
	public void testToString() {
		cart.addToCart(house.getId(), 2);
		Assert.assertNotNull(cart.toString());
	}
}
