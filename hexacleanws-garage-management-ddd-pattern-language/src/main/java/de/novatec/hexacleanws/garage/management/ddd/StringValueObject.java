package de.novatec.hexacleanws.garage.management.ddd;

import io.github.domainprimitives.type.ValueObject;
import io.github.domainprimitives.validation.Validation;

import java.util.function.Consumer;

import static io.github.domainprimitives.validation.Constraints.isNotBlank;
import static io.github.domainprimitives.validation.Constraints.isNotNull;

public abstract class StringValueObject extends ValueObject<String> {

    private static Consumer<Validation<String>> validations = isNotNull().andThen(isNotBlank());

    public StringValueObject(String value) {
        super(value, validations);
    }

    public StringValueObject(String value, Consumer<Validation<String>> furtherValidations) {
        super(value, validations.andThen(furtherValidations));
    }
}
