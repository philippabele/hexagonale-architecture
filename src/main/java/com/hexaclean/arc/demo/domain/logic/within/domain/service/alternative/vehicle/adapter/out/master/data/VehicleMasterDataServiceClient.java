package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.out.master.data;

import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.out.master.data.dto.VehicleDto;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.dto.VehicleMasterDataDomainDto;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.usecase.out.FetchVehicleMasterData;

public class VehicleMasterDataServiceClient implements FetchVehicleMasterData {

    private VehicleToVehicleDtoMapper mapper;

    public VehicleMasterDataServiceClient(VehicleToVehicleDtoMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public VehicleMasterDataDomainDto fetch(Vin vin) {
        return mapper.mapVehicleDtoToVehicleMasterData(new VehicleDto());
    }
}
