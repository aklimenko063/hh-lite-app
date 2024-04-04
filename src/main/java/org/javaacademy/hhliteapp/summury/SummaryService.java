package org.javaacademy.hhliteapp.summury;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Getter
@Slf4j
public class SummaryService {
    private final UserRepository userRepository;

    public void createUser(@NonNull String userName,
                           @NonNull String userEmail) {
        userRepository.addUser(new User(userName, userEmail));
        log.info("Пользователь {} добавлен.", userName);
    }

    public void createSummary(@NonNull String userName,
                              @NonNull String description,
                              @NonNull BigDecimal salary) {
        User findingUser = findUserByName(userName);
        findingUser.getSummarySet().add(new Summary(description, salary));
        log.info("Пользователь {} добавлено новое резюме.", userName);
    }

    public Set<Summary> getSummarySet(String userName) {
        User findingUser = findUserByName(userName);
        return findingUser.getSummarySet();
    }

    public User findUserByName(String userName) {
        return userRepository.findByName(userName).orElseThrow();
    }

    public void clearUserRepository() {
        userRepository.clearUserRepository();
    }
}
