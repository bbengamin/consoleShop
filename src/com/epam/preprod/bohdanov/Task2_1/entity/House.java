package com.epam.preprod.bohdanov.Task2_1.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.epam.preprod.bohdanov.Task2_1.annotation.FieldName;

public class House extends Building {
    private static final long serialVersionUID = 2217895334826260207L;
    private Integer levels;

    public House() {
        levels = 0;
    }

    public House(String name, int year, long price, int levels) {
        super(name, year, price);
        this.levels = levels;
    }

    public Integer getLevels() {
        return levels;
    }

    @FieldName(name = "COUNT_OF_LEVELS")
    public void setLevels(Integer levels) {
        this.levels = levels;
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
        builder.append("House [Levels=");
        builder.append(levels);
        builder.append(", ID=");
        builder.append(getId());
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
