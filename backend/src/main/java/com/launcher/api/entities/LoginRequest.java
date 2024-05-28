package com.launcher.api.entities;

public record LoginRequest(
   String username,
   String password
) {}
