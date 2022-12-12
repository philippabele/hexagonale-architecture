/*package com.hexaclean.arc.demo.lab.five;

import com.hexaclean.arc.demo.app.vehicle.adapter.in.VehicleController;
import com.hexaclean.arc.demo.app.vehicle.adapter.in.VehicleToVehicleResourceMapperImpl;
import com.hexaclean.arc.demo.app.vehicle.adapter.in.resource.VehicleResource;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleQuery;
import com.hexaclean.arc.demo.lab.BaseExerciseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class InputAdapter_Task_5_2 extends BaseExerciseTest {

    @Test
    @DisplayName("The VehicleController should save a vehicle")
    void should_save_a_vehicle() {
        Vehicle expectedVehicle = createExpectedVehicle();
        VehicleResource vehicle = createVehicle(expectedVehicle);
        assertThat(vehicle.getVin()).isEqualTo(expectedVehicle.getVin().value());
        assertThat(vehicle.getLicensePlate()).isEqualTo(expectedVehicle.getVehicleMotionData().licensePlate().value());
        assertThat(vehicle.getMileage()).isEqualTo(expectedVehicle.getVehicleMotionData().mileage().value());
    }

    @Test
    @DisplayName("The VehicleController should update a vehicle")
    void should_update_a_vehicle() {
        Vehicle expectedVehicle = createExpectedVehicle();
        VehicleResource vehicle = updateVehicle(expectedVehicle);
        assertThat(vehicle.getVin()).isEqualTo(expectedVehicle.getVin().value());
        assertThat(vehicle.getLicensePlate()).isEqualTo(expectedVehicle.getVehicleMotionData().licensePlate().value());
        assertThat(vehicle.getMileage()).isEqualTo(expectedVehicle.getVehicleMotionData().mileage().value());
    }

    private VehicleResource createVehicle(Vehicle vehicleToSave) {
        VehicleQuery vehicleQuery = Mockito.mock(VehicleQuery.class);
        VehicleCommand vehicleCommand = Mockito.mock(VehicleCommand.class);
        when(vehicleCommand.create(vehicleToSave)).thenReturn(vehicleToSave);
        return new VehicleController(vehicleQuery, new VehicleToVehicleResourceMapperImpl(), vehicleCommand).createVehicle(createExpectedVehicleResource());
    }

    private VehicleResource updateVehicle(Vehicle vehicleToSave) {
        VehicleQuery vehicleQuery = Mockito.mock(VehicleQuery.class);
        VehicleCommand vehicleCommand = Mockito.mock(VehicleCommand.class);
        when(vehicleCommand.update(vehicleToSave.getVin(), vehicleToSave.getVehicleMotionData())).thenReturn(vehicleToSave);
        return new VehicleController(vehicleQuery, new VehicleToVehicleResourceMapperImpl(), vehicleCommand).updateVehicle(vehicleToSave.getVin().value(), createExpectedVehicleMotionDataResource());
    }

}*/
