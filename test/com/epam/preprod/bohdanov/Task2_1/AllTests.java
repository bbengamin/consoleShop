package com.epam.preprod.bohdanov.Task2_1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.epam.preprod.bohdanov.Task2_1.adder.CustomProductAdderTest;
import com.epam.preprod.bohdanov.Task2_1.adder.CustomWithAnnotationProductAdderTest;
import com.epam.preprod.bohdanov.Task2_1.adder.RandomProductAdderTest;
import com.epam.preprod.bohdanov.Task2_1.adder.RandomWithAnnotationProductAdderTest;
import com.epam.preprod.bohdanov.Task2_1.builder.AnnotationBuilderTest;
import com.epam.preprod.bohdanov.Task2_1.builder.BridgeBuilderTest;
import com.epam.preprod.bohdanov.Task2_1.builder.HouseBuilderTest;
import com.epam.preprod.bohdanov.Task2_1.builder.SkyscraperBuilderTest;
import com.epam.preprod.bohdanov.Task2_1.controller.ShopTest;
import com.epam.preprod.bohdanov.Task2_1.repository.CartTest;
import com.epam.preprod.bohdanov.Task2_1.repository.CatalogTest;
import com.epam.preprod.bohdanov.Task2_1.repository.LastProductsTest;
import com.epam.preprod.bohdanov.Task2_1.repository.OrdersTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ CustomProductAdderTest.class, RandomProductAdderTest.class, BridgeBuilderTest.class,
		HouseBuilderTest.class, SkyscraperBuilderTest.class, ShopTest.class, CartTest.class, LastProductsTest.class,
		CatalogTest.class, OrdersTest.class, AnnotationBuilderTest.class, CustomWithAnnotationProductAdderTest.class,
		RandomWithAnnotationProductAdderTest.class })
public class AllTests {
}