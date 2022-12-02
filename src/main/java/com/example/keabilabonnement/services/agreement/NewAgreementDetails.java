package com.example.keabilabonnement.services.agreement;

import com.example.keabilabonnement.contracts.models.CarDetails;
import com.example.keabilabonnement.contracts.models.CustomerDetails;
import com.example.keabilabonnement.contracts.repository.CarCustomerRepository;
import com.example.keabilabonnement.models.registration.RentalAgreement;
import com.example.keabilabonnement.factories.RentalAgreementFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class NewAgreementDetails {
    public NewAgreementDetails(RentalAgreementFactory agreementFactory, CarCustomerRepository auxiliary) {
        this.agreementFactory = agreementFactory;
        this.auxiliary = auxiliary;
    }

    public Model fill(Model model){
        RentalAgreement agreement = agreementFactory.empty();
        List<CarDetails> cars = auxiliary.getCars();
        List<CustomerDetails> customers = auxiliary.getCustomers();
        model.addAttribute("agreement", agreement);
        model.addAttribute("cars", cars);
        model.addAttribute("customers", customers);
        return model;
    }

    private RentalAgreementFactory agreementFactory;
    private CarCustomerRepository auxiliary;
}
