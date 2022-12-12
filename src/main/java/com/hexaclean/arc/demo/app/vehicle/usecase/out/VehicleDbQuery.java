package com.hexaclean.arc.demo.app.vehicle.usecase.out;

import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;

public interface VehicleDbQuery {
    Vehicle findVehicleByVin(Vin vin);

}
