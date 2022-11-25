package com.hexaclean.arc.demo.app.vehicle.domain.service;

import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.app.vehicle.domain.model.VehicleMotionData;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleCommand;
import com.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbCommand;
import org.springframework.stereotype.Service;

@Service
public class VehicleCommandService implements VehicleCommand {

    private VehicleDbCommand dbCommand;

    public VehicleCommandService(VehicleDbCommand dbCommand) {
        this.dbCommand = dbCommand;
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        return dbCommand.saveVehicle(vehicle);
    }

    @Override
    public Vehicle update(Vin vin, VehicleMotionData vehicleMotionData) {
        return dbCommand.saveVehicle(new Vehicle(vin, vehicleMotionData));
    }
}
