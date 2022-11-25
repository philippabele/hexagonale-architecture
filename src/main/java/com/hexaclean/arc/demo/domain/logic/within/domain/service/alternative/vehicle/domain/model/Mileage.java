package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model;

import com.hexaclean.arc.demo.common.domain.primitives.DoubleValueObject;
import io.github.domainprimitives.validation.Constraints;

public class Mileage extends DoubleValueObject {

    public Mileage(Double value) {
        super(value, "Mileage", Constraints.isGreatThanOrEqual(0.0));
    }
}
