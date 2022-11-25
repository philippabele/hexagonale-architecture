package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.dto;


import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.MileageUnit;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.SerialNumber;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.VehicleModel;

import java.util.List;

public record VehicleMasterDataDomainDto(
        List<EquipmentDomainDto> equipmentList,
        VehicleModel vehicleModel, MileageUnit mileageUnit, SerialNumber serialNumber) {
}
