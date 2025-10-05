package com.example.todo_app.service;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthCheck implements HealthIndicator {

    private static volatile boolean forceUnhealthy = false;

    @Override
    public Health health() {
        if (forceUnhealthy) {
            return Health.down().withDetail("reason", "Manual test trigger").build();
        }
        return Health.up().build();
    }

    public static void setForceUnhealthy(boolean value) {
        forceUnhealthy = value;
    }
    
}
