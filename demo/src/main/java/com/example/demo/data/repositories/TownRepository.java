package com.example.demo.data.repositories;

import com.example.demo.data.models.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {
    Optional<Town> findByNameAndCountryName(String name, String countryName);

    Optional<Town> findById(long id);
}
