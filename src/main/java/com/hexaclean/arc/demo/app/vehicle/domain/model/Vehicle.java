package com.hexaclean.arc.demo.app.vehicle.domain.model;

import java.util.Objects;

public class Vehicle {

    private Vin vin;

    public Vehicle(Vin vin) {
        this.vin = vin;
        if (this.vin == null) {
            throw new IllegalStateException("Vin should not be null");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(vin, vehicle.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin);
    }

    public Vin getVin() {
        return vin;
    }

}