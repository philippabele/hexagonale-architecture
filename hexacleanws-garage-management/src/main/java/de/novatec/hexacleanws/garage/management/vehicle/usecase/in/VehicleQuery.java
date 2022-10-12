package de.novatec.hexacleanws.garage.management.vehicle.usecase.in;

import de.novatec.hexacleanws.garage.management.vehicle.domain.model.vehicle.Vehicle;
import de.novatec.hexacleanws.garage.management.vehicle.domain.model.vehicle.Vin;

public interface VehicleQuery {
    Vehicle readVehicle(Vin vin);
}
