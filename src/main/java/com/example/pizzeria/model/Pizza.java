package com.example.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pizza")
public class Pizza extends Product {

    @Column(name = "sauce")
    private String sauce;

    public Pizza() {
    }

    public Pizza(String name, ProductSize productSize, String description, Integer cost, String sauce) {
        super(name, productSize, description, cost);
        this.sauce = sauce;
    }

}
