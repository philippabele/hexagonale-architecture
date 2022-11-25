package com.hexaclean.arc.demo.exercises.two.three;

import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.VehicleQueryRepository;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.VehicleToVehicleDbEntityMapper;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.exercises.BaseExerciseTest;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositoryTestExercise2_3 extends BaseExerciseTest {

    @Test
    @DisplayName("The VehicleRepository should return a valid Vehicle")
    void vehicle_and_vin_should_be_created_successful() {
        Vehicle vehicle = findVehicleByVin();
        assertThat(vehicle).isEqualTo(createVehicleDbEntity());
    }

    private Vehicle findVehicleByVin() {
        return createVehicleRepository().findVehicleByVin(new Vin(VIN));
    }

    private VehicleQueryRepository createVehicleRepository() {
        return new VehicleQueryRepository(new VehicleToVehicleDbEntityMapper());
    }

}
