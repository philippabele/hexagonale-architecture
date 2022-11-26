package com.hexaclean.arc.demo.app.vehicle.adapter.in;

import com.hexaclean.arc.demo.app.vehicle.adapter.in.resource.EquipmentResource;
import com.hexaclean.arc.demo.app.vehicle.adapter.in.resource.VehicleCommandResource;
import com.hexaclean.arc.demo.app.vehicle.adapter.in.resource.VehicleResource;
import com.hexaclean.arc.demo.app.vehicle.domain.model.*;

import java.util.List;
import java.util.stream.Collectors;

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
        resource.setEquipmentList(entity.getVehicleMasterData().equipmentList()
                .stream().map(this::mapToEquipmentResource).collect(Collectors.toList()));
        return resource;
    }

    public VehicleMotionData mapVehicleResourceToVehicleMotionData(VehicleCommandResource resource) {
        return mapToVehicleMotionData(resource);
    }

    private EquipmentResource mapToEquipmentResource(Equipment entity) {
        EquipmentResource resource = new EquipmentResource();
        resource.setCode(entity.code().value());
        resource.setDescription(entity.description());
        return resource;
    }

    private VehicleMasterData mapToVehicleMasterData(VehicleResource resource) {
        VehicleModel vehicleModel = new VehicleModel(resource.getVehicleModelName(), resource.getVehicleModelType());
        SerialNumber serialNumber = new SerialNumber(resource.getSerialNumber());
        List<Equipment> equipmentList = resource.getEquipmentList().stream().map(this::mapToEquipment).collect(Collectors.toList());
        return new VehicleMasterData(equipmentList, vehicleModel, serialNumber, new MileageUnit(MileageUnitValue.valueOf(resource.getMileageUnit())));
    }

    private Equipment mapToEquipment(EquipmentResource resource) {
        return new Equipment(new EquipmentCode(resource.getCode()), resource.getDescription());
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
