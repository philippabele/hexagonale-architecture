package com.hexaclean.arc.demo.supporting.service.vehicle.masterdata.service;

import com.hexaclean.arc.demo.supporting.service.vehicle.masterdata.model.VehicleMasterData;
import com.hexaclean.arc.demo.supporting.service.vehicle.masterdata.model.Vin;
import com.hexaclean.arc.demo.supporting.service.vehicle.masterdata.usecase.in.ReadVehicleMasterData;
import com.hexaclean.arc.demo.supporting.service.vehicle.masterdata.usecase.out.FetchVehicleMasterData;

public class VehicleMasterDataService implements ReadVehicleMasterData {

    private FetchVehicleMasterData fetchVehicleMasterData;

    public VehicleMasterDataService(FetchVehicleMasterData fetchVehicleMasterData) {
        this.fetchVehicleMasterData = fetchVehicleMasterData;
    }

    @Override
    public VehicleMasterData read(Vin vin) {
        return fetchVehicleMasterData.fetch(vin);
    }
}
