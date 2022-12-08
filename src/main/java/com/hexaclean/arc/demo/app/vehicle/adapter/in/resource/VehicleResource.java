package com.hexaclean.arc.demo.app.vehicle.adapter.in.resource;

import java.util.List;

public class VehicleResource {
    private String vin;

    private String mileageUnit;
    private String vehicleModelName;
    private String vehicleModelType;
    private String serialNumber;
    private List<EquipmentResource> equipmentList;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMileageUnit() {
        return mileageUnit;
    }

    public void setMileageUnit(String mileageUnit) {
        this.mileageUnit = mileageUnit;
    }

    public String getVehicleModelName() {
        return vehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getVehicleModelType() {
        return vehicleModelType;
    }

    public void setVehicleModelType(String vehicleModelType) {
        this.vehicleModelType = vehicleModelType;
    }

    public List<EquipmentResource> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<EquipmentResource> equipmentList) {
        this.equipmentList = equipmentList;
    }
}
