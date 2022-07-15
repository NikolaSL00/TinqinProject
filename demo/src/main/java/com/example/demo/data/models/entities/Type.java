package com.example.demo.data.models.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String label;

//    @OneToMany(mappedBy = "type", fetch = FetchType.EAGER)
//    private Set<Town> towns;
//
//    public void addTown(Town town){
//        this.towns.add(town);
//    }
//    public void removeTown(Town town){
//        this.towns.remove(town);
//    }
}
