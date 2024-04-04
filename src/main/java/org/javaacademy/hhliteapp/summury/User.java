package org.javaacademy.hhliteapp.summury;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Getter
public class User {
    @NonNull
    private String userName;
    @NonNull
    private String userEmail;
    private Set<Summary> summarySet = new HashSet<>();
}
