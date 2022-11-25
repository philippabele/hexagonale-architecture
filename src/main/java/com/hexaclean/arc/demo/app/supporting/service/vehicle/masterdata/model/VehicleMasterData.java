package com.hexaclean.arc.demo.app.supporting.service.vehicle.masterdata.model;

import java.util.List;

public record VehicleMasterData(List<Equipment> equipmentList, VehicleModel vehicleModel, SerialNumber serialNumber,
                                MileageUnit mileageUnit) {
}
