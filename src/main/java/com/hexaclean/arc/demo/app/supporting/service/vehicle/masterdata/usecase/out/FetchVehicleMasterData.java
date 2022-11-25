package com.hexaclean.arc.demo.app.supporting.service.vehicle.masterdata.usecase.out;

import com.hexaclean.arc.demo.app.supporting.service.vehicle.masterdata.model.VehicleMasterData;
import com.hexaclean.arc.demo.app.supporting.service.vehicle.masterdata.model.Vin;

public interface FetchVehicleMasterData {
    VehicleMasterData fetch(Vin vin);
}
