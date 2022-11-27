package com.hexaclean.arc.demo.app.vehicle.domain.service;

import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleQuery;
import com.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbQuery;
import org.springframework.stereotype.Service;

@Service
public class VehicleService implements VehicleQuery {

    private VehicleDbQuery vehicleDbQuery;

    public VehicleService(VehicleDbQuery vehicleDbQuery) {
        this.vehicleDbQuery = vehicleDbQuery;
    }

    public Vehicle findByVin(Vin vin) {
        Vehicle vehicle = vehicleDbQuery.findVehicleByVin(vin);
        return vehicle;
    }

}
