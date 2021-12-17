package io.khodis.lister.service;

import io.khodis.lister.domain.User;
import io.khodis.lister.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User register(int telegramId) {
        User user = new User(telegramId);
        repository.save(user);
        return user;
    }

    public boolean exists(int telegramId) {
        return repository.existsByTelegramId(telegramId);
    }
}
