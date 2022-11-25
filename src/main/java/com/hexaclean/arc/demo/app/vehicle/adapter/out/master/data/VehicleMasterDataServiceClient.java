package com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data;

import com.hexaclean.arc.demo.app.vehicle.domain.model.VehicleMasterData;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.app.vehicle.usecase.out.FetchVehicleMasterData;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data.dto.VehicleDto;

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
