package ru.youngstanis.applicationlauncher.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.youngstanis.applicationlauncher.constants.TableNameConstants;

@Entity
@Table(name = TableNameConstants.APPLICATION_TABLE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "application_name")
    private String applicationName;

    @Column(name = "author_name")
    private String authorName;

//    private LocalDateTime addTime;
//
//    private LocalDateTime launchTime;
}
