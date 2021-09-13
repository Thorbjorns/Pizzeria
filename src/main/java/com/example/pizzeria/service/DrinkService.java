package com.example.pizzeria.service;

import com.example.pizzeria.model.Drink;
import com.example.pizzeria.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkService {
    private final DrinkRepository drinkRepository;

    @Autowired
    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public Drink findDrinkById(Long id){
     return drinkRepository.findById(id).orElseThrow(null);
    }

    public List<Drink> findAllDrinks(){
        return drinkRepository.findAll();
    }

    public void addDrink(Drink drink){
        drinkRepository.save(drink);
    }

    public void deleteDrinkById(Long id){
        drinkRepository.deleteById(id);
    }
}
