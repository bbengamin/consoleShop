package com.epam.preprod.bohdanov.Task2_1.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.epam.preprod.bohdanov.Task2_1.annotation.FieldName;

public class Skyscraper extends House {
	private static final long serialVersionUID = -8876115957513699679L;
	private Boolean parking;
	private Boolean heliport;

	public Skyscraper() {
		parking = false;
		heliport = false;
	}

	public Skyscraper(String name, int year, long price, int levels, boolean parking, boolean heliport) {
		super(name, year, price, levels);
		this.parking = parking;
		this.heliport = heliport;
	}

	public Boolean isParking() {
		return parking;
	}

	@FieldName(name = "PARKING")
	public void setParking(Boolean parking) {
		this.parking = parking;
	}

	public Boolean isHeliport() {
		return heliport;
	}

	@FieldName(name = "HELIPORT")
	public void setHeliport(Boolean heliport) {
		this.heliport = heliport;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Skyscraper [parking=");
		builder.append(parking);
		builder.append(", heliport=");
		builder.append(heliport);
		builder.append(", Levels=");
		builder.append(getLevels());
		builder.append(", Name=");
		builder.append(getName());
		builder.append(", Year=");
		builder.append(getYear());
		builder.append(", Price=");
		builder.append(getPrice());
		builder.append("]");
		return builder.toString();
	}
}
