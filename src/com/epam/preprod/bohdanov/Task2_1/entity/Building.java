package com.epam.preprod.bohdanov.Task2_1.entity;

import java.io.Serializable;
import java.util.UUID;

import com.epam.preprod.bohdanov.Task2_1.annotation.FieldName;

public abstract class Building implements Serializable {
	private static final long serialVersionUID = 6243152602862846119L;
	private UUID id;
	private String name;
	private Integer year;
	private Long price;

	public Building() {
		id = UUID.randomUUID();
		name = "";
		year = 0;
	}

	public Building(String name, int year, long price) {
		id = UUID.randomUUID();
		this.name = name;
		this.year = year;
		this.price = price;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@FieldName(name = "BUILDING_NAME")
	public void setName(String name) {
		this.name = name;
	}

	public Integer getYear() {
		return year;
	}

	@FieldName(name = "BUILDING_YEAR")
	public void setYear(Integer year) {
		this.year = year;
	}

	public Long getPrice() {
		return price;
	}

	@FieldName(name = "BUILDING_PRICE")
	public void setPrice(Long price) {
		this.price = price;
	}
}
