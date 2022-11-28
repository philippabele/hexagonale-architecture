package com.hexaclean.arc.demo.lab.one;

import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.app.vehicle.domain.service.VehicleService;
import com.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbQuery;
import com.hexaclean.arc.demo.lab.BaseExerciseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class DomainRing_Task_1_2 extends BaseExerciseTest {

    @Test
    @DisplayName("The VehicleService should return a vehicle with the overgiven VIN")
    void vehicle_service_should_return_a_valid_vehicle() {
        VehicleDbQuery vehicleDbQuery = Mockito.mock(VehicleDbQuery.class);

        when(vehicleDbQuery.findVehicleByVin(new Vin(VIN))).thenReturn(createExpectedVehicle());

        Vin vin = new Vin(VIN);
        Vehicle vehicle = new VehicleService(vehicleDbQuery).findByVin(vin);
        assertThat(vehicle).isEqualTo(new Vehicle(new Vin(VIN)));
    }

}
