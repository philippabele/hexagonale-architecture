package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model;

import io.github.domainprimitives.object.ComposedValueObject;

public class VehicleMasterData extends ComposedValueObject {
    private VehicleModel vehicleModel;
    private SerialNumber serialNumber;
    private MileageUnit mileageUnit;

    public VehicleMasterData(VehicleModel vehicleModel, SerialNumber serialNumber, MileageUnit mileageUnit) {
        this.vehicleModel = vehicleModel;
        this.serialNumber = serialNumber;
        this.mileageUnit = mileageUnit;
    }

    @Override
    protected void validate() {
        validateNotNull(vehicleModel, "Vehicle Model");
        validateNotNull(serialNumber, "Serial Number");
        validateNotNull(mileageUnit, "Mileage Unit");
        evaluateValidations();
    }

    public VehicleModel getVehicleModel() {
        return vehicleModel;
    }

    public SerialNumber getSerialNumber() {
        return serialNumber;
    }

    public MileageUnit getMileageUnit() {
        return mileageUnit;
    }
}
