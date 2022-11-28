package com.hexaclean.arc.demo.app.vehicle.adapter.out.db;

import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.entity.VehicleDbEntity;
import com.hexaclean.arc.demo.app.vehicle.domain.model.LicensePlate;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbQuery;
import org.springframework.stereotype.Component;

@Component
public class VehicleRepository implements VehicleDbQuery {

    private VehicleToVehicleDbEntityMapper mapper;

    private static final String VIN = "WP0ZZZ99ZTS392155";
    private static final String LICENSE_PLATE_TEST_VALUE = "ES-EM 385";
    private static final double MILEAGE_TEST_VALUE = 100000;
    private static final String REGISTRATION_COUNTRY_TEST_VALUE = "DE-de";
    private static final String VEHICLE_MODEL_DESCRIPTION_TEST_VALUE = "E30 Limousine";
    private static final String VEHICLE_MODEL_TYPE_TEST_VALUE = "3er";
    private static final String SERIAL_NUMBER_TEST_VALUE = "0123456789";

    public VehicleRepository(VehicleToVehicleDbEntityMapper mapper) {
        this.mapper = mapper;
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
        VehicleDbEntity dbEntity = new VehicleDbEntity();
        dbEntity.setVin(VIN);
        dbEntity.setLicensePlate(LICENSE_PLATE_TEST_VALUE);
        dbEntity.setMilage(MILEAGE_TEST_VALUE);
        return dbEntity;
    }
}
