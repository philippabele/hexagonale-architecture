package com.hexaclean.arc.demo.lab.three;


import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.entity.VehicleDbEntity;
import com.hexaclean.arc.demo.lab.BaseExerciseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class DbEntity_Task_3_1 extends BaseExerciseTest {

    @Test
    @DisplayName("A instance of VehicleDbEntity should be created and should contains a value fo the vin")
    void vehicle_and_vin_should_be_created_successful() {
        VehicleDbEntity vehicle = createExpectedVehicleDbEntity();
        assertThat(vehicle.getVin()).isEqualTo(VIN);
    }

}
