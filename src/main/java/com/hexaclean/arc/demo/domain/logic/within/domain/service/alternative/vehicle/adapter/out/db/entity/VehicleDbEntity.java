package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.out.db.entity;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("VEHICLE")
public class VehicleDbEntity {

    @Column("ID")
    private String vin;
    @Column("LICENSE_PLATE")
    private String licensePlate;
    @Column("MILEAGE")
    private Double milage;
    @Column("REGISTRATION_COUNTRY")
    private String registrationCountry;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Double getMilage() {
        return milage;
    }

    public void setMilage(Double milage) {
        this.milage = milage;
    }

    public String getRegistrationCountry() {
        return registrationCountry;
    }

    public void setRegistrationCountry(String registrationCountry) {
        this.registrationCountry = registrationCountry;
    }
}
