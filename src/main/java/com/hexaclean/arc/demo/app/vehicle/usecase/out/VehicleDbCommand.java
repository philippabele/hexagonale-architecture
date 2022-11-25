package com.hexaclean.arc.demo.app.vehicle.usecase.out;

import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;

public interface VehicleDbCommand {
    Vehicle saveVehicle(Vehicle vehicle);
}
