package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model;

import com.hexaclean.arc.demo.common.domain.primitives.StringValueObject;
import io.github.domainprimitives.validation.Constraints;

public class LicensePlate extends StringValueObject {

    public LicensePlate(String value) {
        super(value, "License Plate", Constraints.isPattern("[A-ZÖÜÄ]{1,3}-[A-ZÖÜÄ]{1,2} [1-9]{1}[0-9]{1,3}"));
    }
}
