package com.hexaclean.arc.demo.app.vehicle.domain.model;

public record LicensePlate(String value) {
    public LicensePlate {
        if (!value.matches("[A-ZÖÜÄ]{1,3}-[A-ZÖÜÄ]{1,2} [1-9]{1}[0-9]{1,3}")) {
            throw new IllegalStateException("License plate is not valid");
        }
    }
}
