package com.hexaclean.arc.demo.app.vehicle.adapter.out.db;

import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.entity.VehicleDbEntity;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbCommand;
import org.springframework.stereotype.Component;

@Component
public class VehicleCommandRepository implements VehicleDbCommand {

    private VehicleToVehicleDbEntityMapper mapper;
    private VehicleCrudRepository vehicleCrudRepository;

    public VehicleCommandRepository(VehicleToVehicleDbEntityMapper mapper, VehicleCrudRepository vehicleCrudRepository) {
        this.mapper = mapper;
        this.vehicleCrudRepository = vehicleCrudRepository;
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        VehicleDbEntity savedVehicle = technicalSaveWithSqlStuff(vehicle);
        return mapper.mapVehicleDbEntityToVehicle(savedVehicle);
    }

    private VehicleDbEntity technicalSaveWithSqlStuff(Vehicle vehicle) {
        return vehicleCrudRepository.save(mapper.mapVehicleToVehicleDbEntity(vehicle));
    }
}
