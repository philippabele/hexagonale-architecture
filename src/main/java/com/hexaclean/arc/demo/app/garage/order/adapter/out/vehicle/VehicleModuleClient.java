package com.hexaclean.arc.demo.app.garage.order.adapter.out.vehicle;

import com.hexaclean.arc.demo.app.vehicle.domain.model.LicensePlate;
import com.hexaclean.arc.demo.app.garage.order.domain.model.vehicle.Vehicle;
import com.hexaclean.arc.demo.app.garage.order.usecase.out.FetchVehicle;
import com.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleQuery;

public class VehicleModuleClient implements FetchVehicle {

    private VehicleQuery vehicleQuery;
    private VehicleToOriginVehicleMapper mapper;

    public VehicleModuleClient(VehicleQuery vehicleQuery, VehicleToOriginVehicleMapper mapper) {
        this.vehicleQuery = vehicleQuery;
        this.mapper = mapper;
    }

    @Override
    public Vehicle fetch(com.hexaclean.arc.demo.app.garage.order.domain.model.vehicle.LicensePlate licensePlate) {
        return mapper.mapOriginVehicleToVehicle(vehicleQuery.findByLicensePlate(
                new LicensePlate(licensePlate.value())));
    }

}
