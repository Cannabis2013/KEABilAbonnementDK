package com.example.keabilabonnement.controllers;

import com.example.keabilabonnement.contracts.agreement.AgreementFactory;
import com.example.keabilabonnement.contracts.auxiliary.CarCustomerRepository;
import com.example.keabilabonnement.contracts.inspection.InspectionRepository;
import com.example.keabilabonnement.contracts.agreement.AgreementRepository;
import com.example.keabilabonnement.models.inspection.Damage;
import com.example.keabilabonnement.models.inspection.Report;
import com.example.keabilabonnement.factories.DamageReportFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class InspectionController {

    /*

        Authors: Nikki Deleuran - M. Kaan Arici

    */

    public InspectionController(AgreementRepository repository, CarCustomerRepository auxiliary, InspectionRepository inspectionRepository, AgreementFactory agreementFactory, DamageReportFactory damageReportFactory) {
        this.repository = repository;
        this.auxiliary = auxiliary;
        this.inspectionRepository = inspectionRepository;
        this.agreementFactory = agreementFactory;
        this.damageReportFactory = damageReportFactory;
    }

    @GetMapping("/report/damage/new")
    public String newDamage(@RequestParam String rentalID, Model model) {
        Report damageReport = inspectionRepository.getReportByRental(rentalID);
        Damage damage = damageReportFactory.emptyDamage();
        model.addAttribute("damageReport", damageReport);
        model.addAttribute("damage", damage);
        return "/forms/createDamage";
    }

    @PostMapping("/report/damage/new")
    public String newDamage(Damage damage, @RequestParam String rentalId) {
        if (inspectionRepository.addDamage(damage)) {
            return "redirect:/rental?rentalId=" + rentalId;
        }
        return "redirect:/errors/CreateDamageReportError";
    }

    // Deletes a damage from the press of an anchor-tag in
    @PostMapping("/report/damage/delete")
    public String deleteDamage(@RequestParam String damageId, @RequestParam String rentalId) {
        if (inspectionRepository.deleteDamageById(damageId)) {
            return "redirect:/rental?rentalId=" + rentalId;
        }
        return "redirect:err";
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
    private final AgreementFactory agreementFactory;
    private final DamageReportFactory damageReportFactory;
}
