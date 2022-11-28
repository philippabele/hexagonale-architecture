package com.hexaclean.arc.demo.app.vehicle.adapter.in;

import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleQuery;

//@RestController
//@RequestMapping("/vehicles")
public class VehicleController {

    private VehicleQuery vehicleQuery;

    public VehicleController(VehicleQuery vehicleQuery) {
        this.vehicleQuery = vehicleQuery;
    }

    //@GetMapping("/{vin}")
    public Vehicle readVehicle(/*@PathVariable("vin")*/ String vin) {
        return vehicleQuery.findByVin(new Vin(vin));
    }

}
