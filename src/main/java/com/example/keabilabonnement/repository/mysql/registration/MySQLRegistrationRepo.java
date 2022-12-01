package com.example.keabilabonnement.repository.mysql.registration;

import com.example.keabilabonnement.contracts.models.Agreement;
import com.example.keabilabonnement.contracts.repository.RegistrationRepository;
import com.example.keabilabonnement.models.registration.RentalAgreement;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class MySQLRegistrationRepo implements RegistrationRepository {
    public MySQLRegistrationRepo(MySQLRegistrationAdder adder, MySQLRegistrations registrations, MySQLRegistrationRemover remover) {
        this.adder = adder;
        this.registrations = registrations;
        this.remover = remover;
    }

    @Override
    public boolean addRegistration(Agreement agreement) {
        return adder.add(agreement);
    }

    @Override
    public boolean removeRegistration(String id) {
        return remover.remove(id);
    }

    @Override
    public Agreement  getRegistration(String id) {
        return registrations.getRegistration(id);
    }

    @Override
    public List<Agreement> getAllRegistrations() {
        return registrations.getAllRegistrations();
    }

    @Override
    public List<Agreement > getAllActiveRegistrations() {
        return registrations.getAllActiveRegistrations();
    }

    private final MySQLRegistrationAdder adder;
    private final MySQLRegistrations registrations;
    private final MySQLRegistrationRemover remover;
}
