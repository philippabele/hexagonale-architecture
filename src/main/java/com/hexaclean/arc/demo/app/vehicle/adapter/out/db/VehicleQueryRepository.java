package com.hexaclean.arc.demo.app.vehicle.adapter.out.db;

import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbQuery;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.entity.VehicleDbEntity;
import com.hexaclean.arc.demo.app.vehicle.domain.model.LicensePlate;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleQueryRepository implements VehicleDbQuery {

    private VehicleToVehicleDbEntityMapper mapper;
    private VehicleCrudRepository vehicleCrudRepository;

    public VehicleQueryRepository(VehicleToVehicleDbEntityMapper mapper, VehicleCrudRepository vehicleCrudRepository) {
        this.mapper = mapper;
        this.vehicleCrudRepository = vehicleCrudRepository;
    }

    @Override
    public Vehicle findVehicleByVin(Vin vin) {
        VehicleDbEntity vehicleDbEntity = findVehicleDbEntity(vin);
        return mapper.mapVehicleDbEntityToVehicle(vehicleDbEntity);
    }

    @Override
    public Vehicle findVehicleByLicensePlate(LicensePlate licensePlate) {
        return null;
    }

    private VehicleDbEntity findVehicleDbEntity(Vin vin) {
        return vehicleCrudRepository.findById(vin.value())
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Could not find a vehicle for the given vin: %s")));
    }
}