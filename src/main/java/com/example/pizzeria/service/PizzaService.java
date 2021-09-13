package com.example.pizzeria.service;

import com.example.pizzeria.model.Pizza;
import com.example.pizzeria.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public void addPizza(Pizza pizza){
        pizzaRepository.save(pizza);
    }

    public List<Pizza> pizzaList(){
       return pizzaRepository.findAll();
    }

    public Pizza showPizzaById(Long id){
       return pizzaRepository.findById(id).orElseThrow(null);
    }

    public void deletePizza(Long id){
        pizzaRepository.deleteById(id);
    }

}
