package com.daimler.dcp.clean.arc.demo.exercises.two.three;

import com.daimler.dcp.clean.arc.demo.exercises.BaseExerciseTest;
import com.daimler.dcp.clean.arc.demo.vehicle.adapter.out.VehicleRepository;
import com.daimler.dcp.clean.arc.demo.vehicle.domain.model.Vehicle;
import com.daimler.dcp.clean.arc.demo.vehicle.domain.model.Vin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositoryTestExercise2_3 extends BaseExerciseTest {

    @Test
    @DisplayName("The VehicleRepository should return a valid Vehicle")
    void vehicle_and_vin_should_be_created_successful() {
        Vehicle vehicle = new VehicleRepository().findVehicleByVin(new Vin(VIN));
        assertThat(vehicle).isEqualTo(new Vehicle(new Vin(VIN)));
    }

}
