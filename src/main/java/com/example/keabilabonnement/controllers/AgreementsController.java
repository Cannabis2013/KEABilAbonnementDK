package com.example.keabilabonnement.controllers;

import com.example.keabilabonnement.contracts.agreement.Agreement;
import com.example.keabilabonnement.contracts.agreement.AgreementFactory;
import com.example.keabilabonnement.contracts.agreement.AgreementRepository;
import com.example.keabilabonnement.contracts.auxiliary.CarCustomerRepository;
import com.example.keabilabonnement.contracts.inspection.InspectionRepository;
import com.example.keabilabonnement.contracts.shared.RepositoryUpdateException;
import com.example.keabilabonnement.contracts.statistics.StatisticsService;
import com.example.keabilabonnement.models.inspection.Report;
import com.example.keabilabonnement.models.registration.RentalAgreement;
import com.example.keabilabonnement.repository.mysql.statistics.MySQLStatisticsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AgreementsController {

    /*

        Authors: Martin Hansen - Stefan Jensen

    */

    public AgreementsController(AgreementRepository repository, InspectionRepository inspectionRepository, MySQLStatisticsService statisticsRepository, AgreementFactory agreementFactory, CarCustomerRepository auxiliary) {
        this.agreementRepository = repository;
        this.inspectionRepository = inspectionRepository;
        this.statisticsRepository = statisticsRepository;
        this.agreementFactory = agreementFactory;
        this.auxiliary = auxiliary;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/overview";
    }

    // Rental overview
    @GetMapping("/overview")
    public String get(Model model) {
        var statistics = statisticsRepository.getAgreementStatistics();
        var agreements = agreementRepository.getActiveAgreements();
        model.addAttribute("statistics",statistics);
        model.addAttribute("agreements",agreements);
        return "overview";
    }

    @GetMapping("/rental/new")
    public String newRental(Model model) {
        RentalAgreement agreement = agreementFactory.empty();
        var cars = auxiliary.getCars();
        var customers = auxiliary.getCustomers();
        if(cars.isEmpty())
            return "no_cars_available";
        model.addAttribute("agreement", agreement);
        model.addAttribute("cars", cars);
        model.addAttribute("customers",customers);
        return "/forms/agreement/create_agreement";
    }

    @PostMapping("/rental/new")
    public String newRental(RentalAgreement agreement) {
        try {
            agreementRepository.addRegistration(agreement);
        } catch (RepositoryUpdateException e){
            return "redirect:/errors/CreateAgreementError";
        }
        return "redirect:/overview";
    }

    @GetMapping("/rental")
    public String viewRental(@RequestParam String rentalId, Model model) {
        Agreement agreement = agreementRepository.getAgreement(rentalId);
        Report report = inspectionRepository.getReportByRental(rentalId);
        model.addAttribute("agreement", agreement);
        model.addAttribute("report", report);
        return "agreement_details";
    }

    @DeleteMapping("/rental/delete")
    public String deleteRental(@RequestParam String rentalId) {
        try {
            agreementRepository.removeRegistration(rentalId);
        } catch (RepositoryUpdateException e){
            return "redirect:/error/DeleteAgreementError";
        }
        return "redirect:/overview";
    }

    private final AgreementRepository agreementRepository;
    private final InspectionRepository inspectionRepository;
    private final StatisticsService statisticsRepository;
    private final AgreementFactory agreementFactory;
    private final CarCustomerRepository auxiliary;
}
