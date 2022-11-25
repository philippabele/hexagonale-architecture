package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.in.resource;

public class VehicleResource {
    private String vin;
    private String registrationCountry;
    private String licensePlate;
    private double mileage;
    private String mileageUnit;
    private String vehicleModelName;
    private String vehicleModelType;
    private String serialNumber;
    private boolean has2GSupport;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
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

    public String getRegistrationCountry() {
        return registrationCountry;
    }

    public void setRegistrationCountry(String registrationCountry) {
        this.registrationCountry = registrationCountry;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
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

    public boolean isHas2GSupport() {
        return has2GSupport;
    }

    public void setHas2GSupport(boolean has2GSupport) {
        this.has2GSupport = has2GSupport;
    }
}
