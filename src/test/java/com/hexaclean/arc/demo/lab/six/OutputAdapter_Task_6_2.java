package com.hexaclean.arc.demo.lab.six;

import com.hexaclean.arc.demo.app.garage.order.adapter.out.vehicle.VehicleModuleClient;
import com.hexaclean.arc.demo.app.garage.order.adapter.out.vehicle.VehicleToOriginVehicleMapper;
import com.hexaclean.arc.demo.app.garage.order.domain.model.vehicle.Vehicle;
import com.hexaclean.arc.demo.app.vehicle.domain.model.LicensePlate;
import com.hexaclean.arc.demo.app.vehicle.usecase.in.FindVehicleByLicensePlate;
import com.hexaclean.arc.demo.lab.BaseExerciseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class OutputAdapter_Task_6_2 extends BaseExerciseTest {

    @Test
    @DisplayName("The VehicleModuleClient should return a vehicle")
    void vehicle_and_vin_should_be_created_successful() {
        LicensePlate licensePlate = new LicensePlate(LICENSE_PLATE_TEST_VALUE);
        FindVehicleByLicensePlate findVehicleByLicensePlate = Mockito.mock(FindVehicleByLicensePlate.class);
        when(findVehicleByLicensePlate.findByLicensePlate(licensePlate)).thenReturn(createExpectedVehicle());

        Vehicle vehicle = new VehicleModuleClient(findVehicleByLicensePlate, new VehicleToOriginVehicleMapper())
                .fetch(new com.hexaclean.arc.demo.app.garage.order.domain.model.vehicle.LicensePlate(LICENSE_PLATE_TEST_VALUE));
        com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle expectedVehicle = createExpectedVehicle();
        assertThat(vehicle.vin().value()).isEqualTo(expectedVehicle.getVin().value());
        assertThat(vehicle.licencePlate().value()).isEqualTo(expectedVehicle.getVehicleMotionData().licensePlate().value());
    }

}
