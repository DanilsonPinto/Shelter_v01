package com.personalproject.Shelter.repository;

import com.personalproject.Shelter.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository <Pet, Long> {

}
