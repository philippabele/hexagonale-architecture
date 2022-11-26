package com.hexaclean.arc.demo.exercises.two.one;

import com.hexaclean.arc.demo.app.vehicle.adapter.in.VehicleController;
import com.hexaclean.arc.demo.app.vehicle.adapter.in.VehicleToVehicleResourceMapper;
import com.hexaclean.arc.demo.app.vehicle.adapter.in.resource.VehicleResource;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.VehicleCommandRepository;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.VehicleCrudRepository;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.VehicleQueryRepository;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.VehicleToVehicleDbEntityMapper;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.app.vehicle.usecase.out.FetchVehicleMasterData;
import com.hexaclean.arc.demo.exercises.BaseExerciseTest;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data.VehicleMasterDataServiceClient;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data.VehicleToVehicleDtoMapper;
import com.hexaclean.arc.demo.app.vehicle.domain.service.VehicleCommandService;
import com.hexaclean.arc.demo.app.vehicle.domain.service.VehicleQueryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class ControllerTestExercise2_1 extends BaseExerciseTest {

    @Test
    @DisplayName("VehicleController should return a valid vehicle")
    void vehicle_controller_should_return_a_valid_vehicle() {
        VehicleCrudRepository vehicleCrudRepository = Mockito.mock(VehicleCrudRepository.class);
        when(vehicleCrudRepository.findById(VIN)).thenReturn(Optional.of(createVehicleDbEntity()));

        FetchVehicleMasterData fetchVehicleMasterData = Mockito.mock(FetchVehicleMasterData.class);
        when(fetchVehicleMasterData.fetch(new Vin(VIN))).thenReturn(createExpectedVehicleMasterData());

        VehicleResource vehicle = createVehicleController(vehicleCrudRepository).readVehicle(VIN);
        assertThat(vehicle.getVin()).isEqualTo(createExpectedVehicle().getVin().value());
    }

    private VehicleController createVehicleController(VehicleCrudRepository vehicleCrudRepository) {
        VehicleQueryRepository queryRepository = createVehicleQueryRepository(vehicleCrudRepository);
        return new VehicleController(
                new VehicleQueryService(queryRepository, new VehicleMasterDataServiceClient(new VehicleToVehicleDtoMapper())),
                new VehicleToVehicleResourceMapper(),
                new VehicleCommandService(
                        new VehicleCommandRepository(
                                new VehicleToVehicleDbEntityMapper(),
                                vehicleCrudRepository))
        );
    }

    private VehicleQueryRepository createVehicleQueryRepository(VehicleCrudRepository vehicleCrudRepository) {
        return new VehicleQueryRepository(new VehicleToVehicleDbEntityMapper(), vehicleCrudRepository);
    }
}
