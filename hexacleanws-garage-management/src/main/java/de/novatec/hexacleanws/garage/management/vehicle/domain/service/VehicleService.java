package de.novatec.hexacleanws.garage.management.vehicle.domain.service;

import de.novatec.hexacleanws.garage.management.vehicle.domain.model.vehicle.Vehicle;
import de.novatec.hexacleanws.garage.management.vehicle.domain.model.vehicle.Vin;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    public Vehicle getVehicleByVin(Vin vin) {
        return new Vehicle(vin);
    }
}
