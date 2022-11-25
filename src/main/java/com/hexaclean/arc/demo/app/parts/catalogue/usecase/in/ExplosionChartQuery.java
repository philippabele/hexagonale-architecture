package com.hexaclean.arc.demo.app.parts.catalogue.usecase.in;

import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.ExplosionChart;
import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.PartsCategoryCode;

public interface ExplosionChartQuery {
    ExplosionChart read(PartsCategoryCode partsCategoryCode, String vin);
}
