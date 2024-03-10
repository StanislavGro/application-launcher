package ru.youngstanis.applicationlauncher.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;
import ru.youngstanis.applicationlauncher.entities.User;

public interface UserRepository extends R2dbcRepository<User, Long> {

    Mono<User> findByFirstName(String firstName);
}
