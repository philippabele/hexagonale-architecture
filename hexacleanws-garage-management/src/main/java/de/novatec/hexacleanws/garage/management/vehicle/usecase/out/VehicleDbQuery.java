package de.novatec.hexacleanws.garage.management.vehicle.usecase.out;

import de.novatec.hexacleanws.garage.management.vehicle.domain.model.vehicle.Vehicle;
import de.novatec.hexacleanws.garage.management.vehicle.domain.model.vehicle.Vin;

public interface VehicleDbQuery {
    Vehicle findVehicleByVin(Vin vin);
}
