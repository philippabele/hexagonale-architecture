package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.out.db;

import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.out.db.entity.VehicleDbEntity;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.*;
import org.springframework.stereotype.Component;

@Component
public class VehicleToVehicleDbEntityMapper {

    public Vehicle mapVehicleDbEntityToVehicle(VehicleDbEntity dbEntity) {
        return new Vehicle(
                new Vin(dbEntity.getVin()),
                new VehicleMotionData(
                        new LicensePlate(dbEntity.getLicensePlate()),
                        new Mileage(dbEntity.getMilage()),
                        new RegistrationCountry(dbEntity.getRegistrationCountry())));
    }

    public VehicleDbEntity mapVehicleToVehicleDbEntity(Vehicle vehicle) {
        VehicleDbEntity vehicleDbEntity = new VehicleDbEntity();
        vehicleDbEntity.setVin(vehicle.getVin().getValue());
        vehicleDbEntity.setMilage(vehicle.getVehicleMotionData().getMileage().getValue());
        vehicleDbEntity.setRegistrationCountry(vehicle.getVehicleMotionData().getRegistrationCountry().getValue());
        vehicleDbEntity.setLicensePlate(vehicle.getVehicleMotionData().getLicensePlate().getValue());
        return vehicleDbEntity;
    }
}
