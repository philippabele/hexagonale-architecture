package com.hexaclean.arc.demo.lab;

import com.hexaclean.arc.demo.app.vehicle.adapter.in.resource.VehicleResource;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.db.entity.VehicleDbEntity;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data.dto.EquipmentDto;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data.dto.VehicleDataDto;
import com.hexaclean.arc.demo.app.vehicle.domain.dto.VehicleMasterDataDomainDto;
import com.hexaclean.arc.demo.app.vehicle.domain.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaseExerciseTest {

    protected static final String ROOT_PACKAGE = "com.hexaclean.arc.demo.app";
    protected static final String DOMAIN = "..domain..";
    protected static final String DOMAIN_SERVICE = "..domain.service..";
    protected static final String DOMAIN_MODEL = "..domain.model..";
    protected static final String JAVA_LANG = "..java.lang..";
    protected static final String ROOT_ENTITY_UNDER_TEST = "Vehicle";
    protected static final String DB_ENTITY_UNDER_TEST = "VehicleDbEntity";
    protected static final String SERVICE_UNDER_TEST = "VehicleQueryService";
    protected static final String VALUE_OBJECT_UNDER_TEST = "Vin";
    protected static final String JAVA_UTIL = "..java.util..";
    protected static final String ORG = "..org..";
    protected static final String VIN = "WP0ZZZ99ZTS392155";
    protected static final String ADAPTER_IN = "..adapter.in..";
    protected static final String ADAPTER = "..adapter..";
    protected static final String USECASE = "..usecase..";
    protected static final String USECASE_IN = "..usecase.in..";
    protected static final String USECASE_OUT = "..usecase.out..";
    protected static final String USECASE_OUT_QUERY_UNDER_TEST = "VehicleDbQuery";
    protected static final String USECASE_IN_QUERY_UNDER_TEST = "VehicleQuery";
    protected static final String REPOSITORY_UNDER_TEST = "VehicleQueryRepository";
    protected static final String ADAPTER_OUT = "..adapter.out..";
    protected static final String CONTROLLER_UNDER_TEST = "VehicleController";
    protected static final String LICENSE_PLATE_TEST_VALUE = "ES-EM 385";
    protected static final double MILEAGE_TEST_VALUE = 100000;
    protected static final String VEHICLE_MODEL_DESCRIPTION_TEST_VALUE = "E30 Limousine";
    protected static final String VEHICLE_MODEL_TYPE_TEST_VALUE = "3er";
    protected static final String SERIAL_NUMBER_TEST_VALUE = "0123456789";
    protected static final List<String> EQUIPMENT_LIST = Arrays.asList("CU897", "DK564", "KL457");
    protected static final String VEHICLE_DOMAIN = "..vehicle.domain..";
    protected static final String VEHICLE_DOMAIN_MODEL = "..vehicle.domain.model..";
    protected static final String IO_GITHUB_DOMAINPRIMITIVES = "..io.github.domainprimitives..";

    protected VehicleDbEntity createExpectedVehicleDbEntity() {
        VehicleDbEntity dbEntity = new VehicleDbEntity();
        dbEntity.setVin(VIN);
        dbEntity.setLicensePlate(LICENSE_PLATE_TEST_VALUE);
        dbEntity.setMilage(MILEAGE_TEST_VALUE);
        return dbEntity;
    }

    protected VehicleResource createExpectedVehicleResource() {
        VehicleResource resource = new VehicleResource();
        resource.setVin(VIN);
        resource.setLicensePlate(LICENSE_PLATE_TEST_VALUE);
        resource.setMileage(Double.valueOf(MILEAGE_TEST_VALUE));
        resource.setVehicleModelType(VEHICLE_MODEL_TYPE_TEST_VALUE);
        resource.setVehicleModelName(VEHICLE_MODEL_DESCRIPTION_TEST_VALUE);
        resource.setMileageUnit(MileageUnitValue.KM.toString());
        resource.setVin(VIN);
        resource.setSerialNumber(SERIAL_NUMBER_TEST_VALUE);
        return resource;
    }

    protected VehicleDataDto createExpectedVehicleDto() {
        VehicleDataDto vehicleDto = new VehicleDataDto();
        vehicleDto.setBaumuster(VEHICLE_MODEL_TYPE_TEST_VALUE);
        vehicleDto.setBaumusterDescription(VEHICLE_MODEL_DESCRIPTION_TEST_VALUE);
        vehicleDto.setMileageUnit(MileageUnitValue.KM.toString());
        vehicleDto.setVinOrFin(VIN);
        vehicleDto.setSerialNumber(SERIAL_NUMBER_TEST_VALUE);
        return vehicleDto;
    }

    protected Vehicle createExpectedVehicle() {
        Vehicle vehicle = new Vehicle(new Vin(VIN),
                createExpectedVehicleMotionData());
        VehicleMasterData masterData = createExpectedVehicleMasterData();
        vehicle.addVehicleMasterData(masterData.vehicleModel(), masterData.serialNumber(), masterData.mileageUnit(), EQUIPMENT_LIST);
        return vehicle;
    }

    protected VehicleMotionData createExpectedVehicleMotionData() {
        return new VehicleMotionData(new LicensePlate(LICENSE_PLATE_TEST_VALUE),
                new Mileage(MILEAGE_TEST_VALUE));
    }

    protected VehicleMasterData createExpectedVehicleMasterData() {
        return new VehicleMasterData(
                new VehicleModel(VEHICLE_MODEL_DESCRIPTION_TEST_VALUE, VEHICLE_MODEL_TYPE_TEST_VALUE),
                new SerialNumber(SERIAL_NUMBER_TEST_VALUE), new MileageUnit(MileageUnitValue.KM));
    }

    protected VehicleMasterDataDomainDto createExpectedVehicleMasterDataDomainDto() {
        return new VehicleMasterDataDomainDto(
                EQUIPMENT_LIST,
                new VehicleModel(VEHICLE_MODEL_DESCRIPTION_TEST_VALUE, VEHICLE_MODEL_TYPE_TEST_VALUE),
                new MileageUnit(MileageUnitValue.KM),
                new SerialNumber(SERIAL_NUMBER_TEST_VALUE));
    }

    protected VehicleMasterDataDomainDto createExpectedVehicleMasterDataDomainDtoHas2G() {
        return new VehicleMasterDataDomainDto(
                Arrays.asList("CU897", "DK564", "GS200"),
                new VehicleModel(VEHICLE_MODEL_DESCRIPTION_TEST_VALUE, VEHICLE_MODEL_TYPE_TEST_VALUE),
                new MileageUnit(MileageUnitValue.KM),
                new SerialNumber(SERIAL_NUMBER_TEST_VALUE));
    }


    private List<EquipmentDto> createEquipmentListDto() {
        List<EquipmentDto> list = new ArrayList<>();
        list.add(new EquipmentDto("CU897", "Live Traffic Assistent"));
        list.add(new EquipmentDto("DK564", "Visual Park Assistent"));
        list.add(new EquipmentDto("KL457", "Sports Chassis M Deluxe"));
        return list;
    }

}
