package com.hexaclean.arc.demo.app.vehicle.domain.model;

public record VehicleMotionData(LicensePlate licensePlate, Mileage mileage) {

    public VehicleMotionData {
        if (licensePlate == null || mileage == null) {
            throw new IllegalStateException("One or more of License plate, mileage or registration country are null");
        }
    }
}
