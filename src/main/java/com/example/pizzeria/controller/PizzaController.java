package com.example.pizzeria.controller;

import com.example.pizzeria.model.Pizza;
import com.example.pizzeria.service.PizzaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PizzaController {
    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }


    @GetMapping("/pizzas")
    public List<Pizza> getAllPizzas(){
       return pizzaService.pizzaList();
    }
}
