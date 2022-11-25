package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model;

import io.github.domainprimitives.object.ComposedValueObject;

public class VehicleMasterData extends ComposedValueObject {
    private boolean has2GSupport;
    private VehicleModel vehicleModel;
    private SerialNumber serialNumber;
    private MileageUnit mileageUnit;

    public VehicleMasterData(boolean has2GSupport, VehicleModel vehicleModel, SerialNumber serialNumber, MileageUnit mileageUnit) {
        this.has2GSupport = has2GSupport;
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
}
