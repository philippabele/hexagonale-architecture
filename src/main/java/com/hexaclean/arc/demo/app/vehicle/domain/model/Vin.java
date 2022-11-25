package com.hexaclean.arc.demo.app.vehicle.domain.model;

public record Vin(String value) {
    public Vin {
        if (!value.matches("(?=.*\\d|=.*[A-Z])(?=.*[A-Z])[A-Z0-9]{17}")) {
            throw new IllegalStateException("Vin is not valid");
        }
    }
}
