package com.hexaclean.arc.demo.lab.three;

import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.VehicleToVehicleDbEntityMapper;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.entity.VehicleDbEntity;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.lab.BaseExerciseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Mapper_Task_3_2 extends BaseExerciseTest {

    @Test
    @DisplayName("The VehicleToVehicleDbEntityMapper should return a valid vehicle instance")
    void vehicle_and_vin_should_be_created_successful() {
        VehicleDbEntity dbEntity = createExpectedVehicleDbEntity();
        Vehicle vehicle = mapVehicleDbEntityToVehicle(dbEntity);
        assertThat(vehicle).isEqualTo(createExpectedVehicle());
    }

    private Vehicle mapVehicleDbEntityToVehicle(VehicleDbEntity dbEntity) {
        return new VehicleToVehicleDbEntityMapper().mapVehicleDbEntityToVehicle(dbEntity);
    }
}
