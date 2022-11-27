package com.hexaclean.arc.demo.app.vehicle.domain.model;

public record MileageUnit(MileageUnitValue value) {
    public MileageUnit {
        if (value == null) {
            throw new IllegalStateException("Mileage unit is null");
        }
    }
}

