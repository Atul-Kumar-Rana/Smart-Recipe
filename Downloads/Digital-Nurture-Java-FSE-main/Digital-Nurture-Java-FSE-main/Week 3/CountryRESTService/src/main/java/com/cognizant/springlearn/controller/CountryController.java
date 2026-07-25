package com.cognizant.springlearn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;

@RestController
public class CountryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    @Qualifier("country")
    private Country india;

    @Autowired
    @Qualifier("countryList")
    private List<Country> countryList;

    @Autowired
    private CountryService countryService;

    public CountryController() {
        LOGGER.info("Inside CountryController Constructor.");
    }

    // Hands-on: REST - Country Web Service
    @RequestMapping("/country")
    public Country getCountryIndia() {
        LOGGER.info("Start getCountryIndia()");
        LOGGER.info("End getCountryIndia()");
        return india;
    }

    // Additional hands-on: REST - Get all countries
    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        LOGGER.info("Start getAllCountries()");
        LOGGER.info("End getAllCountries()");
        return countryList;
    }

    // Hands-on: REST - Get country based on country code (+ exceptional scenario)
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        LOGGER.info("Start getCountry() with code: {}", code);
        Country country = countryService.getCountry(code);
        LOGGER.info("End getCountry()");
        return country;
    }
}
