package ru.youngstanis.applicationlauncher.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ApplicationLauncherController {

    @GetMapping
    public String test() {
        return "Application launcher is working!";
    }
}
