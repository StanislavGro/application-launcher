package com.launcher.api.repository;

import com.launcher.api.entities.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends R2dbcRepository<User, Long> {

    Mono<User> findByFirstName(String firstName);
}
