package com.epam.preprod.bohdanov.Task2_1.repository;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import com.epam.preprod.bohdanov.Task2_1.entity.Building;

public class LastProducts {
	private static final int MAX_ENTRY = 5;

	private LinkedHashMap<UUID, Building> lastProducts;

	/**
	 * Create a new map that contains only five last products
	 */
	public LastProducts() {
		lastProducts = new LinkedHashMap<UUID, Building>(20, 0.75f, true) {
			private static final long serialVersionUID = 3997296777444704967L;

			@Override
			protected boolean removeEldestEntry(Map.Entry eldest) {
				return size() > MAX_ENTRY;
			}
		};
	}

	/**
	 * Add new new product to map
	 * 
	 * @param id
	 *            - product id(key)
	 * @param product
	 *            - value
	 */
	public void put(UUID id, Building product) {
		lastProducts.put(id, product);
	}

	/**
	 * @return - return all values
	 */
	public Collection<Building> getLastProducts() {
		return lastProducts.values();
	}
}
