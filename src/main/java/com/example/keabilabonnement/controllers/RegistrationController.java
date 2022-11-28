package com.example.keabilabonnement.controllers;

import com.example.keabilabonnement.contracts.repository.RegistrationRepository;
import org.springframework.stereotype.Controller;

@Controller
public class RegistrationController {
    public RegistrationController(RegistrationRepository repository) {
        this.repository = repository;
    }


    private final RegistrationRepository repository;
}
