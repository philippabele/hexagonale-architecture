package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model;

import com.hexaclean.arc.demo.common.domain.primitives.StringValueObject;
import io.github.domainprimitives.validation.Constraints;

public class Vin extends StringValueObject {

    public Vin(String value) {
        super(value, "Vin", Constraints.isPattern("(?=.*\\d|=.*[A-Z])(?=.*[A-Z])[A-Z0-9]{17}"));
    }
}
