package com.personalproject.Shelter.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Shelter {
    @Id
    private Long id;
    private String name;
    private int capacity;
    @OneToMany (mappedBy = "shelterId")
    private List<Pet> pets;
}
