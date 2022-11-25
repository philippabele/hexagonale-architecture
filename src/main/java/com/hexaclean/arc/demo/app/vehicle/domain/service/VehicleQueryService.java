package com.hexaclean.arc.demo.app.vehicle.domain.service;

import com.hexaclean.arc.demo.app.vehicle.domain.model.LicensePlate;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleQuery;
import com.hexaclean.arc.demo.app.vehicle.usecase.out.FetchVehicleMasterData;
import com.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbQuery;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import org.springframework.stereotype.Service;

@Service
public class VehicleQueryService implements VehicleQuery {

    private VehicleDbQuery vehicleDbQuery;
    private FetchVehicleMasterData fetchVehicleMasterData;

    public VehicleQueryService(VehicleDbQuery vehicleDbQuery, FetchVehicleMasterData fetchVehicleMasterData) {
        this.vehicleDbQuery = vehicleDbQuery;
        this.fetchVehicleMasterData = fetchVehicleMasterData;
    }

    public Vehicle findByVin(Vin vin) {
        Vehicle vehicle = vehicleDbQuery.findVehicleByVin(vin);
        enrichWithVehicleMasterData(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle findByLicensePlate(LicensePlate licensePlate) {
        Vehicle vehicle = vehicleDbQuery.findVehicleByLicensePlate(licensePlate);
        enrichWithVehicleMasterData(vehicle);
        return vehicle;
    }

    private void enrichWithVehicleMasterData(Vehicle vehicle) {
        vehicle.addVehicleMasterData(fetchVehicleMasterData.fetch(vehicle.getVin()));
    }
}
