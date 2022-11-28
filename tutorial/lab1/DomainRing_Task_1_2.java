package com.hexaclean.arc.demo.lab.one;

import com.hexaclean.arc.demo.app.vehicle.domain.service.VehicleService;
import com.hexaclean.arc.demo.lab.BaseExerciseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DomainRing_Task_1_2 extends BaseExerciseTest {

    @Test
    @DisplayName("The VehicleService should return a vehicle with the overgiven VIN")
    void vehicle_service_should_return_a_valid_vehicle() {
        Vin vin = new Vin(VIN);
        Vehicle vehicle = new VehicleService().findByVin(vin);
        assertThat(vehicle).isEqualTo(new Vehicle(new Vin(VIN)));
    }

}
