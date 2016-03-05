package com.epam.preprod.bohdanov.Task2_1.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

import com.epam.preprod.bohdanov.Task2_1.entity.Building;

/**
 * Orders container
 *
 * @param <E>
 *            - a type of product
 */
public class Orders<E extends Building> {
	private NavigableMap<Date, Cart<E>> map;
	private SimpleDateFormat df;

	/**
	 * Create a empty order list
	 * 
	 */
	public Orders() {
		map = new TreeMap<Date, Cart<E>>();
		df = new SimpleDateFormat("yyyy-MM-dd");
		df.setLenient(false);
	}

	/**
	 * Add new order
	 * 
	 * @param date
	 *            - the date when the order was made
	 * @param cart
	 *            - product list
	 * @return - a total cost of order
	 * @throws ParseException
	 *             when a bad date String
	 */
	public Long makeOrder(String date, Cart<E> cart) throws ParseException {
		if (date == null) {
			throw new ParseException("Null data", 0);
		}
		String dateString = date;
		dateString = dateString.trim();

		Date temp = df.parse(dateString);

		map.put(temp, cart);
		return cart.getTotal();
	}

	/**
	 * Return list of orders witch was create in this period
	 * 
	 * @param from
	 *            - date From
	 * @param to
	 *            - date To
	 * @return a map of pairs date and order
	 * @throws ParseException
	 *             when a bad date String
	 */
	public Map<Date, Cart<E>> getOrdersByDate(String from, String to) throws ParseException {
		if (from == null || to == null) {
			throw new ParseException("Null data", 0);
		}
		from = from.trim();
		Date dateFrom = df.parse(from);
		to = to.trim();
		Date dateTo = df.parse(to);

		Map<Date, Cart<E>> result = new TreeMap<Date, Cart<E>>();

		for (Entry<Date, Cart<E>> order : map.subMap(dateFrom, dateTo).entrySet()) {
			result.put(order.getKey(), order.getValue());
		}
		return result;
	}

	/**
	 * Return the order date is closest to the indication
	 * 
	 * @param date
	 *            - date point
	 * @return a list of products that were included in the order
	 * @throws ParseException
	 *             when a bad date String
	 */
	public Cart<E> getByTheNearestDate(String date) throws ParseException {
		if (date == null) {
			throw new ParseException("Null data", 0);
		}
		date = date.trim();
		Date temp = df.parse(date);

		Date leastDate = map.ceilingKey(temp);
		Date greateDate = map.floorKey(temp);
		if (leastDate == null) {
			return map.get(greateDate);
		}
		if (greateDate == null) {
			return map.get(leastDate);
		}
		long least = leastDate.getTime();
		long greate = greateDate.getTime();
		long currentDate = greateDate.getTime();

		if ((currentDate - greate < least - currentDate || least - currentDate < 0) && currentDate - greate > 0) {
			return map.get(greateDate);
		}
		return map.get(leastDate);
	}
}
