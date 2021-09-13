package com.example.pizzeria.controller;

import com.example.pizzeria.model.Pizza;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller()
public class HomeController {

    private final PizzaController pizzaController;

    public HomeController(PizzaController pizzaController) {
        this.pizzaController = pizzaController;
    }

    public String goHome(){
        return "index";
    }

    public List<Pizza> getAll(){
       return pizzaController.getAllPizzas();
    }
}
