package com.hexaclean.arc.demo.app.garage.order.usecase.in;

import com.hexaclean.arc.demo.app.garage.order.domain.model.GarageOrder;
import com.hexaclean.arc.demo.app.garage.order.domain.model.OrderNumber;

public interface GarageOrderQuery {
    GarageOrder read(OrderNumber orderNumber);
}
