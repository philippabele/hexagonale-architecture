package com.hexaclean.arc.demo.exercises.one;


import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.VehicleCrudRepository;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.VehicleQueryRepository;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.VehicleToVehicleDbEntityMapper;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.app.vehicle.domain.service.VehicleQueryService;
import com.hexaclean.arc.demo.app.vehicle.usecase.out.FetchVehicleMasterData;
import com.hexaclean.arc.demo.exercises.BaseExerciseTest;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data.VehicleMasterDataServiceClient;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data.VehicleToVehicleDtoMapper;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class DomainServiceTestExercise1 extends BaseExerciseTest {

    @Test
    @DisplayName("The VehicleService should return a vehicle with the overgiven VIN")
    void vehicle_service_should_return_a_valid_vehicle() {
        Vin vin = new Vin(VIN);
        VehicleCrudRepository vehicleCrudRepository = Mockito.mock(VehicleCrudRepository.class);
        FetchVehicleMasterData fetchVehicleMasterData = Mockito.mock(FetchVehicleMasterData.class);

        when(fetchVehicleMasterData.fetch(vin)).thenReturn(createExpectedVehicleMasterData());
        when(vehicleCrudRepository.findById(vin.value())).thenReturn(Optional.of(createVehicleDbEntity()));

        Vehicle vehicle = createVehicleQueryService(vehicleCrudRepository, fetchVehicleMasterData).findByVin(vin);
        assertThat(vehicle).isEqualTo(createExpectedVehicle());
    }

    private VehicleQueryService createVehicleQueryService(VehicleCrudRepository vehicleCrudRepository, FetchVehicleMasterData fetchVehicleMasterData) {
        return new VehicleQueryService(new VehicleQueryRepository(new VehicleToVehicleDbEntityMapper(), vehicleCrudRepository),
                fetchVehicleMasterData);
    }

}
