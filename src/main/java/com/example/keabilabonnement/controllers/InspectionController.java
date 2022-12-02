package com.example.keabilabonnement.controllers;

import com.example.keabilabonnement.contracts.repository.CarCustomerRepository;
import com.example.keabilabonnement.contracts.repository.InspectionRepository;
import com.example.keabilabonnement.contracts.repository.AgreementRepository;
import com.example.keabilabonnement.models.inspection.Report;
import com.example.keabilabonnement.factories.DamageReportFactory;
import com.example.keabilabonnement.factories.RentalAgreementFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class InspectionController {

    public InspectionController(AgreementRepository repository, CarCustomerRepository auxiliary, InspectionRepository inspectionRepository, RentalAgreementFactory agreementFactory, DamageReportFactory damageReportFactory) {
        this.repository = repository;
        this.auxiliary = auxiliary;
        this.inspectionRepository = inspectionRepository;
        this.agreementFactory = agreementFactory;
        this.damageReportFactory = damageReportFactory;
    }

    @GetMapping("/report/damage/new")
    public String newReport(@RequestParam String rentalID, Model model) {
        Report damageReport = inspectionRepository.getReportByRental(rentalID);
        model.addAttribute("damageReport", damageReport);
        return "/forms/createDamageReport";
    }

    @PostMapping("/report/damage/new")
    public String newReport(Report newDamage) {
        if (inspectionRepository.addReport(newDamage))
            return "redirect:/create_agreement";
        return "redirect:/errors/CreateDamageReportError";
    }

    @PostMapping("/report/new")
    public String createInspection(@RequestParam String rentalId) {
        Report report = damageReportFactory.emptyReport();
        report.setRentalId(rentalId);
        if (inspectionRepository.addReport(report)) {
            return "redirect:/rental?rentalId=" + rentalId;
        }
        return "redirect:err";
    }

    private final AgreementRepository repository;
    private final CarCustomerRepository auxiliary;
    private final InspectionRepository inspectionRepository;
    private final RentalAgreementFactory agreementFactory;
    private final DamageReportFactory damageReportFactory;
}
