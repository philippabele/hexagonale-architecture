package com.hexaclean.arc.demo.app.vehicle.usecase.in;

import com.hexaclean.arc.demo.app.vehicle.domain.model.LicensePlate;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;

public interface VehicleQuery {
    Vehicle findByVin(Vin vin);

    Vehicle findByLicensePlate(LicensePlate licensePlate);

    //List<Vehicle> findAllByCustomerId(CustomerId customerId)
    //...

}
