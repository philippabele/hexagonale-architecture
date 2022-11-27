package com.hexaclean.arc.demo.app.vehicle.usecase.out;

import com.hexaclean.arc.demo.app.vehicle.domain.dto.VehicleMasterDataDomainDto;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;

public interface FetchVehicleMasterData {
    VehicleMasterDataDomainDto fetch(Vin vin);
}
