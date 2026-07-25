package com.ormlearn.controller;

import com.ormlearn.model.Country;
import com.ormlearn.service.CountryService;
import com.ormlearn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    // GET all countries
    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    // GET country by code (Hands-on 6)
    @GetMapping("/{code}")
    public ResponseEntity<?> getCountryByCode(@PathVariable String code) {
        try {
            Country country = countryService.findCountryByCode(code);
            return ResponseEntity.ok(country);
        } catch (CountryNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // POST - Add new country (Hands-on 7)
    @PostMapping
    public ResponseEntity<String> addCountry(@RequestBody Country country) {
        countryService.addCountry(country);
        return ResponseEntity.status(HttpStatus.CREATED).body("Country added: " + country.getCode());
    }

    // PUT - Update country name (Hands-on 8)
    @PutMapping("/{code}")
    public ResponseEntity<String> updateCountry(@PathVariable String code,
                                                @RequestParam String newName) {
        try {
            countryService.updateCountry(code, newName);
            return ResponseEntity.ok("Country updated successfully");
        } catch (CountryNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // DELETE - Delete country by code (Hands-on 9)
    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteCountry(@PathVariable String code) {
        countryService.deleteCountry(code);
        return ResponseEntity.ok("Country deleted: " + code);
    }

    // GET - Search by partial name
    @GetMapping("/search")
    public List<Country> searchByName(@RequestParam String name) {
        return countryService.findCountriesByPartialName(name);
    }
}
