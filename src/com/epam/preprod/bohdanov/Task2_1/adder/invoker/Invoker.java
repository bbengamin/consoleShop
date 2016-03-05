package com.epam.preprod.bohdanov.Task2_1.adder.invoker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public interface Invoker {
	/**
	 * Call method on target with param value
	 * 
	 * @param method
	 *            - a method what need to invoke
	 * @param target
	 *            - the object on which to invoke a method
	 * @param value
	 *            - a parameter to calling method
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public void call(Method method, Object target, String value)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
