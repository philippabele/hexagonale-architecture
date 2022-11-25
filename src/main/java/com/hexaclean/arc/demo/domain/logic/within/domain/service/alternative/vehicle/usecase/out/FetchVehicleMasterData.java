package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.usecase.out;

import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.dto.VehicleMasterDataDomainDto;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.Vin;

public interface FetchVehicleMasterData {
    VehicleMasterDataDomainDto fetch(Vin vin);
}
