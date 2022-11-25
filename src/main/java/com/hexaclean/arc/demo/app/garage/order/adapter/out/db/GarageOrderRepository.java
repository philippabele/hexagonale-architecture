package com.hexaclean.arc.demo.app.garage.order.adapter.out.db;

import com.hexaclean.arc.demo.app.garage.order.domain.model.OrderNumber;
import com.hexaclean.arc.demo.app.garage.order.domain.model.GarageOrder;
import com.hexaclean.arc.demo.app.garage.order.usecase.out.GarageOrderDbCommand;
import com.hexaclean.arc.demo.app.garage.order.usecase.out.GarageOrderDbQuery;

public class GarageOrderRepository implements GarageOrderDbCommand, GarageOrderDbQuery {

    @Override
    public GarageOrder save(GarageOrder garageOrder) {
        return null;
    }

    @Override
    public GarageOrder findByOrderNumber(OrderNumber orderNumber) {
        return null;
    }
}
