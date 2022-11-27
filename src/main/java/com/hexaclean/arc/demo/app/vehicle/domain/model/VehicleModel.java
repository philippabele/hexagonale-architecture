package com.hexaclean.arc.demo.app.vehicle.domain.model;

public record VehicleModel(String modelDescription, String modelType) {

    public VehicleModel {

        if (modelDescription == null || modelDescription.isBlank()) {
            throw new IllegalStateException("Model description is not valid");
        }

        if (modelType == null || modelType.isBlank()) {
            throw new IllegalStateException("Model type is not valid");
        }
    }
}
