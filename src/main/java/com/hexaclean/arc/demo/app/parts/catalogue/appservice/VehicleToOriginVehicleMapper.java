package com.hexaclean.arc.demo.app.parts.catalogue.appservice;

import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.vehicle.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VehicleToOriginVehicleMapper {

    @Mapping(target = "vin", source = "vin.value")
    @Mapping(target = "vehicleModel.modelDescription", source = "vehicleMasterData.vehicleModel.modelDescription")
    @Mapping(target = "vehicleModel.modelType", source = "vehicleMasterData.vehicleModel.modelType")
    @Mapping(target = "has2GSupport", source = "has2GSupport")
    Vehicle mapOriginVehicleToVehicle(com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle origin);

}
