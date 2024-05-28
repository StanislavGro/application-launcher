package com.launcher.api.service.auth;

import com.launcher.api.entities.Role;
import com.launcher.api.entities.User;
import org.apache.catalina.users.AbstractUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ExternalUserDetailsService implements ReactiveUserDetailsService {

    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(ExternalUserDetailsService.class);

    public ExternalUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Mono<UserDetails> findByUsername(String login) {

        User user = userService.getUserByLogin(login)
                .orElseThrow(RuntimeException::new);

        logger.info(String.format("User with login %s was found", login));

        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .roles(Role.USER.name())
                .build();

        return Mono.just(userDetails);
    }
}
