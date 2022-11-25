package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.usecase.in;

import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.LicensePlate;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.Vehicle;

public interface VehicleQuery {
    Vehicle findByVin(Vin vin);

    Vehicle findByLicensePlate(LicensePlate licensePlate);

    //List<Vehicle> findAllByCustomerId(CustomerId customerId)
    //...

}
