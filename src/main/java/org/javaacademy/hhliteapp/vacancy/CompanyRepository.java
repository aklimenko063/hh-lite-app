package org.javaacademy.hhliteapp.vacancy;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class CompanyRepository {
    private Map<String, Company> companySet = new HashMap<>();

    public void addCompany(Company company) {
        companySet.put(company.getCompanyName(), company);
    }

    public Optional<Company> findByName(String companyName) {
        return Optional.ofNullable(companySet.get(companyName));
    }

    public void clearCompanyRepository() {
        companySet.clear();
    }
}
