package org.javaacademy.hhliteapp.vacancy;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Getter
public class Company {
    @NonNull
    private String companyName;
    private Set<Vacancy> vacancyList = new HashSet<>();
}
