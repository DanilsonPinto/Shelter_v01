package com.personalproject.Shelter.controller.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PetReturnResponse {
    private Long id;
    private PetType petType;
    private String name;

}