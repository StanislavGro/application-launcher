package ru.youngstanis.applicationlauncher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.youngstanis.applicationlauncher.constants.TableNameConstants;
import ru.youngstanis.applicationlauncher.entities.Application;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    @Query(value = "SELECT * FROM application_table", nativeQuery = true)
    List<Application> getAllApplications();

    Optional<Application> getApplicationById(Long id);

}
