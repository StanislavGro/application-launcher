package com.launcher.api.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;
import com.launcher.api.entities.User;

public interface UserRepository extends R2dbcRepository<User, Long> {

    Mono<User> findByFirstName(String firstName);
}
