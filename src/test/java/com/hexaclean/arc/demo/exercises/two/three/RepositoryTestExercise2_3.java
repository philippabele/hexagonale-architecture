package com.hexaclean.arc.demo.exercises.two.three;

import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.VehicleCrudRepository;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.VehicleQueryRepository;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.VehicleToVehicleDbEntityMapper;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.exercises.BaseExerciseTest;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class RepositoryTestExercise2_3 extends BaseExerciseTest {

    @Test
    @DisplayName("The VehicleRepository should return a valid Vehicle")
    void vehicle_and_vin_should_be_created_successful() {
        VehicleCrudRepository vehicleCrudRepository = Mockito.mock(VehicleCrudRepository.class);
        when(vehicleCrudRepository.findById(VIN)).thenReturn(Optional.of(createVehicleDbEntity()));

        Vehicle vehicle = findVehicleByVin(vehicleCrudRepository);
        assertThat(vehicle).isEqualTo(createExpectedVehicle());
    }

    private Vehicle findVehicleByVin(VehicleCrudRepository vehicleCrudRepository) {
        return createVehicleRepository(vehicleCrudRepository).findVehicleByVin(new Vin(VIN));
    }

    private VehicleQueryRepository createVehicleRepository(VehicleCrudRepository vehicleCrudRepository) {
        return new VehicleQueryRepository(new VehicleToVehicleDbEntityMapper(), vehicleCrudRepository);
    }

}
