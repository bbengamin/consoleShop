package com.epam.preprod.bohdanov.Task2_1.repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;

import com.epam.preprod.bohdanov.Task2_1.entity.Building;
import com.google.common.collect.Iterables;

/**
 * Catalog of products
 *
 * @param <E>
 *            - type of product
 */
public class Catalog<E extends Building> {
	private final String LINE_SEPARATOR = System.lineSeparator();

	private Map<UUID, E> map;

	/**
	 * Create a empty catalog
	 */
	public Catalog() {
		map = new HashMap<>();
	}

	/**
	 * Add element to catalog
	 * 
	 * @param element
	 *            - an element to be added
	 */
	public void add(E element) {
		map.put(element.getId(), element);
	}

	/**
	 * Return a element by id
	 * 
	 * @param id
	 *            - a id of element
	 * @return element witch id equals given id
	 */
	public E get(UUID id) {
		return map.get(id);
	}

	/**
	 * Return element by index
	 * 
	 * @param index
	 *            - index element in list
	 * @return a element witch index equals to given
	 */
	public E get(int index) {
		return Iterables.get(map.entrySet(), index).getValue();
	}

	/**
	 * Return all elements of list
	 * 
	 * @return a collection of elements
	 */
	public Collection<E> getAll() {
		return map.values();
	}

	/**
	 * @return count of elements in catalog
	 */
	public int size() {
		return map.size();
	}

	/**
	 * Serialized catalog to file
	 * 
	 * @param fileName
	 *            - name of file
	 * @return - true if everything is alright, otherwise false
	 */
	public boolean serializateCatalog(String fileName) {
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(map);
			out.close();
			fileOut.close();
			return true;
		} catch (IOException i) {
			return false;
		}
	}

	/**
	 * Serialized catalog to file using GZip
	 * 
	 * @param fileName
	 *            - name of file
	 * @return - true if everything is alright, otherwise false
	 */
	public boolean serializateCatalogInGZip(String fileName) {
		FileOutputStream fileOut = null;
		GZIPOutputStream gzipOut = null;
		ObjectOutputStream out = null;
		try {
			fileOut = new FileOutputStream(fileName);
			gzipOut = new GZIPOutputStream(fileOut);
			out = new ObjectOutputStream(gzipOut);

			out.writeObject(map);
			out.flush();
			out.close();
			gzipOut.close();
			fileOut.close();
			return true;
		} catch (IOException i) {
			return false;
		}
	}

	/**
	 * Serialized catalog to file(catalog will been written n-counts)
	 * 
	 * @param fileName
	 *            - name of file
	 * @param count
	 *            - count of iterations
	 * @return - true if everything is alright, otherwise false
	 */
	public boolean serializateCatalog(String fileName, int count) {
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			for (int i = 0; i < count; i++) {
				out.writeObject(map);
			}
			out.close();
			fileOut.close();
			return true;
		} catch (IOException i) {
			return false;
		}
	}

	/**
	 * Deserialized catalog from file
	 * 
	 * @param fileName
	 *            - name of file
	 * @return - true if everything is alright, otherwise false
	 */
	@SuppressWarnings("unchecked")
	public boolean deserializateCatalog(String fileName) {
		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			map = (Map<UUID, E>) in.readObject();
			in.close();
			fileIn.close();
			return true;
		} catch (IOException | ClassNotFoundException i) {
			return false;
		}

	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		int iterator = 1;
		for (Entry<UUID, E> product : map.entrySet()) {
			sb.append(iterator + " - ").append(product.getValue()).append(LINE_SEPARATOR);
			iterator++;
		}
		return sb.toString();
	}
}
