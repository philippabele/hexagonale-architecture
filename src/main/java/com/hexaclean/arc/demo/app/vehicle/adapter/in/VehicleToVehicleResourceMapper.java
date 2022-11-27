package com.hexaclean.arc.demo.app.vehicle.adapter.in;

import com.hexaclean.arc.demo.app.vehicle.adapter.in.resource.VehicleResource;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface VehicleToVehicleResourceMapper {

    @Mapping(source = "vin", target = "vin.value")
    Vehicle mapVehicleResourceToVehicle(VehicleResource resource);

    @Mapping(target = "vin", source = "vin.value")
    VehicleResource mapVehicleToVehicleResource(Vehicle entity);

}
