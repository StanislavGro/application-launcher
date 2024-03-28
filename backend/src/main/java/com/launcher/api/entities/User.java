package com.launcher.api.entities;

import jakarta.persistence.*;
import lombok.*;
import com.launcher.api.constants.TableNameConstants;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
@Table(name = TableNameConstants.USER_TABLE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private Role role;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
    private Set<Application> applications;

    @ToString.Include(name = "password")
    private String maskPassword() {
        return "********";
    }

    /**
     * Hibernate creator recommends to compare objects by all fields
     * or by one unique field
     */
    @Override
    public boolean equals(Object obj) {

        if(this == obj) return true;

        if(!(obj instanceof User user)) return false;

        return Objects.equals(this.firstName, user.firstName)
                && Objects.equals(this.lastName, user.lastName)
                && Objects.equals(this.login, user.login)
                && Objects.equals(this.password, user.password)
                && Objects.equals(this.role, user.role)
                && Objects.equals(this.createdAt, user.createdAt);
    }

    /**
     * Also he recommends to use .getClass() in hash function
      */
    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
}
