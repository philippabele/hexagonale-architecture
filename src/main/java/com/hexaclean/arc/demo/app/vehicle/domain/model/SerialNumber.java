package com.hexaclean.arc.demo.app.vehicle.domain.model;

public record SerialNumber(String value) {
    public SerialNumber {
        if (!value.matches("(?=.*\\d|=.*[A-Z])(?=.*[A-Z])[A-Z0-9]{17}")) {
            throw new IllegalStateException("Vin is not valid");
        }
    }
}
