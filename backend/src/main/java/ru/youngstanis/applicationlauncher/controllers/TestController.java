package ru.youngstanis.applicationlauncher.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping
    public String test() {
        return "Application launcher is working!";
    }
}
