package com.daimler.dcp.clean.arc.demo.exercises.two.one;

import com.daimler.dcp.clean.arc.demo.exercises.BaseExerciseTest;
import com.daimler.dcp.clean.arc.demo.vehicle.adapter.in.VehicleController;
import com.daimler.dcp.clean.arc.demo.vehicle.domain.model.Vehicle;
import com.daimler.dcp.clean.arc.demo.vehicle.domain.model.Vin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ControllerTestExercise2_1 extends BaseExerciseTest {

    @Test
    @DisplayName("VehicleController should return a valid vehicle")
    void vehicle_controller_should_return_a_valid_vehicle() {
        Vehicle vehicle = new VehicleController().readVehicle(VIN);
        assertThat(vehicle).isEqualTo(new Vehicle(new Vin(VIN)));
    }
}
