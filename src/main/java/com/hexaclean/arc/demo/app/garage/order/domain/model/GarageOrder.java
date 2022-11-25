package com.hexaclean.arc.demo.app.garage.order.domain.model;

import com.hexaclean.arc.demo.app.garage.order.domain.model.vehicle.Vehicle;

import java.util.List;

public class GarageOrder {

    private Vehicle vehicle;
    private OrderNumber orderNumber;
    private List<OrderPosition> positions;

    public GarageOrder(Vehicle vehicle, OrderNumber orderNumber, List<OrderPosition> positions) {
        this.vehicle = vehicle;
        this.orderNumber = orderNumber;
        this.positions = positions;
        //some vlidations, ensure positions is not null
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public OrderNumber getOrderNumber() {
        return orderNumber;
    }

    public List<OrderPosition> getPositions() {
        return positions;
    }

    public void addOrderPosition(List<OrderPosition> orderPositions) {
        //some validation logic
        this.positions.addAll(orderPositions);
    }

    public void changeVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
