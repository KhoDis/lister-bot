package io.khodis.lister.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.khodis.lister.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByTelegramId(int id);
}
