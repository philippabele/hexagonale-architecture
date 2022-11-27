package com.hexaclean.arc.demo.common.domain.primitives;

import io.github.domainprimitives.type.ValueObject;
import io.github.domainprimitives.validation.Constraints;
import io.github.domainprimitives.validation.Validation;

import java.util.function.Consumer;

public class StringValueObject extends ValueObject<String> {

    private static Consumer<Validation<String>> constraints = Constraints.isNotNull().andThen(Constraints.isNotBlank());

    public StringValueObject(String value, String label) {
        super(value, label, constraints);
    }

    public StringValueObject(String value, String label, Consumer<Validation<String>> additionalContraints) {
        super(value, label, constraints.andThen(additionalContraints));
    }
}
