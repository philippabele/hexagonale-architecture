package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.in.mapping;

import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.in.resource.VehicleResource;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.Vehicle;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class VehicleToVehicleResourceMapper {

    private static final String MILEAGE_UNIT_CONVERTER = "mileageUnitConverter";
    private MapperFactory mapperFactory;

    public VehicleToVehicleResourceMapper() {

        registerMileageUnitConverter();

        mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(VehicleResource.class, Vehicle.class)
                .field("vehicleModelName", "vehicleMasterData.modelDescription")
                .field("vehicleModelType", "vehicleMasterData.modelType")
                .field("serialNumber", "vehicleMasterData.serialNumber")
                .fieldMap("mileageUnit", "vehicleMasterData.mileageUnit").converter(MILEAGE_UNIT_CONVERTER).add()
                .field("has2GSupport", "vehicleMasterData.has2GSupport")
                .field("licensePlate", "vehicleMotionData.licensePlate")
                .field("mileage", "vehicleMotionData.mileage")
                .field("registrationCountry", "vehicleMotionData.registrationCountry")
                .byDefault()
                .register();
    }

    private void registerMileageUnitConverter() {
        ConverterFactory converterFactory = mapperFactory.getConverterFactory();
        converterFactory.registerConverter(MILEAGE_UNIT_CONVERTER, new MileageConverter());
    }

    public Vehicle mapVehicleResourceToVehicle(VehicleResource resource) {
        BoundMapperFacade<VehicleResource, Vehicle> mapperFacade = mapperFactory.getMapperFacade(VehicleResource.class, Vehicle.class);
        return mapperFacade.map(resource);
    }

    public VehicleResource mapVehicleToVehicleResource(Vehicle entity) {
        BoundMapperFacade<Vehicle, VehicleResource> mapperFacade = mapperFactory.getMapperFacade(Vehicle.class, VehicleResource.class);
        return mapperFacade.map(entity);
    }

}

