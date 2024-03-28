package ru.youngstanis.applicationlauncher.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.youngstanis.applicationlauncher.entities.Application;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/application-launcher")
public class ApplicationLauncherController {

//    private final ApplicationService applicationService;

//    public ApplicationLauncherController(ApplicationService applicationService) {
//        this.applicationService = applicationService;
//    }

    @GetMapping("/getAllApplications")
    public List<Application> getAllApplications() {
//        return applicationService.getAllApplications();
        return Collections.emptyList();
    }

    @GetMapping("/getApplicationById/{id}")
    public Application getApplicationById(@PathVariable Long id) {
//        return applicationService.getApplicationById(id).orElse(null);
        return null;
    }
}
