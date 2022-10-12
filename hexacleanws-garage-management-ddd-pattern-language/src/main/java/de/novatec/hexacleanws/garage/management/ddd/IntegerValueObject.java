package de.novatec.hexacleanws.garage.management.ddd;

import io.github.domainprimitives.type.ValueObject;
import io.github.domainprimitives.validation.Validation;

import java.util.function.Consumer;

import static io.github.domainprimitives.validation.Constraints.isNotNullInteger;

public abstract class IntegerValueObject extends ValueObject<Integer> {
    private static final Consumer<Validation<Integer>> validations = isNotNullInteger();

    public IntegerValueObject(Integer value) {
        super(value, validations);
    }

    public IntegerValueObject(Integer value, Consumer<Validation<Integer>> furtherValidations) {
        super(value, validations.andThen(furtherValidations));
    }

}
