package com.launcher.api;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class FluxAndMonoTest {

    @Test
    public void monoSubscriptionTest() {
        Mono<String> stringMono = Mono
                .just("Spring Boot")
                .log();

        stringMono.subscribe(System.out::println);
    }

    @Test
    public void monoVerifyTest() {
        Mono<String> stringMono = Mono.just("Spring");

        StepVerifier.create(stringMono.log())
                .expectNext("Spring")
                .verifyComplete();

    }

    @Test
    public void MonoErrorTest() {

        Mono<Object> exceptionMono = Mono.error(new RuntimeException("My Exception!!!1!!"))
                .log();

        StepVerifier.create(exceptionMono)
                .expectError(RuntimeException.class)
                .verify();

    }
}
