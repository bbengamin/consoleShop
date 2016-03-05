package com.epam.preprod.bohdanov.Task2_1.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.epam.preprod.bohdanov.Task2_1.builder.AnnotationBuilder;

/**
 * Use this annotation to mark fields that need to feel using
 * {@link AnnotationBuilder}
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface FieldName {
	String name();
}
