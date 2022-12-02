package com.example.keabilabonnement.repository.mysql.agreement;

import com.example.keabilabonnement.contracts.agreement.Agreement;
import com.example.keabilabonnement.contracts.agreement.AgreementRepository;
import com.example.keabilabonnement.contracts.shared.RepositoryUpdateException;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class MySQLAgreementRepository implements AgreementRepository {
    public MySQLAgreementRepository(MySQLRegistrationAdder adder, MySQLRegistrations registrations, MySQLRegistrationRemover remover) {
        this.adder = adder;
        this.registrations = registrations;
        this.remover = remover;
    }

    @Override
    public void addRegistration(Agreement agreement) {
        if(!adder.add(agreement))
            throw new RepositoryUpdateException();
    }

    @Override
    public void removeRegistration(String id) {
        if(!remover.remove(id))
            throw new RepositoryUpdateException();
    }

    @Override
    public Agreement getAgreement(String id) {
        return registrations.getRegistration(id);
    }

    @Override
    public List<Agreement> getAllRegistrations() {
        return registrations.getAllRegistrations();
    }

    @Override
    public List<Agreement > getActiveAgreements() {
        return registrations.getAllActiveRegistrations();
    }

    private final MySQLRegistrationAdder adder;
    private final MySQLRegistrations registrations;
    private final MySQLRegistrationRemover remover;
}
