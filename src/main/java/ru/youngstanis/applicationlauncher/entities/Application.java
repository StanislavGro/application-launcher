package ru.youngstanis.applicationlauncher.entities;


import jakarta.persistence.*;
import lombok.*;
import ru.youngstanis.applicationlauncher.constants.TableNameConstants;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
@Table(name = TableNameConstants.APPLICATION_TABLE)
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "application_name")
    private String applicationName;

    @Column(name = "loading_time")
    private LocalDateTime loadingTime;

    @Column(name = "launch_time")
    private LocalDateTime launchTime;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Application application)) return false;
        return Objects.equals(this.applicationName, application.applicationName)
                && Objects.equals(this.user, application.user)
                && Objects.equals(this.loadingTime, application.loadingTime)
                && Objects.equals(this.launchTime, application.launchTime);
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
}


