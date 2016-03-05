package com.epam.preprod.bohdanov.Task2_1.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import com.epam.preprod.bohdanov.Task2_1.entity.Building;

/**
 * Contains a map of products and their count
 *
 * @param <E>
 *            - element of cart
 */
public class Cart<E extends Building> {
	private final String LINE_SEPARATOR = System.lineSeparator();
	private Map<UUID, Integer> map;

	private Catalog<E> catalog;

	/**
	 * Create a cart
	 * 
	 * @param catalog
	 *            - list of product that exist in the store
	 */
	public Cart(Catalog<E> catalog) {
		map = new HashMap<UUID, Integer>();
		this.catalog = catalog;
	}

	/**
	 * Put product to cart, if cart contains such product adds their counts
	 * 
	 * @param productId
	 *            - id of product
	 * @param count
	 *            - count of products
	 * @return 0 if (productId == null || count < 1), else return total count of
	 *         product in cart
	 */
	public int addToCart(UUID productId, int count) {
		if (productId == null || count < 1) {
			return 0;
		}

		Integer countInCart = map.get(productId);
		if (countInCart == null) {
			countInCart = count;
		} else {
			countInCart += count;
		}

		map.put(productId, countInCart);
		return countInCart;
	}

	/**
	 * Return total cost of cart
	 * 
	 * @return - total cost of cart
	 */
	public Long getTotal() {
		Long total = 0L;
		if (map.size() == 0) {
			return total;
		}
		for (Entry<UUID, Integer> product : map.entrySet()) {
			total += catalog.get(product.getKey()).getPrice() * product.getValue();
		}
		return total;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Entry<UUID, Integer> product : map.entrySet()) {
			builder.append(catalog.get(product.getKey())).append(" - ");
			builder.append(product.getValue()).append(LINE_SEPARATOR);
		}

		return builder.toString();
	}

}
