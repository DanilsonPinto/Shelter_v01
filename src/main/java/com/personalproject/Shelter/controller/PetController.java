package com.personalproject.Shelter.controller;

import com.personalproject.Shelter.model.Pet;
import com.personalproject.Shelter.service.PetService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PetController {
    private final PetService petService;


    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping("/peters")
    public Pet createPet(@RequestBody Pet pet){
        return petService.createPet(pet);
    }

    @GetMapping("/pets/{id}")
    public Pet getById(@PathVariable long id){
        return petService.getById(id);
    }

    @PutMapping("/pets/{id}")
    public Pet updateNamePet(@PathVariable long id, @RequestBody UpdatedRequestPet request){
        return petService.updateNamePet(id,request.getName());
    }


}
