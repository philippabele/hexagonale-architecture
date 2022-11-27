package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model;

import com.hexaclean.arc.demo.common.mapstruct.Default;
import io.github.domainprimitives.object.Aggregate;

import java.util.Objects;

public class Vehicle extends Aggregate {

    private Vin vin;
    private VehicleMotionData vehicleMotionData;
    private VehicleMasterData vehicleMasterData;
    private boolean has2GSupport;

    public Vehicle(Vin vin, VehicleMotionData vehicleMotionData) {
        this.vin = vin;
        this.vehicleMotionData = vehicleMotionData;
        validate();
        evaluateValidations();
    }

    @Default
    public Vehicle(Vin vin, VehicleMotionData vehicleMotionData, VehicleMasterData vehicleMasterData) {
        this(vin, vehicleMotionData);
        this.vehicleMasterData = vehicleMasterData;
        validate();
        validateVehicleMasterData();
        evaluateValidations();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(vin, vehicle.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin);
    }

    public Vin getVin() {
        return vin;
    }

    public VehicleMotionData getVehicleMotionData() {
        return vehicleMotionData;
    }

    public VehicleMasterData getVehicleMasterData() {
        return vehicleMasterData;
    }

    public void addVehicleMasterData(VehicleMasterData vehicleMasterData, boolean has2GSupport) {
        this.vehicleMasterData = vehicleMasterData;
        this.has2GSupport = has2GSupport;
        validateVehicleMasterData();
        evaluateValidations();
    }

    private void validateVehicleMasterData() {
        validateNotNull(vehicleMasterData, "Vehicle Master Data");
    }

    public boolean isHas2GSupport() {
        return has2GSupport;
    }

    @Override
    protected void validate() {
        validateNotNull(vehicleMotionData, "Vehicle Motion Data");
        validateNotNull(vin, "Vin");
    }
}