package com.hexaclean.arc.demo.app.vehicle.domain.model;

import java.util.List;

public record VehicleMasterData(List<Equipment> equipmentList, VehicleModel vehicleModel,
                                SerialNumber serialNumber, MileageUnit mileageUnit) {

    public VehicleMasterData {
        if(equipmentList == null || equipmentList.isEmpty()) {
            throw new IllegalStateException("Equipment list should not null or empty");
        }

        if(vehicleModel == null || serialNumber == null || mileageUnit == null) {
            throw new IllegalStateException("One or more of VehicleModel, SerialNumber oer MileageUnit are null");
        }
    }

}
