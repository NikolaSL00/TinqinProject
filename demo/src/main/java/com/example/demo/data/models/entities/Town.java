package com.example.demo.data.models.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "towns")
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @ManyToOne
    private Country country;

    @ManyToOne
    private Type type;
}
