package com.hexaclean.arc.demo.app.vehicle.domain.model;

public record Equipment(EquipmentCode code, String description) {

    public Equipment {

        if(code == null) {
            throw new IllegalStateException("Equipment code should not be null");
        }

        if(description == null || description.isBlank()) {
            throw new IllegalStateException("Equipment description should not be null or blank");
        }
    }
}
