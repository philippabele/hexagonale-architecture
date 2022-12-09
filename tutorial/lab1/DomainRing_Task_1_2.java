package com.hexaclean.arc.demo.app.lab.one;

import com.hexaclean.arc.demo.app.lab.BaseExerciseTest;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.app.vehicle.domain.service.VehicleService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DomainRing_Task_1_2 extends BaseExerciseTest {

    @Test
    void vehicle_service_should_return_a_valid_vehicle() {
        Vin vin = new Vin(VIN);
        Vehicle vehicle = new VehicleService().findByVin(vin);
        assertThat(vehicle).isEqualTo(new Vehicle(new Vin(VIN)));
    }

}
