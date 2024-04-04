package org.javaacademy.hhliteapp;

import org.javaacademy.hhliteapp.summury.SummaryService;
import org.javaacademy.hhliteapp.vacancy.VacancyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("china")
public class HHServiceChinaTest {
    @Autowired
    private SummaryService summaryService;
    @Autowired
    private VacancyService vacancyService;

    @BeforeEach
    void init() {
        summaryService.clearUserRepository();
        vacancyService.clearCompanyRepository();
    }

    @Test
    void createUserSuccess() {
        assertDoesNotThrow(() -> summaryService.createUser("test", "test"));
    }

    @Test
    void createUserFailed() {
        assertThrows(NullPointerException.class, () -> summaryService.createUser(null, null));
    }

    @Test
    void createSummarySuccess() {
        summaryService.createUser("test", "test");
        assertDoesNotThrow(() -> summaryService.createSummary("test", "test", BigDecimal.ZERO));
    }

    @Test
    void createSummaryFailed() {
        assertThrows(NoSuchElementException.class, () -> summaryService.createSummary("test", "test", BigDecimal.ZERO));
    }

    @Test
    void getSummarySetSuccess() {
        summaryService.createUser("test", "test");
        summaryService.createSummary("test", "test", BigDecimal.ZERO);
        assertEquals(1, summaryService.getSummarySet("test").size());
    }

    @Test
    void getSummarySetFailed() {
        assertThrows(NoSuchElementException.class, () -> summaryService.getSummarySet("test"));
    }

    @Test
    void createCompanySuccess() {
        assertDoesNotThrow(() -> vacancyService.createCompany("test"));
    }

    @Test
    void createCompanyFailed() {
        assertThrows(NullPointerException.class, () -> vacancyService.createCompany(null));
    }

    @Test
    void createVacancySuccess() {
        vacancyService.createCompany("test");
        assertDoesNotThrow(() -> vacancyService.createVacancy("test", "test", "test", BigDecimal.ZERO));
    }

    @Test
    void createVacancyFailed() {
        assertThrows(NoSuchElementException.class, () -> vacancyService.createVacancy("test", "test", "test", BigDecimal.ZERO));
    }

    @Test
    void getVacancySetSuccess() {
        vacancyService.createCompany("test");
        vacancyService.createVacancy("test", "test", "test", BigDecimal.ZERO);
        assertEquals(1, vacancyService.getVacancySet("test").size());
    }

    @Test
    void getVacancySetFailed() {
        assertThrows(NoSuchElementException.class, () -> vacancyService.getVacancySet("test"));
    }
}
