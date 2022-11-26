package com.hexaclean.arc.demo.exercises.three;

import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.VehicleToVehicleDbEntityMapper;
import com.hexaclean.arc.demo.exercises.BaseExerciseTest;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.entity.VehicleDbEntity;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MapperTestExercise3_2 extends BaseExerciseTest {

    @Test
    @DisplayName("The VehicleToVehicleDbEntityMapper should return a valid vehicle instance")
    void vehicle_and_vin_should_be_created_successful() {
        VehicleDbEntity dbEntity = createVehicleDbEntity();
        Vehicle vehicle = mapVehicleDbEntityToVehicle(dbEntity);
        assertThat(vehicle).isEqualTo(createExpectedVehicle());
    }

    private Vehicle mapVehicleDbEntityToVehicle(VehicleDbEntity dbEntity) {
        return new VehicleToVehicleDbEntityMapper().mapVehicleDbEntityToVehicle(dbEntity);
    }
}
