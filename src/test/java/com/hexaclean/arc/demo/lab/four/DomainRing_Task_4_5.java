package com.hexaclean.arc.demo.lab.four;

import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.app.vehicle.domain.service.VehicleService;
import com.hexaclean.arc.demo.app.vehicle.usecase.out.FetchVehicleMasterData;
import com.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbQuery;
import com.hexaclean.arc.demo.lab.BaseExerciseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class DomainRing_Task_4_5 extends BaseExerciseTest {

    @Test
    @DisplayName("The VehicleService should implement the orchestration between different outgoing use cases")
    void vehicle_service_should_return_a_valid_vehicle() {
        Vin vin = new Vin(VIN);

        VehicleDbQuery vehicleDbQuery = Mockito.mock(VehicleDbQuery.class);
        when(vehicleDbQuery.findVehicleByVin(vin)).thenReturn(createExpectedVehicle());

        FetchVehicleMasterData fetchVehicleMasterData = Mockito.mock(FetchVehicleMasterData.class);
        when(fetchVehicleMasterData.fetch(vin)).thenReturn(createExpectedVehicleMasterData());

        Vehicle vehicle = new VehicleService(vehicleDbQuery, fetchVehicleMasterData).findByVin(vin);
        Vehicle expectedVehicle = createExpectedVehicle();

        assertThat(vehicle).isEqualTo(expectedVehicle);
        assertThat(vehicle.getVehicleMasterData().vehicleModel().modelType()).isEqualTo(expectedVehicle.getVehicleMasterData().vehicleModel().modelType());
        assertThat(vehicle.getVehicleMasterData().vehicleModel().modelDescription()).isEqualTo(expectedVehicle.getVehicleMasterData().vehicleModel().modelDescription());
        assertThat(vehicle.getVehicleMasterData().mileageUnit()).isEqualTo(expectedVehicle.getVehicleMasterData().mileageUnit());
        assertThat(vehicle.getVehicleMasterData().serialNumber()).isEqualTo(expectedVehicle.getVehicleMasterData().serialNumber());
        assertThat(vehicle.getVehicleMasterData().equipmentList()).hasSize(3);
        assertThat(vehicle.getVin()).isEqualTo(expectedVehicle.getVin());
        assertThat(vehicle.getVehicleMotionData().licensePlate()).isEqualTo(expectedVehicle.getVehicleMotionData().licensePlate());
        assertThat(vehicle.getVehicleMotionData().mileage()).isEqualTo(expectedVehicle.getVehicleMotionData().mileage());
    }

}
