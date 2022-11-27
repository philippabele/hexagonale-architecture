package com.hexaclean.arc.demo.app.garage.order.domain.command;

import com.hexaclean.arc.demo.app.garage.order.domain.model.OrderNumber;
import com.hexaclean.arc.demo.app.garage.order.domain.model.OrderPosition;
import com.hexaclean.arc.demo.app.garage.order.domain.model.vehicle.LicensePlate;

import java.util.List;

public class UpdateGarageOrderCommand {

    private OrderNumber orderNumber;
    private List<OrderPosition> orderPositions;
    private LicensePlate licensePlate;

    public UpdateGarageOrderCommand(OrderNumber orderNumber, List<OrderPosition> orderPositions) {
        this.orderNumber = orderNumber;
        this.orderPositions = orderPositions;
    }

    public UpdateGarageOrderCommand(OrderNumber orderNumber, LicensePlate licensePlate) {
        this.orderNumber = orderNumber;
        this.licensePlate = licensePlate;
    }

    public UpdateGarageOrderCommand(OrderNumber orderNumber, List<OrderPosition> orderPositions, LicensePlate licensePlate) {
        this.orderNumber = orderNumber;
        this.orderPositions = orderPositions;
        this.licensePlate = licensePlate;
    }

    public OrderNumber getOrderNumber() {
        return orderNumber;
    }

    public List<OrderPosition> getOrderPositions() {
        return orderPositions;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }
}
