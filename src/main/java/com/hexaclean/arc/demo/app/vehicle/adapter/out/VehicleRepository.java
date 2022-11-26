package com.hexaclean.arc.demo.app.vehicle.adapter.out;

import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbQuery;

public class VehicleRepository implements VehicleDbQuery {

    @Override
    public Vehicle findVehicleByVin(Vin vin) {
        return new Vehicle(new Vin("WP0ZZZ99ZTS392155"));
    }
}
