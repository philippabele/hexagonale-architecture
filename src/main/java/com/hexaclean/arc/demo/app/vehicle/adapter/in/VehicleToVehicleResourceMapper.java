package com.hexaclean.arc.demo.app.vehicle.adapter.in;

import com.hexaclean.arc.demo.app.vehicle.adapter.in.resource.EquipmentResource;
import com.hexaclean.arc.demo.app.vehicle.adapter.in.resource.VehicleResource;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Equipment;
import com.hexaclean.arc.demo.app.vehicle.domain.model.MileageUnit;
import com.hexaclean.arc.demo.app.vehicle.domain.model.MileageUnitValue;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper
public interface VehicleToVehicleResourceMapper {

    @Mapping(source = "licensePlate", target = "vehicleMotionData.licensePlate.value")
    @Mapping(source = "registrationCountry", target = "vehicleMotionData.registrationCountry.value")
    @Mapping(source = "mileage", target = "vehicleMotionData.mileage.value")
    @Mapping(source = "mileageUnit", target = "vehicleMasterData.mileageUnit", qualifiedByName = "mapToMileageUnit")
    @Mapping(source = "vehicleModelName", target = "vehicleMasterData.vehicleModel.modelDescription")
    @Mapping(source = "vehicleModelType", target = "vehicleMasterData.vehicleModel.modelType")
    @Mapping(source = "serialNumber", target = "vehicleMasterData.serialNumber.value")
    @Mapping(source = "vin", target = "vin.value")
    @Mapping(source = "equipmentList", target = "vehicleMasterData.equipmentList")
    Vehicle mapVehicleResourceToVehicle(VehicleResource resource);

    @Named("mapToMileageUnit")
    static MileageUnit mapToMileageUnit(String mileageUnit) {
        return new MileageUnit(MileageUnitValue.valueOf(mileageUnit));
    }

    @Mapping(source = "code", target = "code.value")
    @Mapping(source = "description", target = "description")
    Equipment mapEquipmentResourceToEquipment(EquipmentResource resource);

    @Mapping(target = "licensePlate", source = "vehicleMotionData.licensePlate.value")
    @Mapping(target = "registrationCountry", source = "vehicleMotionData.registrationCountry.value")
    @Mapping(target = "mileage", source = "vehicleMotionData.mileage.value")
    @Mapping(target = "mileageUnit", source = "vehicleMasterData.mileageUnit", qualifiedByName = "mapToMileageUnitPrimitive")
    @Mapping(target = "vehicleModelName", source = "vehicleMasterData.vehicleModel.modelDescription")
    @Mapping(target = "vehicleModelType", source = "vehicleMasterData.vehicleModel.modelType")
    @Mapping(target = "serialNumber", source = "vehicleMasterData.serialNumber.value")
    @Mapping(target = "vin", source = "vin.value")
    @Mapping(target = "equipmentList", source = "vehicleMasterData.equipmentList")
    VehicleResource mapVehicleToVehicleResource(Vehicle entity);

    @Mapping(target = "code", source = "code.value")
    @Mapping(target = "description", source = "description")
    EquipmentResource mapToEquipmentResource(Equipment entity);

    @Named("mapToMileageUnitPrimitive")
    static String mapToMileageUnitPrimitive(MileageUnit mileageUnit) {
        return mileageUnit.value().toString();
    }
}
