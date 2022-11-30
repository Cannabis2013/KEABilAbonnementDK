package com.example.keabilabonnement.controllers;

import com.example.keabilabonnement.contracts.repository.CarCustomerRepository;
import com.example.keabilabonnement.contracts.repository.RegistrationRepository;
import com.example.keabilabonnement.models.cars.Car;
import com.example.keabilabonnement.models.customers.Customer;
import com.example.keabilabonnement.models.registration.RentalAgreement;
import com.example.keabilabonnement.services.factories.RentalAgreementFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RegistrationController {
    public RegistrationController(RegistrationRepository repository, CarCustomerRepository auxiliary, RentalAgreementFactory agreementFactory) {
        this.repository = repository;
        this.auxiliary = auxiliary;
        this.agreementFactory = agreementFactory;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/overview";
    }

    // Rental overview
    @GetMapping("/overview")
    public String get(Model model) {
        List<RentalAgreement> registrations = repository.getAllActiveRegistrations();
        model.addAttribute("registrations", registrations);
        return "overview";
    }

    @GetMapping("/rental/new")
    public String newRental(Model model) {
        RentalAgreement agreement = agreementFactory.empty();
        List<Car> cars = auxiliary.getCars();
        List<Customer> customers = auxiliary.getCustomers();
        model.addAttribute("agreement", agreement);
        model.addAttribute("cars", cars);
        model.addAttribute("customers", customers);
        return "/forms/create_agreement";
    }

    @PostMapping("/rental/new")
    public String newRental(RentalAgreement agreement) {
        if (repository.addRegistration(agreement))
            return "redirect:/overview";
        return "redirect:/errors/CreateAgreementError";
    }

    @DeleteMapping("/rental/delete")
    public String deleteRental(@RequestParam String rentalId) {
        if (repository.removeRegistration(rentalId))
            return "redirect:/overview";
        return "redirect:/error/DeleteAgreementError";
    }

    private final RegistrationRepository repository;
    private final CarCustomerRepository auxiliary;
    private final RentalAgreementFactory agreementFactory;
}
