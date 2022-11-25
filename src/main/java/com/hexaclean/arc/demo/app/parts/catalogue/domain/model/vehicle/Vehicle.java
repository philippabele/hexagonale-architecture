package com.hexaclean.arc.demo.app.parts.catalogue.domain.model.vehicle;

import java.util.List;

public record Vehicle(String vin, List<Equipment> equipmentList, VehicleModel vehicleModel) {

}
