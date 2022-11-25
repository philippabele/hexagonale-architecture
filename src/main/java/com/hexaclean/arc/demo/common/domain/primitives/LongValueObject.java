package com.hexaclean.arc.demo.common.domain.primitives;

import io.github.domainprimitives.type.ValueObject;
import io.github.domainprimitives.validation.Constraints;
import io.github.domainprimitives.validation.Validation;

import java.util.function.Consumer;

public class LongValueObject extends ValueObject<Long> {

    private static  Consumer<Validation<Long>> constraints = Constraints.isNotNullLong();

    public LongValueObject(Long value, String label) {
        super(value, label, constraints);
    }

    public LongValueObject(Long value, String label, Consumer<Validation<Long>> additionalContraints) {
        super(value, label, constraints.andThen(additionalContraints));
    }
}
