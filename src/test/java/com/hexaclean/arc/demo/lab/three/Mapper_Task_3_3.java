package com.hexaclean.arc.demo.lab.three;

import com.hexaclean.arc.demo.app.vehicle.adapter.in.VehicleToVehicleResourceMapperImpl;
import com.hexaclean.arc.demo.app.vehicle.adapter.in.resource.VehicleResource;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.lab.BaseExerciseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Mapper_Task_3_3 extends BaseExerciseTest {

    @Test
    @DisplayName("The VehicleToVehicleResourceMapper should return a valid vehicle instance")
    void vehicle_and_vin_should_be_created_successful() {
        VehicleResource resource = createExpectedVehicleResource();
        Vehicle vehicle = mapVehicleResourceToVehicle(resource);
        assertThat(vehicle).isEqualTo(createExpectedVehicle());
    }

    private Vehicle mapVehicleResourceToVehicle(VehicleResource resource) {
        return new VehicleToVehicleResourceMapperImpl().mapVehicleResourceToVehicle(resource);
    }
}
