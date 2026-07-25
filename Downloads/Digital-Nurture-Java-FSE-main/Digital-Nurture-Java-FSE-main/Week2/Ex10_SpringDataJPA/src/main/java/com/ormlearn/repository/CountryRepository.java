package com.ormlearn.repository;

import com.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Find countries whose name contains a partial string (case-insensitive)
    List<Country> findByNameContainingIgnoreCase(String partialName);
}
