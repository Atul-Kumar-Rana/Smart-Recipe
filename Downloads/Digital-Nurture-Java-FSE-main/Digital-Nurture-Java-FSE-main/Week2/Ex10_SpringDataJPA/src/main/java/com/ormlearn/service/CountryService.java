package com.ormlearn.service;

import com.ormlearn.model.Country;
import com.ormlearn.repository.CountryRepository;
import com.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    @Autowired
    private CountryRepository countryRepository;

    // Hands-on 1: Get all countries
    @Transactional
    public List<Country> getAllCountries() {
        LOGGER.debug("Fetching all countries");
        return countryRepository.findAll();
    }

    // Hands-on 6: Find country by code
    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        LOGGER.debug("Finding country by code: {}", countryCode);
        Optional<Country> result = countryRepository.findById(countryCode);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found with code: " + countryCode);
        }
        Country country = result.get();
        LOGGER.debug("Found country: {}", country);
        return country;
    }

    // Hands-on 7: Add new country
    @Transactional
    public void addCountry(Country country) {
        LOGGER.debug("Adding new country: {}", country);
        countryRepository.save(country);
        LOGGER.debug("Country added successfully");
    }

    // Hands-on 8: Update country name by code
    @Transactional
    public void updateCountry(String code, String newName) throws CountryNotFoundException {
        LOGGER.debug("Updating country code={} to name={}", code, newName);
        Optional<Country> result = countryRepository.findById(code);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found with code: " + code);
        }
        Country country = result.get();
        country.setName(newName);
        countryRepository.save(country);
        LOGGER.debug("Country updated: {}", country);
    }

    // Hands-on 9: Delete country by code
    @Transactional
    public void deleteCountry(String code) {
        LOGGER.debug("Deleting country with code: {}", code);
        countryRepository.deleteById(code);
        LOGGER.debug("Country deleted");
    }

    // Find countries by partial name
    @Transactional
    public List<Country> findCountriesByPartialName(String partialName) {
        LOGGER.debug("Searching countries with name containing: {}", partialName);
        return countryRepository.findByNameContainingIgnoreCase(partialName);
    }
}
