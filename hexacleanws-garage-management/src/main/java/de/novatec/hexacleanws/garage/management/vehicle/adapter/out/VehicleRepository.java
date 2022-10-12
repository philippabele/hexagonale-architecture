package de.novatec.hexacleanws.garage.management.vehicle.adapter.out;

import de.novatec.hexacleanws.garage.management.vehicle.domain.model.vehicle.Vehicle;
import de.novatec.hexacleanws.garage.management.vehicle.domain.model.vehicle.Vin;
import de.novatec.hexacleanws.garage.management.vehicle.usecase.out.VehicleDbQuery;
import org.springframework.stereotype.Component;

@Component
public class VehicleRepository implements VehicleDbQuery {

    @Override
    public Vehicle findVehicleByVin(Vin vin) {
        return new Vehicle(vin);
    }
}
