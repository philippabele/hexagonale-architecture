package com.hexaclean.arc.demo.lab.five;


import com.hexaclean.arc.demo.app.vehicle.domain.dto.VehicleMasterDataDomainDto;
import com.hexaclean.arc.demo.app.vehicle.domain.model.*;
import com.hexaclean.arc.demo.lab.BaseExerciseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class DomainRing_Task_5_3 extends BaseExerciseTest {

    @Test
    @DisplayName("The vehicle supports 2G")
    void the_vehicle_supports_2G() {
        Vin vin = new Vin(VIN);
        Vehicle vehicle = new Vehicle(vin, createExpectedVehicleMotionData());
        VehicleMasterDataDomainDto masterData = createExpectedVehicleMasterDataDomainDtoHas2G();
        vehicle.addVehicleMasterData(masterData.vehicleModel(), masterData.serialNumber(), masterData.mileageUnit(), masterData.equipmentList());
        assertThat(vehicle.getVin()).isEqualTo(vin);
        assertThat(vehicle.isHas2GSupport()).isTrue();
    }


    @Test
    @DisplayName("The vehicle supports not 2G")
    void the_vehicle_supports_not_2G() {
        Vin vin = new Vin(VIN);
        Vehicle vehicle = new Vehicle(vin, createExpectedVehicleMotionData());
        VehicleMasterDataDomainDto masterData = createExpectedVehicleMasterDataDomainDto();
        vehicle.addVehicleMasterData(masterData.vehicleModel(), masterData.serialNumber(), masterData.mileageUnit(), masterData.equipmentList());
        assertThat(vehicle.getVin()).isEqualTo(vin);
        assertThat(vehicle.isHas2GSupport()).isFalse();
    }
}
