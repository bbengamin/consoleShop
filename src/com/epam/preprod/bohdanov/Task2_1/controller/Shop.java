package com.epam.preprod.bohdanov.Task2_1.controller;

import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import com.epam.preprod.bohdanov.Task2_1.adder.ProductAdder;
import com.epam.preprod.bohdanov.Task2_1.entity.Building;
import com.epam.preprod.bohdanov.Task2_1.repository.Cart;
import com.epam.preprod.bohdanov.Task2_1.repository.Catalog;
import com.epam.preprod.bohdanov.Task2_1.repository.LastProducts;
import com.epam.preprod.bohdanov.Task2_1.repository.Orders;

public class Shop {
    private Catalog<Building> catalog;
    private Cart<Building> cart;
    private LastProducts lastProducts;
    private Orders<Building> orders;
    private final ProductAdder adder;

    private final String LINE_SEPARATOR = System.lineSeparator();

    /**
     * Create a new shop
     * 
     * @param adder
     *            - a way of adding new products
     * @param fileName
     *            - name of file to load catalog
     */
    public Shop(ProductAdder adder, String fileName) {
        this.adder = adder;
        this.catalog = new Catalog<Building>();
        loadCatalog(fileName);
        cart = new Cart<Building>(catalog);
        lastProducts = new LastProducts();
        orders = new Orders<Building>();
    }

    /**
     * Create a new shop
     * 
     * @param catalog
     *            - list of products
     * @param adder
     *            - a way of adding new products
     */
    public Shop(Catalog<Building> catalog, ProductAdder adder) {
        this.adder = adder;
        this.catalog = catalog;
        cart = new Cart<Building>(catalog);
        lastProducts = new LastProducts();
        orders = new Orders<Building>();
    }

    /**
     * Return a list of available commands
     * 
     * @return - string with available commands
     */
    public String getMenu() {
        StringBuilder builder = new StringBuilder();
        builder.append("Shop menu:").append(LINE_SEPARATOR);
        builder.append("1. Get product list").append(LINE_SEPARATOR);
        builder.append("2. Add product to cart").append(LINE_SEPARATOR);
        builder.append("3. Get cart").append(LINE_SEPARATOR);
        builder.append("4. Make order").append(LINE_SEPARATOR);
        builder.append("5. Get 5 last produtcs in cart").append(LINE_SEPARATOR);
        builder.append("6. Get order for a predetermined time period").append(LINE_SEPARATOR);
        builder.append("7. Get order on the nearest date").append(LINE_SEPARATOR);
        builder.append("8. Add new product to catalog").append(LINE_SEPARATOR);
        builder.append("0. Exit").append(LINE_SEPARATOR);
        return builder.toString();
    }

    /**
     * @return a list of products in catalog
     */
    public Catalog<Building> getProductList() {
        return catalog;
    }

    /**
     * @return - return a current state of cart
     */
    public Cart<Building> getCart() {
        return cart;
    }

    /**
     * Make order
     * 
     * @param date
     *            - date when order was make
     * @return - a total cost of order
     * @throws ParseException
     *             - whaen bad data
     */
    public Long makeOrder(String date) throws ParseException {
        Long total = orders.makeOrder(date, cart);
        cart = new Cart<Building>(catalog);
        return total;
    }

    /**
     * Add product to cart
     * 
     * @param index
     *            - index of product in catalog
     * @param count
     *            - count of product
     * @return count of added products
     */
    public int addToCart(int index, int count) {
        Building temp = catalog.get(index - 1);
        lastProducts.put(temp.getId(), temp);
        return cart.addToCart(temp.getId(), count);
    }

    /**
     * @return return five last products that was added to cart
     */
    public Collection<Building> getLastProducts() {
        return lastProducts.getLastProducts();
    }

    /**
     * Return orders that was make in this period
     * 
     * @param from
     *            - from period
     * @param to
     *            - to period
     * @return list of products
     * @throws ParseException
     *             - when invalid date
     */
    public Map<Date, Cart<Building>> getOrdersByDate(String from, String to) throws ParseException {
        return orders.getOrdersByDate(from, to);
    }

    /**
     * Return a nearest order to this date
     * 
     * @param date
     *            - date to find
     * @return - order that more nearest to entered date
     * @throws ParseException
     *             - when invalid date
     */
    public Cart<Building> getByTheNearestDate(String date) throws ParseException {
        return orders.getByTheNearestDate(date);
    }

    /**
     * Save catalog to file
     * 
     * @param fileName
     *            - name of file
     * @return
     */
    public boolean saveCatalog(String fileName) {
        return catalog.serializateCatalog(fileName);
    }

    /**
     * Load catalog from file
     * 
     * @param fileName
     *            - name of file
     * @return
     */
    public boolean loadCatalog(String fileName) {
        return catalog.deserializateCatalog(fileName);
    }

    /**
     * Adding new product to catalog using a {@link ProductAdder}
     */
    public void addNewProductToCatalog() {
        catalog.add(adder.addProduct());
    }

}
