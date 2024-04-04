package org.javaacademy.hhliteapp.hh;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.javaacademy.hhliteapp.summury.Summary;
import org.javaacademy.hhliteapp.summury.SummaryService;
import org.javaacademy.hhliteapp.vacancy.Vacancy;
import org.javaacademy.hhliteapp.vacancy.VacancyService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class HHService {
    private final SummaryService summaryService;
    private final VacancyService vacancyService;

    public void createUser(@NonNull String userName,
                           @NonNull String userEmail) {
        summaryService.createUser(userName, userEmail);
    }

    public void createSummary(@NonNull String userName,
                              @NonNull String description,
                              @NonNull BigDecimal salary) {
        summaryService.createSummary(userName, description, salary);
    }

    public Set<Summary> getSummarySet(String userName) {
        return summaryService.getSummarySet(userName);
    }

    public void createCompany(@NonNull String companyName) {
        vacancyService.createCompany(companyName);
    }

    public void createVacancy(@NonNull String companyName,
                              @NonNull String title,
                              @NonNull String description,
                              @NonNull BigDecimal salary) {
        vacancyService.createVacancy(companyName, title, description, salary);
    }

    public Set<Vacancy> getVacancySet(String companyName) {
        return vacancyService.getVacancySet(companyName);
    }
}
