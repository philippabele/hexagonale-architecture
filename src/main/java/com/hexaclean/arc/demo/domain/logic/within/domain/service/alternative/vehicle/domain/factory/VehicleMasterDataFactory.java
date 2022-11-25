package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.factory;

import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.dto.VehicleMasterDataDomainDto;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.VehicleMasterData;
import org.springframework.stereotype.Component;

@Component
public class VehicleMasterDataFactory {

    public VehicleMasterData create(VehicleMasterDataDomainDto domainDto, boolean has2GSupport) {
        return new VehicleMasterData(has2GSupport,
                domainDto.vehicleModel(),
                domainDto.serialNumber(),
                domainDto.mileageUnit());
    }
}
