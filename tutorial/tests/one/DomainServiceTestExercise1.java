package com.daimler.dcp.clean.arc.demo.exercises.one;


import com.daimler.dcp.clean.arc.demo.vehicle.domain.model.Vehicle;
import com.daimler.dcp.clean.arc.demo.vehicle.domain.model.Vin;
import com.daimler.dcp.clean.arc.demo.vehicle.domain.service.VehicleService;
import com.daimler.dcp.clean.arc.demo.exercises.BaseExerciseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DomainServiceTestExercise1 extends BaseExerciseTest {

    @Test
    @DisplayName("The VehicleService should return a vehicle with the overgiven VIN")
    void vehicle_service_should_return_a_valid_vehicle() {
        Vin vin = new Vin(VIN);
        Vehicle vehicle = new VehicleService().readVehicle(vin);
        assertThat(vehicle).isEqualTo(new Vehicle(vin));
    }

}
