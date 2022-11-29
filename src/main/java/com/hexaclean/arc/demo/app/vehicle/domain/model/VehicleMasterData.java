package com.hexaclean.arc.demo.app.vehicle.domain.model;

import java.util.List;

public record VehicleMasterData(VehicleModel vehicleModel,
                                SerialNumber serialNumber, MileageUnit mileageUnit, List<Equipment> equipmentList) {

    public VehicleMasterData {

        if (vehicleModel == null || serialNumber == null || mileageUnit == null) {
            throw new IllegalStateException("One or more of VehicleModel, SerialNumber oer MileageUnit are null");
        }
    }

}
