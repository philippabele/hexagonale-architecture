package com.hexaclean.arc.demo.app.garage.order.usecase.out;

import com.hexaclean.arc.demo.app.garage.order.domain.model.GarageOrder;

public interface GarageOrderDbCommand {
    GarageOrder save(GarageOrder garageOrder);
}
