package com.hexaclean.arc.demo.app.vehicle.domain.model;

public record EquipmentCode(String value) {

    public EquipmentCode {
        if (!value.matches("[A-Z]{2}[0-9]{3}")) {
            throw new IllegalStateException("Equipment code is not valid");
        }
    }
}
