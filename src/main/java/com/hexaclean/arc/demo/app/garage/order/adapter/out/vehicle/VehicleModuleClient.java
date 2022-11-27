package com.hexaclean.arc.demo.app.garage.order.adapter.out.vehicle;

import com.hexaclean.arc.demo.app.garage.order.domain.model.vehicle.Vehicle;
import com.hexaclean.arc.demo.app.garage.order.usecase.out.FetchVehicle;
import com.hexaclean.arc.demo.app.vehicle.domain.model.LicensePlate;
import com.hexaclean.arc.demo.app.vehicle.usecase.in.FindVehicleByLicensePlate;

public class VehicleModuleClient implements FetchVehicle {

    private FindVehicleByLicensePlate findByLicensePlate;
    private VehicleToOriginVehicleMapper mapper;

    public VehicleModuleClient(FindVehicleByLicensePlate findByLicensePlate, VehicleToOriginVehicleMapper mapper) {
        this.findByLicensePlate = findByLicensePlate;
        this.mapper = mapper;
    }

    @Override
    public Vehicle fetch(com.hexaclean.arc.demo.app.garage.order.domain.model.vehicle.LicensePlate licensePlate) {
        return mapper.mapOriginVehicleToVehicle(findByLicensePlate.findByLicensePlate(
                new LicensePlate(licensePlate.value())));
    }

}
