package de.novatec.hexacleanws.garage.management.vehicle.domain.model.vehicle;

import java.util.Objects;

public record Vehicle(Vin vin) {

    public Vehicle {
        if (vin == null) {
            throw new IllegalStateException("Vin should not be null!");
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
}