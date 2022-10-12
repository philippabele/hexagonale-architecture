package de.novatec.hexacleanws.garage.management.ddd;

import io.github.domainprimitives.type.ValueObject;
import io.github.domainprimitives.validation.Validation;

import java.util.function.Consumer;

import static io.github.domainprimitives.validation.Constraints.isNotNullDouble;

public abstract class DoubleValueObject extends ValueObject<Double> {

    private static final Consumer<Validation<Double>> validations = isNotNullDouble();

    public DoubleValueObject(Double value) {
        super(value, validations);
    }

    public DoubleValueObject(Double value, Consumer<Validation<Double>> furtherValidations) {
        super(value, validations.andThen(furtherValidations));
    }

}
