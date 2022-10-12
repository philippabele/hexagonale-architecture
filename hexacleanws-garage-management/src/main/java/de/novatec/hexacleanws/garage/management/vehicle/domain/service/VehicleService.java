package de.novatec.hexacleanws.garage.management.vehicle.domain.service;

import de.novatec.hexacleanws.garage.management.vehicle.domain.model.vehicle.Vehicle;
import de.novatec.hexacleanws.garage.management.vehicle.domain.model.vehicle.Vin;
import de.novatec.hexacleanws.garage.management.vehicle.usecase.in.VehicleQuery;
import de.novatec.hexacleanws.garage.management.vehicle.usecase.out.VehicleDbQuery;
import org.springframework.stereotype.Service;

@Service
public class VehicleService implements VehicleQuery {

    private final VehicleDbQuery vehicleDbQuery;

    public VehicleService(VehicleDbQuery vehicleDbQuery) {
        this.vehicleDbQuery = vehicleDbQuery;
    }

    @Override
    public Vehicle readVehicle(Vin vin) {
        return vehicleDbQuery.findVehicleByVin(vin);
    }
}
