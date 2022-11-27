package com.hexaclean.arc.demo.app.vehicle.adapter.out;

import com.hexaclean.arc.demo.app.vehicle.adapter.out.entity.VehicleDbEntity;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbQuery;
import org.springframework.stereotype.Component;

@Component
public class VehicleRepository implements VehicleDbQuery {

    private VehicleToVehicleDbEntityMapper mapper;

    public VehicleRepository(VehicleToVehicleDbEntityMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Vehicle findVehicleByVin(Vin vin) {
        VehicleDbEntity vehicleDbEntity = findVehicleDbEntity(vin);
        return mapper.mapVehicleDbEntityToVehicle(vehicleDbEntity);
    }

    private VehicleDbEntity findVehicleDbEntity(Vin vin) {
        VehicleDbEntity dbEntity = new VehicleDbEntity();
        dbEntity.setVin(vin.value());
        return dbEntity;
    }
}
