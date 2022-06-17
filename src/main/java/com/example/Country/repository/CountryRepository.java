package com.example.Country.repository;

import com.example.Country.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findCountryByName(String name);
    @Query("SELECT 'name' from country WHERE name LIKE CONCAT('%',:query,'%')")
    List<Country> searchByName(String query);

}
