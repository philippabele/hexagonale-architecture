package com.hexaclean.arc.demo.app.garage.order.domain.command;

import com.hexaclean.arc.demo.app.garage.order.domain.model.OrderPosition;
import com.hexaclean.arc.demo.app.garage.order.domain.model.vehicle.Vehicle;

import java.util.List;

public class CreateGarageOrderCommand {

    private List<OrderPosition> orderPositions;
    private Vehicle vehicle;

    public CreateGarageOrderCommand(List<OrderPosition> orderPositions, Vehicle vehicle) {
        this.orderPositions = orderPositions;
        this.vehicle = vehicle;
    }

    public List<OrderPosition> getOrderPositions() {
        return orderPositions;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
