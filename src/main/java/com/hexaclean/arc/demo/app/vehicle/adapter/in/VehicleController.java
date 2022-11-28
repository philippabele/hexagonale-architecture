package com.hexaclean.arc.demo.app.vehicle.adapter.in;

import com.hexaclean.arc.demo.app.vehicle.adapter.in.resource.VehicleResource;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleQuery;

//@RestController
//@RequestMapping("/vehicles")
public class VehicleController {

    private VehicleQuery vehicleQuery;
    private VehicleToVehicleResourceMapper mapper;

    public VehicleController(VehicleQuery vehicleQuery, VehicleToVehicleResourceMapper mapper) {
        this.vehicleQuery = vehicleQuery;
        this.mapper = mapper;
    }

    //@GetMapping("/{vin}")
    public VehicleResource readVehicle(/*@PathVariable("vin")*/ String vin) {
        return mapper.mapVehicleToVehicleResource(vehicleQuery.findByVin(new Vin(vin)));
    }

}
