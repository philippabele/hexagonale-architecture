package com.hexaclean.arc.demo.app.vehicle.usecase.in;

import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.app.vehicle.domain.model.VehicleMotionData;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;

public interface VehicleCommand {
    Vehicle create(Vehicle vehicle);

    Vehicle update(Vin vin, VehicleMotionData vehicleMotionData);
}
