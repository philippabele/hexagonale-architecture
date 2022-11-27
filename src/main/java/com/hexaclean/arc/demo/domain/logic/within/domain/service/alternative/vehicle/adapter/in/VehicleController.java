package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.in;

import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.in.mapping.VehicleMotionDataToVehicleResourceMapper;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.in.mapping.VehicleToVehicleResourceMapper;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.in.resource.VehicleCommandResource;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.in.resource.VehicleResource;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.VehicleMotionData;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.usecase.in.VehicleCommand;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.usecase.in.VehicleQuery;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public class VehicleController {

    private VehicleQuery vehicleQuery;
    private VehicleToVehicleResourceMapper vehicleMapper;
    private VehicleMotionDataToVehicleResourceMapper vehicleMotionDataMapper;
    private VehicleCommand vehicleCommand;

    public VehicleController(VehicleQuery vehicleQuery, VehicleToVehicleResourceMapper vehicleMapper, VehicleMotionDataToVehicleResourceMapper vehicleMotionDataMapper, VehicleCommand vehicleCommand) {
        this.vehicleQuery = vehicleQuery;
        this.vehicleMapper = vehicleMapper;
        this.vehicleMotionDataMapper = vehicleMotionDataMapper;
        this.vehicleCommand = vehicleCommand;
    }

    public VehicleResource readVehicle(@PathVariable("vin") String vin) {
        return vehicleMapper.mapVehicleToVehicleResource(vehicleQuery.findByVin(new Vin(vin)));
    }

    public VehicleResource updateVehicle(@PathVariable("vin") String vin, @RequestBody VehicleCommandResource resource) {
        VehicleMotionData vehicleMotionData = vehicleMotionDataMapper.mapVehicleCommandResourceToVehicleMotionData(resource);
        Vehicle updatedVehicle = vehicleCommand.update(new Vin(vin), vehicleMotionData);
        return vehicleMapper.mapVehicleToVehicleResource(updatedVehicle);
    }

    public VehicleResource createVehicle(@RequestBody VehicleResource resource) {
        Vehicle createdVehice = vehicleCommand.create(vehicleMapper.mapVehicleResourceToVehicle(resource));
        return vehicleMapper.mapVehicleToVehicleResource(createdVehice);
    }
}
