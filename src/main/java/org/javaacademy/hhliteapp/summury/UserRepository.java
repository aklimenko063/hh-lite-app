package org.javaacademy.hhliteapp.summury;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class UserRepository {
    private Map<String, User> userSet = new HashMap<>();

    public void addUser(User user) {
        userSet.put(user.getUserName(), user);
    }

    public Optional<User> findByName(String userName) {
        return Optional.ofNullable(userSet.get(userName));
    }

    public void clearUserRepository() {
        userSet.clear();
    }
}
