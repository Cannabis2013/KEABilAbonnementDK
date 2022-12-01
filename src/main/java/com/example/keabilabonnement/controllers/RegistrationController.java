package com.example.keabilabonnement.controllers;

import com.example.keabilabonnement.contracts.repository.CarCustomerRepository;
import com.example.keabilabonnement.contracts.repository.InspectionRepository;
import com.example.keabilabonnement.contracts.repository.RegistrationRepository;
import com.example.keabilabonnement.models.cars.Car;
import com.example.keabilabonnement.models.customers.Customer;
import com.example.keabilabonnement.models.inspection.Report;
import com.example.keabilabonnement.models.registration.RentalAgreement;
import com.example.keabilabonnement.services.factories.DamageReportFactory;
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
    public RegistrationController(RegistrationRepository repository, CarCustomerRepository auxiliary, RentalAgreementFactory agreementFactory, InspectionRepository inspectionRepository, DamageReportFactory damageReportFactory) {
        this.repository = repository;
        this.auxiliary = auxiliary;
        this.agreementFactory = agreementFactory;
        this.inspectionRepository = inspectionRepository;
        this.damageReportFactory = damageReportFactory;
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

    @GetMapping("/rental")
    public String viewRental(@RequestParam String rentalId, Model model) {
        RentalAgreement agreement = repository.getRegistration(rentalId);
        Report report = inspectionRepository.getReportByRental(rentalId);
        model.addAttribute("agreement", agreement);
        model.addAttribute("report", report);
        return "single_rental_view";
    }

    @PostMapping("/inspection/new")
    public String createInspection(@RequestParam String rentalId) {
        Report report = damageReportFactory.emptyReport();
        report.setRentalId(rentalId);
        if (inspectionRepository.addReport(report)) {
            return "redirect:/rental?rentalId=" + rentalId;
        }
        return "redirect:err";
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
    private final InspectionRepository inspectionRepository;
    private final DamageReportFactory damageReportFactory;
}
