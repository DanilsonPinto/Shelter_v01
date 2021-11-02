package com.personalproject.Shelter.service;

import com.personalproject.Shelter.model.Pet;
import com.personalproject.Shelter.model.Shelter;
import com.personalproject.Shelter.repository.PetRepository;
import com.personalproject.Shelter.repository.ShelterRepository;
import org.springframework.stereotype.Service;

@Service
public class ShelterService {
    private final ShelterRepository shelterRepository;
    private final PetRepository petRepository;

    public ShelterService(ShelterRepository shelterRepository, PetRepository petRepository) {
        this.shelterRepository = shelterRepository;
        this.petRepository = petRepository;
    }

    public Shelter createShelter(Shelter shelter) {
        return shelterRepository.save(shelter);

    }

    public Shelter getById(Long id) {
        return shelterRepository.findById(id).get();

    }

    public void updateShelter(Long id) {
    }

    public Shelter updateName(Long id, String  nome) {
        Shelter shelter = shelterRepository.findById(id).get();
        shelter.setName(nome);
        return shelterRepository.save(shelter);
    }

    public Shelter addPetToShelter(Long shelterId, Long petId) {
        Shelter shelter = shelterRepository.findById(shelterId).get();
        Pet pet = petRepository.findById(petId).get();
        pet.setShelterId(shelterId);
        shelter.getPets().add(pet);
        petRepository.save(pet);
        return shelterRepository.save(shelter);
    }

    public void deleteShelterById(Long shelterId) {

    }
}
