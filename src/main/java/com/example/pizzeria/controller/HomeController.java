package com.example.pizzeria.controller;

import com.example.pizzeria.model.Pizza;
import com.example.pizzeria.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller()
public class HomeController {

    private final PizzaService pizzaService;

    @Autowired
    public HomeController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }


    public String goHome(Model model){
        model.addAttribute(String.valueOf(pizzaService.pizzaList()),pizzaService);
        return "index";
    }

}
