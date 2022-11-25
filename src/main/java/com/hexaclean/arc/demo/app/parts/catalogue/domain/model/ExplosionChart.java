package com.hexaclean.arc.demo.app.parts.catalogue.domain.model;

import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.vehicle.Vehicle;

import java.util.List;

public class ExplosionChart {

    private Vehicle vehicle;
    private PartsCategoryCode partsCategory;
    private List<SparePart> sparePartList;

    public ExplosionChart(Vehicle vehicle, PartsCategoryCode partsCategory, List<SparePart> sparePartList) {
        this.vehicle = vehicle;
        this.partsCategory = partsCategory;
        this.sparePartList = sparePartList;
    }

    public void doSomeIdependentBusinessLogic() {
        //do some indepenendet domain-relate logic
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public PartsCategoryCode getPartsCategory() {
        return partsCategory;
    }

    public List<SparePart> getSparePartList() {
        return sparePartList;
    }
}
