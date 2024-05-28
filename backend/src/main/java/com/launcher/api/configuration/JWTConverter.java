package com.launcher.api.configuration;

import com.launcher.api.entities.LoginRequest;
import org.springframework.core.ResolvableType;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.MediaType;
import org.springframework.http.codec.json.AbstractJackson2Decoder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;

@Component
public class JWTConverter implements ServerAuthenticationConverter {

    private final AbstractJackson2Decoder jackson2Decoder;

    public JWTConverter(AbstractJackson2Decoder jackson2Decoder) {
        this.jackson2Decoder = jackson2Decoder;
    }

    private LoginRequest getUsernameAndPassword(ServerWebExchange exchange) {

        Flux<DataBuffer> body = exchange.getRequest().getBody();

        ResolvableType resolvableType = ResolvableType.forType(LoginRequest.class);

        return jackson2Decoder
                .decodeToMono(body, resolvableType, MediaType.APPLICATION_JSON, new HashMap<>())
                .onErrorResume(throwable -> Mono.empty())
                .cast(LoginRequest.class)
                .block();
    }

    @Override
    public Mono<Authentication> convert(ServerWebExchange exchange) {

        LoginRequest loginRequest = getUsernameAndPassword(exchange);

        if(loginRequest == null) {
            throw new RuntimeException("Bad request");
        }

        return Mono.just(new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));
    }
}
