package com.launcher.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.launcher.api.entities.Application;
import com.launcher.api.entities.Role;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String login;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private Role role;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
    private Set<Application> applications;

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof UserDto userDto)) return false;

        return Objects.equals(this.firstName, userDto.firstName)
                && Objects.equals(this.lastName, userDto.lastName)
                && Objects.equals(this.login, userDto.login)
                && Objects.equals(this.password, userDto.password)
                && Objects.equals(this.role, userDto.role)
                && Objects.equals(this.createdAt, userDto.createdAt);
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
}
