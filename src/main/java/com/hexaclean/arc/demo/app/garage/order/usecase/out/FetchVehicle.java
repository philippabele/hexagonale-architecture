package com.hexaclean.arc.demo.app.garage.order.usecase.out;

import com.hexaclean.arc.demo.app.garage.order.domain.model.vehicle.LicensePlate;
import com.hexaclean.arc.demo.app.garage.order.domain.model.vehicle.Vehicle;

public interface FetchVehicle {
    Vehicle fetch(LicensePlate licensePlate);
}
