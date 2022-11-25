package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.usecase.in;

import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.VehicleMotionData;

public interface VehicleCommand {
    Vehicle create(Vehicle vehicle);

    Vehicle update(Vin vin, VehicleMotionData vehicleMotionData);
}
