package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.in.mapping;

import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.in.resource.VehicleCommandResource;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.in.resource.VehicleResource;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.VehicleMotionData;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class VehicleMotionDataToVehicleResourceMapper {

    private MapperFactory mapperFactory;

    public VehicleMotionDataToVehicleResourceMapper() {
        mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(VehicleCommandResource.class, VehicleMotionData.class)
                .byDefault()
                .register();
    }

    public VehicleMotionData mapVehicleCommandResourceToVehicleMotionData(VehicleCommandResource resource) {
        BoundMapperFacade<VehicleCommandResource, VehicleMotionData> mapperFacade =
                mapperFactory.getMapperFacade(VehicleCommandResource.class, VehicleMotionData.class);
        return mapperFacade.map(resource);
    }


}

