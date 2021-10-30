package com.personalproject.Shelter.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }
}