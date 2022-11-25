package com.hexaclean.arc.demo.app.supporting.service.vehicle.masterdata.usecase.in;

import com.hexaclean.arc.demo.app.supporting.service.vehicle.masterdata.model.VehicleMasterData;
import com.hexaclean.arc.demo.app.supporting.service.vehicle.masterdata.model.Vin;

public interface ReadVehicleMasterData {
    VehicleMasterData read(Vin vin);
}
