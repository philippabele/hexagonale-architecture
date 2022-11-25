package com.hexaclean.arc.demo.app.vehicle.domain.model;

public record RegistrationCountry(String value) {
    public RegistrationCountry {
        if (!value.matches("[A-Z]{2}-[a-z]{2}")) {
            throw new IllegalStateException("Registration country is not valid");
        }
    }
}
