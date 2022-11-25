package com.hexaclean.arc.demo.app.parts.catalogue.appservice;

import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.vehicle.Equipment;
import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.vehicle.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VehicleToOriginVehicleMapper {

    @Mapping(target = "vin.value", source = "vin.value")
    @Mapping(target = "vehicleModel.modelDescription", source = "vehicleModel.modelDescription")
    @Mapping(target = "vehicleModel.modelType", source = "vehicleModel.modelType")
    @Mapping(target = "equipmentList", source = "equipmentList")
    Vehicle mapOriginVehicleToVehicle(com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle origin);

    @Mapping(target = "code", source = "code.value")
    @Mapping(target = "description", source = "description")
    Equipment mapOriginEquipmentToEquipment(com.hexaclean.arc.demo.app.vehicle.domain.model.Equipment origin);

}
