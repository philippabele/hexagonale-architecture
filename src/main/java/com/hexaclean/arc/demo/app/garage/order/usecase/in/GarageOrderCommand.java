package com.hexaclean.arc.demo.app.garage.order.usecase.in;

import com.hexaclean.arc.demo.app.garage.order.domain.command.CreateGarageOrderCommand;
import com.hexaclean.arc.demo.app.garage.order.domain.command.UpdateGarageOrderCommand;
import com.hexaclean.arc.demo.app.garage.order.domain.model.GarageOrder;

public interface GarageOrderCommand {
    GarageOrder create(CreateGarageOrderCommand createGarageOrderCommand);

    GarageOrder update(UpdateGarageOrderCommand updateGarageOrderCommand);
}
