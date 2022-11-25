package com.hexaclean.arc.demo.app.garage.order.adapter.out.vehicle;

import com.hexaclean.arc.demo.app.garage.order.domain.model.vehicle.LicensePlate;
import com.hexaclean.arc.demo.app.garage.order.domain.model.vehicle.Vehicle;
import com.hexaclean.arc.demo.app.garage.order.domain.model.vehicle.Vin;

public class VehicleToOriginVehicleMapper {

    public Vehicle mapOriginVehicleToVehicle(com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle originVehicle) {
        return new Vehicle(new Vin(originVehicle.getVin().value()),
                new LicensePlate(originVehicle.getVehicleMotionData().licensePlate().value()));
    }
}
