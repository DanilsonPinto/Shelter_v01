package com.personalproject.Shelter.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class AdoptionController<PetService> {

    private final PetService petService;

    public AdoptionController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping(value = "/pets")
    public List<Pet> getPets() {
        return petService.findAll();
    }

    @GetMapping(value = "/pets/{id}")
    public Pet getPet(@PathVariable(value = "id") Long petId) {
        return petService.findById(petId);
    }

    @PostMapping(value = "/pets", consumes = "application/json")
    public List<Pet> addPet(@RequestBody @Valid List<CreatePetRQ> createPetRQ) {
        return petService.save(createPetRQ);
    }

    @PostMapping(value = "/pets/feed", consumes = "application/json")
    public Pet addPetFeed(@RequestBody @Valid CreatePetFeedRQ createPetFeedRQ) {
        return petService.addNewPetFeed(createPetFeedRQ);
    }

}
