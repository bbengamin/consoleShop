package com.epam.preprod.bohdanov.Task2_1.builder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.epam.preprod.bohdanov.Task2_1.adder.invoker.Invoker;
import com.epam.preprod.bohdanov.Task2_1.adder.invoker.InvokerContainer;
import com.epam.preprod.bohdanov.Task2_1.annotation.FieldName;
import com.epam.preprod.bohdanov.Task2_1.builder.generator.RandomGenerator;
import com.epam.preprod.bohdanov.Task2_1.entity.Bridge;
import com.epam.preprod.bohdanov.Task2_1.entity.Building;
import com.epam.preprod.bohdanov.Task2_1.entity.House;
import com.epam.preprod.bohdanov.Task2_1.entity.Skyscraper;
import com.epam.preprod.bohdanov.Task2_1.printer.Printer;

/**
 * Create a new Building using annotation on setters
 */
public class AnnotationBuilder extends BuildingBuilder {

    private static final String BUNDLE_NAME = "resources";
    private String buildingName;
    private boolean randomFilling;
    private Scanner scanner;
    private Locale locale;
    ResourceBundle bundle;
    private Map<String, Class<? extends Building>> entitys;

    public AnnotationBuilder(String buildingName, Locale locale, Printer out) {
        super(out);
        this.buildingName = buildingName;
        this.locale = locale;
        randomFilling = false;
        scanner = new Scanner(System.in);
        this.out = out;
        initMap();
    }

    private void initMap() {
        entitys = new HashMap<String, Class<? extends Building>>();
        entitys.put("House", House.class);
        entitys.put("Bridge", Bridge.class);
        entitys.put("Skyscraper", Skyscraper.class);
    }

    @Override
    public Building getInstanceFromStream(Scanner scanner) {
        this.scanner = scanner;
        return generateBuilding();
    }

    @Override
    public Building getInstanceUsingRandom() {
        randomFilling = true;
        return generateBuilding();
    }

    private Building generateBuilding() {
        bundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
        Class<? extends Building> buildingClass = entitys.get(buildingName);
        Building building = createInstanseOfBuilding(buildingClass);
        fillFieldsOfBuilding(building, buildingClass);
        return building;
    }

    private Building createInstanseOfBuilding(Class<? extends Building> buildingClass) {
        try {
            return buildingClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            return null;
        }
    }

    private void fillFieldsOfBuilding(Object building, Class<? extends Building> buildingClass) {
        Method[] methods = buildingClass.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(FieldName.class)) {
                printMethodMessage(method);
                invokeSetter(method, building);
            }
        }
    }

    private void printMethodMessage(Method method) {
        String fieldName = method.getAnnotation(FieldName.class).name();
        out.print(bundle.getString(fieldName));
    }

    private void invokeSetter(Method method, Object building) {
        Invoker caller = InvokerContainer.getInvoker(method.getParameterTypes()[0]);
        try {
            caller.call(method, building, getFillingDataForMethod(method));
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private String getFillingDataForMethod(Method method) {
        String value = randomFilling ? getRandomFilling(method) : scanner.next();
        if (randomFilling) {
            out.print(value);
        }
        return value;
    }

    private String getRandomFilling(Method method) {
        if (method.getParameterTypes()[0].equals(String.class)) {
            return RandomGenerator.getRandomWithPrefix(method.getName());
        } else if (method.getParameterTypes()[0].equals(Boolean.class)) {
            return RandomGenerator.getRandomBoolean().toString();
        } else {
            return RandomGenerator.getRandomValue().toString();
        }
    }
}
