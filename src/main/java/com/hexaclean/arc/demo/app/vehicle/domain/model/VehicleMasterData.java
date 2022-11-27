package com.hexaclean.arc.demo.app.vehicle.domain.model;

public record VehicleMasterData(VehicleModel vehicleModel,
                                SerialNumber serialNumber, MileageUnit mileageUnit) {

    public VehicleMasterData {

        if (vehicleModel == null || serialNumber == null || mileageUnit == null) {
            throw new IllegalStateException("One or more of VehicleModel, SerialNumber oer MileageUnit are null");
        }
    }

}
