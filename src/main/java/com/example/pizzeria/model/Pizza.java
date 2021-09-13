package com.example.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name = "pizza")
public class Pizza extends Product {

    @Column(name = "sauce")
    private String sauce;

    public Pizza() {
    }

    public Pizza(String sauce) {
        this.sauce = sauce;
    }

    public Pizza(Long id, String name, ProductSize productSize, String description, BigInteger cost, String sauce) {
        super(id, name, productSize, description, cost);
        this.sauce = sauce;
    }
}
