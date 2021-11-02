package com.personalproject.Shelter.service;


import com.personalproject.Shelter.model.Pet;
import com.personalproject.Shelter.repository.PetRepository;
import org.springframework.stereotype.Service;

@Service
public class PetService {
    private final  PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
    public Pet createPet(Pet pet){
        return petRepository.save(pet);
    }

    public Pet getById(long id) {
        return  petRepository.findById(id).get();
    }

    public Pet updateNamePet(long id, String name) {
        Pet pet = petRepository.findById(id).get();
        pet.setName(name);
        return petRepository.save(pet);
    }


}

