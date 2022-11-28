package com.hexaclean.arc.demo.app.vehicle.adapter.out.db;

import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.entity.VehicleDbEntity;
import com.hexaclean.arc.demo.app.vehicle.domain.model.*;
import org.springframework.stereotype.Component;

@Component
public class VehicleToVehicleDbEntityMapper {

    public Vehicle mapVehicleDbEntityToVehicle(VehicleDbEntity dbEntity) {
        return new Vehicle(
                new Vin(dbEntity.getVin()),
                new VehicleMotionData(
                        new LicensePlate(dbEntity.getLicensePlate()),
                        new Mileage(dbEntity.getMilage())));
    }

    public VehicleDbEntity mapVehicleToVehicleDbEntity(Vehicle vehicle) {
        VehicleDbEntity vehicleDbEntity = new VehicleDbEntity();
        vehicleDbEntity.setVin(vehicle.getVin().value());
        vehicleDbEntity.setMilage(vehicle.getVehicleMotionData().mileage().value());
        vehicleDbEntity.setLicensePlate(vehicle.getVehicleMotionData().licensePlate().value());
        return vehicleDbEntity;
    }
}
