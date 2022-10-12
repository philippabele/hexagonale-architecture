package de.novatec.hexacleanws.garage.management.ddd;

import io.github.domainprimitives.type.ValueObject;
import io.github.domainprimitives.validation.Validation;

import java.util.function.Consumer;

import static io.github.domainprimitives.validation.Constraints.isNotNullBoolean;

public abstract class BooleanValueObject extends ValueObject<Boolean> {
    private static final Consumer<Validation<Boolean>> validations = isNotNullBoolean();

    public BooleanValueObject(Boolean value) {
        super(value, validations);
    }

    public BooleanValueObject(Boolean value, Consumer<Validation<Boolean>> furtherValidations) {
        super(value, validations.andThen(furtherValidations));
    }
}
