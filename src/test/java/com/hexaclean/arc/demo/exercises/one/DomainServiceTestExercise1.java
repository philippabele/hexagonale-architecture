package com.hexaclean.arc.demo.exercises.one;


import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.VehicleQueryRepository;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.VehicleToVehicleDbEntityMapper;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.app.vehicle.domain.service.VehicleQueryService;
import com.hexaclean.arc.demo.exercises.BaseExerciseTest;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data.VehicleMasterDataServiceClient;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data.VehicleToVehicleDtoMapper;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DomainServiceTestExercise1 extends BaseExerciseTest {

    @Test
    @DisplayName("The VehicleService should return a vehicle with the overgiven VIN")
    void vehicle_service_should_return_a_valid_vehicle() {
        Vin vin = new Vin(VIN);
        Vehicle vehicle = new VehicleQueryService(new VehicleQueryRepository(new VehicleToVehicleDbEntityMapper()),
                new VehicleMasterDataServiceClient(new VehicleToVehicleDtoMapper())).findByVin(vin);
        assertThat(vehicle).isEqualTo(createExpectedVehicle());
    }

}
