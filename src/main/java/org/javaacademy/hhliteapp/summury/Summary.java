package org.javaacademy.hhliteapp.summury;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
public class Summary {
    @NonNull
    private String description;
    @NonNull
    private BigDecimal salary;
}
