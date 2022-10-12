package de.novatec.hexacleanws.garage.management.vehicle.adapter.in;

import de.novatec.hexacleanws.garage.management.vehicle.domain.model.vehicle.Vehicle;
import de.novatec.hexacleanws.garage.management.vehicle.domain.model.vehicle.Vin;
import de.novatec.hexacleanws.garage.management.vehicle.usecase.in.VehicleQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private VehicleQuery vehicleQuery;

    public VehicleController(VehicleQuery vehicleQuery) {
        this.vehicleQuery = vehicleQuery;
    }

    @GetMapping("/{vin}")
    public Vehicle readVehicle(@PathVariable String vin) {
        return new Vehicle(new Vin(vin));
    }
}
