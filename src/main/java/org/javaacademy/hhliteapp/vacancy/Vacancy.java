package org.javaacademy.hhliteapp.vacancy;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
public class Vacancy {
    @NonNull
    private String title;
    @NonNull
    private String description;
    @NonNull
    private BigDecimal salary;
    @NonNull
    private String currency;
}
