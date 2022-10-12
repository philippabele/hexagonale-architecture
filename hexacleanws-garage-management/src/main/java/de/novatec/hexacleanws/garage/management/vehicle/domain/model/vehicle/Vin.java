package de.novatec.hexacleanws.garage.management.vehicle.domain.model.vehicle;

public record Vin(String value) {
    public Vin(String value) {
        this.value = value;
        if (!this.value.matches("(?=.*\\d|=.*[A-Z])(?=.*[A-Z])[A-Z0-9]{17}")) {
            throw new IllegalStateException("Vin is not valid");
        }
    }
}
