package com.example.pizzeria.controller;

import com.example.pizzeria.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final PizzaService pizzaService;

    @Autowired
    public HomeController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }


    @GetMapping
    public String goHome(Model model){
        model.addAttribute("something","this is from a controller");
        model.addAttribute("pizzas", pizzaService.pizzaList());
        return "index";
    }


}
