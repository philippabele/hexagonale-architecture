package com.hexaclean.arc.demo.app.vehicle.adapter.out;

import com.hexaclean.arc.demo.app.vehicle.adapter.out.entity.VehicleDbEntity;
import com.hexaclean.arc.demo.app.vehicle.domain.model.*;
import org.springframework.stereotype.Component;

@Component
public class VehicleToVehicleDbEntityMapper {

    public Vehicle mapVehicleDbEntityToVehicle(VehicleDbEntity dbEntity) {
        return new Vehicle(new Vin(dbEntity.getVin()));
    }

    public VehicleDbEntity mapVehicleToVehicleDbEntity(Vehicle vehicle) {
        VehicleDbEntity vehicleDbEntity = new VehicleDbEntity();
        vehicleDbEntity.setVin(vehicle.getVin().value());
        return vehicleDbEntity;
    }
}
