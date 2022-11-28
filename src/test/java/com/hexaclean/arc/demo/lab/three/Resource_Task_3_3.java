package com.hexaclean.arc.demo.lab.three;


import com.hexaclean.arc.demo.app.vehicle.adapter.in.resource.VehicleResource;
import com.hexaclean.arc.demo.lab.BaseExerciseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class Resource_Task_3_3 extends BaseExerciseTest {

    @Test
    @DisplayName("A instance of VehicleResource should be created and should contains a value fo the vin")
    void vehicle_and_vin_should_be_created_successful() {
        VehicleResource vehicle = createExpectedVehicleResource();
        assertThat(vehicle.getVin()).isEqualTo(VIN);
    }

    protected VehicleResource createExpectedVehicleResource() {
        VehicleResource vehicle = new VehicleResource();
        vehicle.setVin(VIN);
        return vehicle;
    }

}
