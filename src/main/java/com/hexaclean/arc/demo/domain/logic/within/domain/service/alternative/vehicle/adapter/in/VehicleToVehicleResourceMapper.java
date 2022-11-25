package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.in;

import com.clean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.*;
import com.daimler.dcp.clean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.*;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.in.resource.EquipmentResource;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.in.resource.VehicleCommandResource;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.in.resource.VehicleResource;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.dto.EquipmentCodeDomainDto;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.dto.EquipmentDomainDto;
import com.daimler.dcp.clean.arc.demo.service.alternative.vehicle.domain.model.*;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.*;

public class VehicleToVehicleResourceMapper {

    public Vehicle mapVehicleResourceToVehicle(VehicleResource resource) {
        return new Vehicle(new Vin(resource.getVin()), mapToVehicleMotionData(resource), mapToVehicleMasterData(resource));
    }

    public VehicleResource mapVehicleToVehicleResource(Vehicle entity) {
        VehicleResource resource = new VehicleResource();
        resource.setLicensePlate(entity.getVehicleMotionData().licensePlate().value());
        resource.setMileage(entity.getVehicleMotionData().mileage().value());
        resource.setMileageUnit(entity.getVehicleMasterData().mileageUnit().toString());
        resource.setVin(entity.getVin().value());
        resource.setSerialNumber(entity.getVehicleMasterData().serialNumber().value());
        resource.setVehicleModelName(entity.getVehicleMasterData().vehicleModel().modelDescription());
        resource.setVehicleModelType(entity.getVehicleMasterData().vehicleModel().modelType());
        resource.setHas2GSupport(entity.getVehicleMasterData().has2GSupport());
        return resource;
    }

    public VehicleMotionData mapVehicleResourceToVehicleMotionData(VehicleCommandResource resource) {
        return mapToVehicleMotionData(resource);
    }

    private EquipmentResource mapToEquipmentResource(EquipmentDomainDto entity) {
        EquipmentResource resource = new EquipmentResource();
        resource.setCode(entity.code().value());
        resource.setDescription(entity.description());
        return resource;
    }

    private VehicleMasterData mapToVehicleMasterData(VehicleResource resource) {
        VehicleModel vehicleModel = new VehicleModel(resource.getVehicleModelName(), resource.getVehicleModelType());
        SerialNumber serialNumber = new SerialNumber(resource.getSerialNumber());
        return new VehicleMasterData(resource.isHas2GSupport(), vehicleModel, serialNumber, new MileageUnit(MileageUnitValue.valueOf(resource.getMileageUnit())));
    }

    private EquipmentDomainDto mapToEquipment(EquipmentResource resource) {
        return new EquipmentDomainDto(new EquipmentCodeDomainDto(resource.getCode()), resource.getDescription());
    }

    private VehicleMotionData mapToVehicleMotionData(VehicleCommandResource resource) {
        return createVehicleMotionData(resource.getLicensePlate(), resource.getMileage(), resource.getRegistrationCountry());
    }

    private VehicleMotionData mapToVehicleMotionData(VehicleResource resource) {
        return createVehicleMotionData(resource.getLicensePlate(), resource.getMileage(), resource.getRegistrationCountry());
    }

    private VehicleMotionData createVehicleMotionData(String licensePlate, double mileage, String registrationCountry) {
        return new VehicleMotionData(new LicensePlate(licensePlate), new Mileage(mileage), new RegistrationCountry(registrationCountry));
    }
}
