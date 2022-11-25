package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.usecase.out;

import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.Vehicle;

public interface VehicleDbCommand {
    Vehicle saveVehicle(Vehicle vehicle);
}
