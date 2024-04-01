package com.launcher.api.controllers;

import com.launcher.api.entities.Application;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/application-launcher")
public class ApplicationLauncherController {

    @GetMapping("/getAllApplications")
    public ResponseEntity<List<Application>> getAllApplications() {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/getApplicationById/{id}")
    public Application getApplicationById(@PathVariable Long id) {
        return null;
    }
}
