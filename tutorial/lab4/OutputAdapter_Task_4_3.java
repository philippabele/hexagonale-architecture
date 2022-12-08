package com.hexaclean.arc.demo.lab.four;

import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.app.vehicle.domain.model.VehicleMasterData;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.lab.BaseExerciseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputAdapter_Task_4_3 extends BaseExerciseTest {

    @Test
    @DisplayName("The VehicleMasterDataServiceClient should return vehicle master data")
    void should_return_vehicle_master_data() {

        Vehicle vehicle = createExpectedVehicle();
        vehicle.addVehicleMasterData(createExpectedVehicleMasterData());

        VehicleMasterData vehicleMasterData = new VehicleMasterDataServiceClient(new VehicleToVehicleDataDtoMapper()).fetch(new Vin(VIN));

        assertThat(vehicleMasterData.vehicleModel().modelType()).isEqualTo(vehicle.getVehicleMasterData().vehicleModel().modelType());
        assertThat(vehicleMasterData.vehicleModel().modelDescription()).isEqualTo(vehicle.getVehicleMasterData().vehicleModel().modelDescription());
        assertThat(vehicleMasterData.mileageUnit()).isEqualTo(vehicle.getVehicleMasterData().mileageUnit());
        assertThat(vehicleMasterData.serialNumber()).isEqualTo(vehicle.getVehicleMasterData().serialNumber());
        assertThat(vehicleMasterData.equipmentList()).hasSize(3);
    }

}
