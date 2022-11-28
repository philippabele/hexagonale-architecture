package com.hexaclean.arc.demo.lab.four;


import com.hexaclean.arc.demo.app.vehicle.domain.model.*;
import com.hexaclean.arc.demo.lab.BaseExerciseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class DomainRing_Task_4_1 extends BaseExerciseTest {

    @Test
    @DisplayName("A vehicle can only created with a valid vin.")
    void should_throw_illegal_state_exception_due_to_invalid_vin() {
        assertThrows(Exception.class, () -> new Vehicle(new Vin("hjkhjkhkjh"), createExpectedVehicleMotionData()));
    }

    @Test
    @DisplayName("A vehicle can only created with valid vehicle motion data")
    void should_throw_illegal_state_exception_due_to_null_vehicle_motion_data() {
        assertThrows(Exception.class, () -> new Vehicle(new Vin(VIN), null));
    }

    @Test
    @DisplayName("A vehicle can only created with a valid vin.")
    void should_throw_illegal_state_exception_due_to_null_for_vin() {
        assertThrows(Exception.class, () -> new Vehicle(null, createExpectedVehicleMotionData()));
    }

    @Test
    @DisplayName("A valid vehicle is created")
    void vehicle_and_vin_should_be_created_successful() {
        Vin vin = new Vin(VIN);
        Vehicle vehicle = new Vehicle(vin, createExpectedVehicleMotionData());
        assertThat(vehicle.getVin()).isEqualTo(vin);
    }

    @Test
    @DisplayName("Valid vehicle motion data are created")
    void vehicle_motion_data_should_be_successfully_created() {
        VehicleMotionData motionData = new VehicleMotionData(new LicensePlate(LICENSE_PLATE_TEST_VALUE),
                new Mileage(MILEAGE_TEST_VALUE));
        assertThat(motionData).isNotNull();
    }

    @Test
    @DisplayName("Vehicle motion data is not valid due to negative mileage")
    void vehicle_motion_data_is_invalid_due_to_negative_mileage() {
        assertThrows(Exception.class, () -> new VehicleMotionData(
                new LicensePlate(LICENSE_PLATE_TEST_VALUE),
                new Mileage(-0.1)));
    }

    @Test
    @DisplayName("Vehicle motion data is not valid due to null license plate")
    void vehicle_motion_data_is_invalid_due_to_null_license_plate() {
        assertThrows(Exception.class, () -> new VehicleMotionData(
                null, new Mileage(MILEAGE_TEST_VALUE)));
    }

    @Test
    @DisplayName("Vehicle motion data is not valid due to null value for license plate")
    void vehicle_motion_data_is_invalid_due_to_null_value_for_license_plate() {
        assertThrows(Exception.class, () -> new VehicleMotionData(
                new LicensePlate(null),
                new Mileage(MILEAGE_TEST_VALUE)));
    }

    @Test
    @DisplayName("Vehicle motion data is not valid due to null license plate")
    void vehicle_motion_data_is_invalid_due_to_wrong_license_plate() {
        assertThrows(Exception.class, () -> new VehicleMotionData(
                new LicensePlate("Test0815"),
                new Mileage(MILEAGE_TEST_VALUE)));
    }

}
