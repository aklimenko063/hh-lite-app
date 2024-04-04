package org.javaacademy.hhliteapp.vacancy;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class VacancyService {
    private final CompanyRepository companyRepository;
    @Value("${vacancy.currency}")
    private String currency;


    public void createCompany(@NonNull String companyName) {
        companyRepository.addCompany(new Company(companyName));
        log.info("Компания {} добавлена.", companyName);
    }

    public void createVacancy(@NonNull String companyName,
                              @NonNull String title,
                              @NonNull String description,
                              @NonNull BigDecimal salary) {
        Company findingCompany = findCompanyByName(companyName);
        findingCompany.getVacancyList().add(new Vacancy(title, description, salary, currency));
        log.info("Компания {} добавила новоую вакансию.", companyName);
    }

    public Set<Vacancy> getVacancySet(String companyName) {
        Company findingCompany = findCompanyByName(companyName);
        findingCompany.getVacancyList().forEach(e ->
                log.info("{} {} {} {}", e.getTitle(),
                        e.getDescription(),
                        e.getSalary(),
                        e.getCurrency()));
        return findingCompany.getVacancyList();
    }

    public Company findCompanyByName(String companyName) {
        return companyRepository.findByName(companyName).orElseThrow();
    }

    public void clearCompanyRepository() {
        companyRepository.clearCompanyRepository();
    }
}
