package com.hexaclean.arc.demo.app.vehicle.domain.model;

import com.hexaclean.arc.demo.common.mapstruct.Default;

import java.util.List;
import java.util.Objects;

public class Vehicle {

    private Vin vin;
    private VehicleMotionData vehicleMotionData;
    private VehicleMasterData vehicleMasterData;
    private Boolean has2GSupport;

    public Vehicle(Vin vin, VehicleMotionData vehicleMotionData) {
        this.vin = vin;
        this.vehicleMotionData = vehicleMotionData;
        if (this.vin == null || this.vehicleMotionData == null) {
            throw new IllegalStateException("one or more of the properties vin or motion data are null!");
        }
    }

    @Default
    public Vehicle(Vin vin, VehicleMotionData vehicleMotionData, VehicleMasterData vehicleMasterData, boolean has2GSupport) {
        this(vin, vehicleMotionData);
        this.has2GSupport = has2GSupport;
        this.vehicleMasterData = vehicleMasterData;
        validateVehicleMasterData();
    }

    private void determineHas2GSupport(List<String> equipmentCodes) {
        this.has2GSupport = equipmentCodes.stream()
                .filter(code -> code.equals("GS200"))
                .findAny()
                .isPresent();
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

    public Boolean isHas2GSupport() {
        return has2GSupport;
    }

    private void validateVehicleMasterData() {
        if (this.vehicleMasterData == null) {
            throw new IllegalStateException("vehicle master data should not be null!");
        }
    }

    public void addVehicleMasterData(VehicleModel vehicleModel, SerialNumber serialNumber, MileageUnit mileageUnit, List<String> equipmentCodes) {
        this.vehicleMasterData = new VehicleMasterData(vehicleModel, serialNumber, mileageUnit);
        determineHas2GSupport(equipmentCodes);
    }
}