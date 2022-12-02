package com.example.keabilabonnement.controllers;

import com.example.keabilabonnement.contracts.models.Agreement;
import com.example.keabilabonnement.contracts.repository.AgreementRepository;
import com.example.keabilabonnement.contracts.repository.InspectionRepository;
import com.example.keabilabonnement.contracts.repository.RepositoryUpdateException;
import com.example.keabilabonnement.models.inspection.Report;
import com.example.keabilabonnement.models.registration.RentalAgreement;
import com.example.keabilabonnement.repository.mysql.statistics.MySQLStatisticsRepository;
import com.example.keabilabonnement.services.agreement.NewAgreementDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AgreementsController {
    public AgreementsController(AgreementRepository repository, InspectionRepository inspectionRepository, NewAgreementDetails newAgreement, MySQLStatisticsRepository statisticsRepository) {
        this.agreementRepository = repository;
        this.inspectionRepository = inspectionRepository;
        this.newAgreement = newAgreement;
        this.statisticsRepository = statisticsRepository;
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
        newAgreement.fill(model);
        return "/forms/create_agreement";
    }

    @GetMapping("/rental")
    public String viewRental(@RequestParam String rentalId, Model model) {
        Agreement agreement = agreementRepository.getAgreement(rentalId);
        Report report = inspectionRepository.getReportByRental(rentalId);
        model.addAttribute("agreement", agreement);
        model.addAttribute("report", report);
        return "single_rental_view";
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
    private final NewAgreementDetails newAgreement;
    private final MySQLStatisticsRepository statisticsRepository;
}
