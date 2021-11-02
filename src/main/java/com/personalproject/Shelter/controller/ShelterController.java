package com.personalproject.Shelter.controller;

import com.personalproject.Shelter.model.Shelter;
import com.personalproject.Shelter.service.ShelterService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShelterController {

    private final ShelterService shelterService;

    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    @PostMapping("/shelters")
    public Shelter createShelter(@RequestBody Shelter shelter) {
        return shelterService.createShelter(shelter);


    }

    @GetMapping("/shelters/{id}")
    public Shelter getById(@PathVariable Long id) {
        return shelterService.getById(id);
    }

    @PutMapping("/shelters/{id}")
    public Shelter updateName(@PathVariable Long id, @RequestBody UpdateNomeRequest request) {
        return shelterService.updateName(id, request.getName());

    }

    @PostMapping("/shelters/{shelterId}/pets/{petId}")

    public Shelter addPetToShelter(@PathVariable Long shelterId , @PathVariable Long petId ){
        return shelterService.addPetToShelter(shelterId, petId);

    }

    @DeleteMapping (value = "/shelters/{id}")
    public void deleteShelterById(@PathVariable Long shelterId){
        return shelterService.deleteShelterById(shelterId);
    }
}



