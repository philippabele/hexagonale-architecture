package com.hexaclean.arc.demo.app.supporting.service.vehicle.masterdata.adapter.out;

import com.hexaclean.arc.demo.app.supporting.service.vehicle.masterdata.adapter.out.dto.VehicleDto;
import com.hexaclean.arc.demo.app.supporting.service.vehicle.masterdata.model.VehicleMasterData;
import com.hexaclean.arc.demo.app.supporting.service.vehicle.masterdata.model.Vin;
import com.hexaclean.arc.demo.app.supporting.service.vehicle.masterdata.usecase.out.FetchVehicleMasterData;

public class VehicleMasterDataServiceClient implements FetchVehicleMasterData {

    private VehicleToVehicleDtoMapper mapper;

    public VehicleMasterDataServiceClient(VehicleToVehicleDtoMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public VehicleMasterData fetch(Vin vin) {
        return mapper.mapVehicleDtoToVehicleMasterData(new VehicleDto());
    }
}
