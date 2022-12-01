package com.example.keabilabonnement.controllers;

import com.example.keabilabonnement.contracts.repository.CarCustomerRepository;
import com.example.keabilabonnement.contracts.repository.InspectionRepository;
import com.example.keabilabonnement.contracts.repository.RegistrationRepository;
import com.example.keabilabonnement.models.cars.Car;
import com.example.keabilabonnement.models.inspection.Report;
import com.example.keabilabonnement.services.factories.DamageReportFactory;
import com.example.keabilabonnement.services.factories.RentalAgreementFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class InspectionController {

    public InspectionController(RegistrationRepository repository, CarCustomerRepository auxiliary, InspectionRepository inspectionRepository, RentalAgreementFactory agreementFactory, DamageReportFactory damageReportFactory) {
        this.repository = repository;
        this.auxiliary = auxiliary;
        this.inspectionRepository = inspectionRepository;
        this.agreementFactory = agreementFactory;
        this.damageReportFactory = damageReportFactory;
    }

    @GetMapping("/report/new")
    public String newReport(Model model) {
        Report damageReport = damageReportFactory.emptyReport();
        List<Car> cars = auxiliary.getCars();
        model.addAttribute("damage", damageReport);
        model.addAttribute("cars", cars);
        return "/forms/createDamageReport";
    }

    @PostMapping("/report/new")
    public String newReport(Report newDamage) {
        if (inspectionRepository.addReport(newDamage))
            return "redirect:/create_agreement";
        return "redirect:/errors/CreateDamageReportError";
    }

    private final RegistrationRepository repository;
    private final CarCustomerRepository auxiliary;
    private final InspectionRepository inspectionRepository;
    private final RentalAgreementFactory agreementFactory;
    private final DamageReportFactory damageReportFactory;
}
