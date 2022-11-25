package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model;

import com.hexaclean.arc.demo.common.domain.primitives.StringValueObject;
import io.github.domainprimitives.validation.Constraints;

public class RegistrationCountry extends StringValueObject {

    public RegistrationCountry(String value) {
        super(value, "Registration Country", Constraints.isPattern("[A-Z]{2}-[a-z]{2}"));
    }

}
