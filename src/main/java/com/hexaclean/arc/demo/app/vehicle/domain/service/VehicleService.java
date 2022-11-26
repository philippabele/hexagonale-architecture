package com.hexaclean.arc.demo.app.vehicle.domain.service;

import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    public Vehicle findByVin(Vin vin) {
        return new Vehicle(new Vin("WP0ZZZ99ZTS392155"));
    }
}
