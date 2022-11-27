package com.hexaclean.arc.demo.app.vehicle.domain.dto;


import com.hexaclean.arc.demo.app.vehicle.domain.model.MileageUnit;
import com.hexaclean.arc.demo.app.vehicle.domain.model.SerialNumber;
import com.hexaclean.arc.demo.app.vehicle.domain.model.VehicleModel;

import java.util.List;

public record VehicleMasterDataDomainDto(
        List<String> equipmentList,
        VehicleModel vehicleModel, MileageUnit mileageUnit, SerialNumber serialNumber) {
}
