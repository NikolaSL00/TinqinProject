package com.example.demo.data.models.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "countries")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "country")
//    private Set<Town> towns;

//    public void addTown(Town town){
//        this.towns.add(town);
//    }
//    public void removeTown(Town town){
//        this.towns.remove(town);
//    }
}
