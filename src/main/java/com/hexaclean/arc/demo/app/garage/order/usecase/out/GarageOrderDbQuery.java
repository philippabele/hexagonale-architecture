package com.hexaclean.arc.demo.app.garage.order.usecase.out;

import com.hexaclean.arc.demo.app.garage.order.domain.model.GarageOrder;
import com.hexaclean.arc.demo.app.garage.order.domain.model.OrderNumber;

public interface GarageOrderDbQuery {
    GarageOrder findByOrderNumber(OrderNumber orderNumber);
}
