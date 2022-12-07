package com.example.keabilabonnement.repository.mysql.agreement;

import com.example.keabilabonnement.contracts.agreement.Agreement;
import com.example.keabilabonnement.contracts.agreement.AgreementRepository;
import com.example.keabilabonnement.contracts.shared.RepositoryUpdateException;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class MySQLAgreementRepository implements AgreementRepository {
    public MySQLAgreementRepository(AgreementPersistence adder, MySQLAgreements registrations, MySQLRegistrationRemover remover) {
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
        return registrations.getAgreement(id);
    }

    @Override
    public List<Agreement> getAllRegistrations() {
        return registrations.getAllAgreements();
    }

    @Override
    public List<Agreement > getActiveAgreements() {
        return registrations.getAllActiveAgreements();
    }

    private final AgreementPersistence adder;
    private final MySQLAgreements registrations;
    private final MySQLRegistrationRemover remover;
}
