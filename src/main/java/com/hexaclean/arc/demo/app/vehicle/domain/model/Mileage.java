package com.hexaclean.arc.demo.app.vehicle.domain.model;

public record Mileage(double value) {
    public Mileage {
        if (value < 0) {
            throw new IllegalStateException("Mileage should not be negative");
        }
    }
}
