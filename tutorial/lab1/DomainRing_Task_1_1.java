package com.hexaclean.arc.demo.app.lab.one;

import com.hexaclean.arc.demo.app.lab.BaseExerciseTest;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class DomainRing_Task_1_1 extends BaseExerciseTest {

    @Test
    void should_throw_illegal_state_exception_due_to_invalid_vin() {
        assertThrows(Exception.class, () -> new Vehicle(new Vin("hgjhgkjhkhkhjh")));
    }

    @Test
    void should_throw_illegal_state_exception_due_to_null_for_vin() {
        assertThrows(Exception.class, () -> new Vehicle(null));
    }

    @Test
    void vehicle_and_vin_should_be_created_successful() {
        Vin vin = new Vin(VIN);
        Vehicle vehicle = new Vehicle(vin);
        assertThat(vehicle.getVin()).isEqualTo(vin);
    }

}
