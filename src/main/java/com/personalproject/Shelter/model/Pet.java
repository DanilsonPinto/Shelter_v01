package com.personalproject.Shelter.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor

@Entity
public class Pet {

    private String name;
    @Id
    private Long id;
    private String type;
    private Long shelterId;


}
