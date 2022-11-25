package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model;

import io.github.domainprimitives.object.Entity;
import io.github.domainprimitives.validation.InvariantException;

public class VehicleMotionData extends Entity {

    private LicensePlate licensePlate;
    private Mileage mileage;
    private RegistrationCountry registrationCountry;

    public VehicleMotionData(LicensePlate licensePlate, Mileage mileage, RegistrationCountry registrationCountry) {
        this.licensePlate = licensePlate;
        this.mileage = mileage;
        this.registrationCountry = registrationCountry;
        this.validate();
    }

    public void changeMileage(Mileage newMileage) {
        if(newMileage.getValue() <= this.mileage.getValue()) {
            throw new InvariantException("Vehicle Motion Data / Mileage", "The new mileage is not higher the current value. This is strange!");
        } else {
            this.mileage = newMileage;
        }
    }

    @Override
    protected void validate() {
        validateNotNull(licensePlate, "License Plate");
        validateNotNull(mileage, "Mileage");
        validateNotNull(registrationCountry, "Registraation Country");
        evaluateValidations();
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public Mileage getMileage() {
        return mileage;
    }

    public RegistrationCountry getRegistrationCountry() {
        return registrationCountry;
    }
}
