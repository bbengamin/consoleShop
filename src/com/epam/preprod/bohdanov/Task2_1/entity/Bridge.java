package com.epam.preprod.bohdanov.Task2_1.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.epam.preprod.bohdanov.Task2_1.annotation.FieldName;

public class Bridge extends Building implements Serializable {
	private static final long serialVersionUID = 3263088105205519147L;

	private Integer length;
	private String type;

	public Bridge() {
		length = 0;
		type = "";
	}

	public Bridge(String name, int year, long price, int length, String type) {
		super(name, year, price);
		this.length = length;
		this.type = type;
	}

	public Integer getLength() {
		return length;
	}

	@FieldName(name = "LENGTH")
	public void setLength(Integer length) {
		this.length = length;
	}

	public String getType() {
		return type;
	}

	@FieldName(name = "TYPE")
	public void setType(String type) {
		this.type = type;
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
		builder.append("Bridge [length=");
		builder.append(length);
		builder.append(", type=");
		builder.append(type);
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
