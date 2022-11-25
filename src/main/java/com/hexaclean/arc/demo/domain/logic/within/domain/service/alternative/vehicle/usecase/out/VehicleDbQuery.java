package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.usecase.out;

import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.LicensePlate;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.Vehicle;

public interface VehicleDbQuery {
    Vehicle findVehicleByVin(Vin vin);

    Vehicle findVehicleByLicensePlate(LicensePlate licensePlate);
}
