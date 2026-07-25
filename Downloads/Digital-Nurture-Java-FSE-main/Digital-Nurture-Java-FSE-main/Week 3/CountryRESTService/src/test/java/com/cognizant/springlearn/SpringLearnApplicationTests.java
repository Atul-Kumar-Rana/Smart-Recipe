package com.cognizant.springlearn;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.springlearn.controller.CountryController;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

    @Autowired
    private CountryController countryController;

    @Autowired
    private MockMvc mvc;

    @Test
    void contextLoads() {
        assertNotNull(countryController);
    }

    // MockMVC - Test get country service
    @Test
    void getCountry() throws Exception {
        ResultActions actions = mvc.perform(get("/country"));
        actions.andExpect(status().isOk());
        actions.andExpect(jsonPath("$.code").exists());
        actions.andExpect(jsonPath("$.code").value("IN"));
        actions.andExpect(jsonPath("$.name").exists());
        actions.andExpect(jsonPath("$.name").value("India"));
    }

    // Additional hands-on: Get all countries
    @Test
    void getAllCountries() throws Exception {
        mvc.perform(get("/countries"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].code").value("IN"))
                .andExpect(jsonPath("$[1].code").value("US"));
    }

    // Get country based on country code (case-insensitive)
    @Test
    void getCountryByCode() throws Exception {
        mvc.perform(get("/countries/in"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("IN"))
                .andExpect(jsonPath("$.name").value("India"));
    }

    // MockMVC - Test get country service for exceptional scenario
    @Test
    void getCountryException() throws Exception {
        mvc.perform(get("/countries/az"))
                .andExpect(status().isNotFound());
    }
}
