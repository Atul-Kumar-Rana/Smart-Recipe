package com.cognizant.loan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @GetMapping("/{number}")
    public Map<String, Object> getLoanDetails(@PathVariable String number) {
        Map<String, Object> response = new HashMap<>();
        // Using the exact mock values from the PDF
        response.put("number", "H00987987972342");
        response.put("type", "car");
        response.put("loan", 400000);
        response.put("emi", 3258);
        response.put("tenure", 18);
        return response;
    }
}
