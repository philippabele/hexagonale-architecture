package com.hexaclean.arc.demo.exercises.one;


import com.hexaclean.arc.demo.exercises.BaseExerciseTest;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class DomainModelTestExercise1 extends BaseExerciseTest {

    @Test
    @DisplayName("A vehicle can only created with a valid vin.")
    void should_throw_illegal_state_exception_due_to_invalid_vin() {
        assertThrows(IllegalStateException.class, () -> new Vehicle(new Vin("hgjhgkjhkhkhjh"), null, null));
    }

    @Test
    @DisplayName("A vehicle can only created with a valid vin.")
    void should_throw_illegal_state_exception_due_to_null_for_vin() {
        assertThrows(IllegalStateException.class, () -> new Vehicle(null, null, null));
    }

    @Test
    @DisplayName("A valid vehicle is created")
    void vehicle_and_vin_should_be_created_successful() {
        Vin vin = new Vin(VIN);
        Vehicle vehicle = createExpectedVehicle();
        assertThat(vehicle.getVin()).isEqualTo(vin);
    }

}
