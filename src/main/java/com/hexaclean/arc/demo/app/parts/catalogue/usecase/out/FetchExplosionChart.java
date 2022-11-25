package com.hexaclean.arc.demo.app.parts.catalogue.usecase.out;

import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.ExplosionChart;
import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.PartsCategoryCode;
import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.vehicle.Equipment;
import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.vehicle.VehicleModel;

import java.util.List;

public interface FetchExplosionChart {
    ExplosionChart fetch(PartsCategoryCode partsCategoryId, VehicleModel vehicleModel, List<Equipment> equipmentList);
}
