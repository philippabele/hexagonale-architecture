package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.out.db;

import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.out.db.entity.VehicleDbEntity;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.LicensePlate;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.usecase.out.VehicleDbQuery;
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
        return vehicleCrudRepository.findById(vin.getValue())
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Could not find a vehicle for the given vin: %s")));
    }
}
