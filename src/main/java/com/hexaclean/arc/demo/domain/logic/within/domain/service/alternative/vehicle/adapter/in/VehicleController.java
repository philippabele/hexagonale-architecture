package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.in;

import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.in.resource.VehicleCommandResource;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.in.resource.VehicleResource;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.VehicleMotionData;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.usecase.in.VehicleCommand;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.usecase.in.VehicleQuery;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private VehicleQuery vehicleQuery;
    private VehicleToVehicleResourceMapper mapper;
    private VehicleCommand vehicleCommand;

    public VehicleController(VehicleQuery vehicleQuery, VehicleToVehicleResourceMapper mapper, VehicleCommand vehicleCommand) {
        this.vehicleQuery = vehicleQuery;
        this.mapper = mapper;
        this.vehicleCommand = vehicleCommand;
    }

    @GetMapping("/{vin}")
    public VehicleResource readVehicle(@PathVariable("vin") String vin) {
        return mapper.mapVehicleToVehicleResource(vehicleQuery.findByVin(new Vin(vin)));
    }


    @PutMapping("/{vin}")
    public VehicleResource updateVehicle(@PathVariable("vin") String vin, @RequestBody VehicleCommandResource resource) {
        VehicleMotionData vehicleMotionData = mapper.mapVehicleResourceToVehicleMotionData(resource);
        Vehicle updatedVehicle = vehicleCommand.update(new Vin(vin), vehicleMotionData);
        return mapper.mapVehicleToVehicleResource(updatedVehicle);
    }

    @PostMapping
    public VehicleResource createVehicle(@RequestBody VehicleResource resource) {
        Vehicle createdVehice = vehicleCommand.create(mapper.mapVehicleResourceToVehicle(resource));
        return mapper.mapVehicleToVehicleResource(createdVehice);
    }
}
