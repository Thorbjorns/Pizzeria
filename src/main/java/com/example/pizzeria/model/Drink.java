package com.example.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "drink")
public class Drink extends Product {

    public Drink() {
    }

    public Drink(String name, ProductSize productSize, String description, Integer cost) {
        super(name, productSize, description, cost);
    }
}
