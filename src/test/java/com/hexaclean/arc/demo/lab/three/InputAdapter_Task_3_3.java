package com.hexaclean.arc.demo.lab.three;

import com.hexaclean.arc.demo.app.vehicle.adapter.in.VehicleController;
import com.hexaclean.arc.demo.app.vehicle.adapter.in.VehicleToVehicleResourceMapperImpl;
import com.hexaclean.arc.demo.app.vehicle.adapter.in.resource.VehicleResource;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleQuery;
import com.hexaclean.arc.demo.lab.BaseExerciseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class InputAdapter_Task_3_3 extends BaseExerciseTest {

    @Test
    @DisplayName("VehicleController should return a valid vehicle")
    void vehicle_controller_should_return_a_valid_vehicle() {
        VehicleQuery vehicleQuery = Mockito.mock(VehicleQuery.class);
        when(vehicleQuery.findByVin(new Vin(VIN))).thenReturn(createExpectedVehicle());

        VehicleResource vehicle = createVehicleController(vehicleQuery).readVehicle(VIN);
        assertThat(vehicle.getVin()).isEqualTo(createExpectedVehicleResource().getVin());
    }

    private VehicleController createVehicleController(VehicleQuery vehicleQuery) {
        return new VehicleController(vehicleQuery, new VehicleToVehicleResourceMapperImpl());
    }

}
