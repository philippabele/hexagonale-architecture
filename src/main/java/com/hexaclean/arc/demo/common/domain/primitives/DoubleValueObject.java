package com.hexaclean.arc.demo.common.domain.primitives;

import io.github.domainprimitives.type.ValueObject;
import io.github.domainprimitives.validation.Constraints;
import io.github.domainprimitives.validation.Validation;

import java.util.function.Consumer;

public class DoubleValueObject extends ValueObject<Double> {

    private static  Consumer<Validation<Double>> constraints = Constraints.isNotNullDouble();

    public DoubleValueObject(Double value, String label) {
        super(value, label, constraints);
    }

    public DoubleValueObject(Double value, String label, Consumer<Validation<Double>> additionalContraints) {
        super(value, label, constraints.andThen(additionalContraints));
    }
}
