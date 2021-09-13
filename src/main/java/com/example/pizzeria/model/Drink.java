package com.example.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name = "drink")
public class Drink extends Product {

    public Drink() {
    }

    public Drink(Long id, String name, ProductSize productSize, String description, BigInteger cost) {
        super(id, name, productSize, description, cost);
    }

}
