package com.hexaclean.arc.demo.app.vehicle.usecase.in;

import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;

public interface VehicleQuery {

    Vehicle findByVin(Vin vin);

    //List<Vehicle> findAllByCustomerId(CustomerId customerId)
    //List<Vehicle> findAll(Vin... vins);

}
