package de.novatec.hexacleanws.garage.management.ddd;

import io.github.domainprimitives.type.ValueObject;
import io.github.domainprimitives.validation.Validation;

import java.util.function.Consumer;

import static io.github.domainprimitives.validation.Constraints.isNotNullLong;

public abstract class LongValueObject extends ValueObject<Long> {

    private static Consumer<Validation<Long>> validations = isNotNullLong();

    public LongValueObject(Long value) {
        super(value, validations);
    }

    public LongValueObject(Long value, Consumer<Validation<Long>> furtherValidations) {
        super(value, validations.andThen(furtherValidations));
    }
}
