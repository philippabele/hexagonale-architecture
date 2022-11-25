package com.hexaclean.arc.demo.exercises.three.one;


import com.hexaclean.arc.demo.exercises.BaseExerciseTest;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.entity.VehicleDbEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class DbEntityTestExercise3_1 extends BaseExerciseTest {

    @Test
    @DisplayName("A instance of VehicleDbEntity should be created and should contains a value fo the vin")
    void vehicle_and_vin_should_be_created_successful() {
        VehicleDbEntity vehicle = createVehicleDbEntity();
        assertThat(vehicle.getVin()).isEqualTo(VIN);
    }

}
