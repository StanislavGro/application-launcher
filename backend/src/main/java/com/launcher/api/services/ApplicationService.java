//package ru.youngstanis.applicationlauncher.services;
//
//import org.springframework.stereotype.Service;
//import ru.youngstanis.applicationlauncher.entities.Application;
//import ru.youngstanis.applicationlauncher.repository.ApplicationRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ApplicationService {
//
//    private final ApplicationRepository applicationRepository;
//
//    public ApplicationService(ApplicationRepository applicationRepository) {
//        this.applicationRepository = applicationRepository;
//    }
//
//    public List<Application> getAllApplications() {
//        return applicationRepository.getAllApplications();
//    }
//
//    public Optional<Application> getApplicationById(Long id) {
//        return applicationRepository.getApplicationById(id);
//    }
//}
