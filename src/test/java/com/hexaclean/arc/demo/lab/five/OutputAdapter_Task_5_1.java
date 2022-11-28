package com.hexaclean.arc.demo.lab.five;

import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.VehicleRepository;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.VehicleToVehicleDbEntityMapper;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.lab.BaseExerciseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputAdapter_Task_5_1 extends BaseExerciseTest {

    @Test
    @DisplayName("The VehicleRepository should return a valid Vehicle")
    void vehicle_and_vin_should_be_created_successful() {
        Vehicle vehicle = findVehicleByVin();
        Vehicle expectedVehicle = createExpectedVehicle();
        assertThat(vehicle.getVin()).isEqualTo(expectedVehicle.getVin());
        assertThat(vehicle.getVehicleMotionData().licensePlate()).isEqualTo(expectedVehicle.getVehicleMotionData().licensePlate());
        assertThat(vehicle.getVehicleMotionData().mileage()).isEqualTo(expectedVehicle.getVehicleMotionData().mileage());
    }

    private Vehicle findVehicleByVin() {
        return createVehicleRepository().findVehicleByVin(new Vin(VIN));
    }

    private VehicleRepository createVehicleRepository() {
        return new VehicleRepository(new VehicleToVehicleDbEntityMapper());
    }

}
