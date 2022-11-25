package com.hexaclean.arc.demo.app.garage.order.domain.service;

import com.hexaclean.arc.demo.app.garage.order.domain.command.CreateGarageOrderCommand;
import com.hexaclean.arc.demo.app.garage.order.domain.command.UpdateGarageOrderCommand;
import com.hexaclean.arc.demo.app.garage.order.domain.model.GarageOrder;
import com.hexaclean.arc.demo.app.garage.order.domain.model.OrderNumber;
import com.hexaclean.arc.demo.app.garage.order.usecase.in.GarageOrderCommand;
import com.hexaclean.arc.demo.app.garage.order.usecase.out.FetchVehicle;
import com.hexaclean.arc.demo.app.garage.order.usecase.out.GarageOrderDbCommand;
import com.hexaclean.arc.demo.app.garage.order.usecase.out.GarageOrderDbQuery;

public class GarageOrderCommandService implements GarageOrderCommand {

    private GarageOrderDbCommand dbCommand;
    private GarageOrderDbQuery dbQuery;
    private FetchVehicle fetchVehicle;

    public GarageOrderCommandService(GarageOrderDbCommand dbCommand, GarageOrderDbQuery dbQuery, FetchVehicle fetchVehicle) {
        this.dbCommand = dbCommand;
        this.dbQuery = dbQuery;
        this.fetchVehicle = fetchVehicle;
    }


    @Override
    public GarageOrder create(CreateGarageOrderCommand createGarageOrderCommand) {
        OrderNumber orderNumber = this.createOrderNumber();
        GarageOrder garageOrder = createGarageOrder(createGarageOrderCommand, orderNumber);
        return dbCommand.save(garageOrder);
    }

    private GarageOrder createGarageOrder(CreateGarageOrderCommand createGarageOrderCommand, OrderNumber orderNumber) {
        return new GarageOrder(createGarageOrderCommand.getVehicle(), orderNumber, createGarageOrderCommand.getOrderPositions());
    }

    private OrderNumber createOrderNumber() {
        //some complicated determination or
        return new OrderNumber("GO-123-01.03.2023-557896332689");
    }

    @Override
    public GarageOrder update(UpdateGarageOrderCommand updateGarageOrderCommand) {
        GarageOrder garageOrder = dbQuery.findByOrderNumber(updateGarageOrderCommand.getOrderNumber());
        optionalAddOrderPositions(updateGarageOrderCommand, garageOrder);
        optionalChangeVehicle(updateGarageOrderCommand, garageOrder);
        return dbCommand.save(garageOrder);
    }

    private void optionalChangeVehicle(UpdateGarageOrderCommand updateGarageOrderCommand, GarageOrder garageOrder) {
        if (updateGarageOrderCommand.getLicensePlate() != null) {
            garageOrder.changeVehicle(fetchVehicle.fetch(updateGarageOrderCommand.getLicensePlate()));
        }
    }

    private void optionalAddOrderPositions(UpdateGarageOrderCommand updateGarageOrderCommand, GarageOrder garageOrder) {
        if (updateGarageOrderCommand.getOrderPositions() != null) {
            garageOrder.addOrderPosition(updateGarageOrderCommand.getOrderPositions());
        }
    }

}
