package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model;

import com.hexaclean.arc.demo.common.domain.primitives.StringValueObject;
import io.github.domainprimitives.validation.Constraints;

public class SerialNumber extends StringValueObject {

    public SerialNumber(String value) {
        super(value,"Serial Number", Constraints.isPattern("[0-9]{10}"));
    }
}
