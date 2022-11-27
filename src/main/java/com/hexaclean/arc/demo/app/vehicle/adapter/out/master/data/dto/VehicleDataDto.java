package com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data.dto;

public class VehicleDataDto {

    private SalesInformationDto salesInformation;
    private VehicleDealerHistoryDto vehicleDealerHistory;
    private String vinOrFin;
    private String baumuster;
    private String baumusterDescription;
    private EquipmentListDto equipmentListDto;
    private String serialNumber;
    private String mileageUnit;

    public SalesInformationDto getSalesInformation() {
        return salesInformation;
    }

    public void setSalesInformation(SalesInformationDto salesInformation) {
        this.salesInformation = salesInformation;
    }

    public VehicleDealerHistoryDto getVehicleDealerHistory() {
        return vehicleDealerHistory;
    }

    public void setVehicleDealerHistory(VehicleDealerHistoryDto vehicleDealerHistory) {
        this.vehicleDealerHistory = vehicleDealerHistory;
    }

    public String getVinOrFin() {
        return vinOrFin;
    }

    public void setVinOrFin(String vinOrFin) {
        this.vinOrFin = vinOrFin;
    }

    public String getBaumuster() {
        return baumuster;
    }

    public void setBaumuster(String baumuster) {
        this.baumuster = baumuster;
    }

    public String getBaumusterDescription() {
        return baumusterDescription;
    }

    public void setBaumusterDescription(String baumusterDescription) {
        this.baumusterDescription = baumusterDescription;
    }

    public EquipmentListDto getEquipmentListDto() {
        return equipmentListDto;
    }

    public void setEquipmentListDto(EquipmentListDto equipmentListDto) {
        this.equipmentListDto = equipmentListDto;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMileageUnit() {
        return mileageUnit;
    }

    public void setMileageUnit(String mileageUnit) {
        this.mileageUnit = mileageUnit;
    }
}
