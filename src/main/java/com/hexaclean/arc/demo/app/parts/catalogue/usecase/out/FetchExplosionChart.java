package com.hexaclean.arc.demo.app.parts.catalogue.usecase.out;

import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.ExplosionChart;
import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.PartsCategoryCode;
import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.vehicle.VehicleModel;

public interface FetchExplosionChart {
    ExplosionChart fetch(PartsCategoryCode partsCategoryId, VehicleModel vehicleModel, boolean has2GSupport);
}
