package com.hexaclean.arc.demo.app.vehicle.domain.model;

public record SerialNumber(String value) {
    public SerialNumber {
        if (!value.matches("[0-9]{10}")) {
            throw new IllegalStateException("Serial Number is not valid");
        }
    }
}
