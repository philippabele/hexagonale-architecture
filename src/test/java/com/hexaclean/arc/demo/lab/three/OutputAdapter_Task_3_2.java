package com.hexaclean.arc.demo.lab.three;

import com.hexaclean.arc.demo.app.vehicle.adapter.out.VehicleRepository;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.VehicleToVehicleDbEntityMapper;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.lab.BaseExerciseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputAdapter_Task_3_2 extends BaseExerciseTest {

    @Test
    @DisplayName("The VehicleRepository should return a valid Vehicle")
    void vehicle_and_vin_should_be_created_successful() {
        Vehicle vehicle = findVehicleByVin();
        assertThat(vehicle).isEqualTo(createExpectedVehicle());
    }

    private Vehicle findVehicleByVin() {
        return createVehicleRepository().findVehicleByVin(new Vin(VIN));
    }

    private VehicleRepository createVehicleRepository() {
        return new VehicleRepository(new VehicleToVehicleDbEntityMapper());
    }

}
