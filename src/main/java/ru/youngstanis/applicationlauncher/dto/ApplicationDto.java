package ru.youngstanis.applicationlauncher.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import ru.youngstanis.applicationlauncher.entities.User;

import java.time.LocalDateTime;
import java.util.Objects;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ApplicationDto {
    private Long id;

    private String applicationName;

    private LocalDateTime addTime;

    private LocalDateTime launchTime;

    private User user;

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof ApplicationDto applicationDto)) return false;
        return Objects.equals(this.applicationName, applicationDto.applicationName)
                && Objects.equals(this.user, applicationDto.user)
                && Objects.equals(this.addTime, applicationDto.addTime)
                && Objects.equals(this.launchTime, applicationDto.launchTime);
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
}
