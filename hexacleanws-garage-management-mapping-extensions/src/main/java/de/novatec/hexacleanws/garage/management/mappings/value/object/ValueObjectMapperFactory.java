package de.novatec.hexacleanws.garage.management.mappings.value.object;

import io.github.domainprimitives.type.ValueObject;
import org.mapstruct.TargetType;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public interface ValueObjectMapperFactory {

    static <V extends ValueObject<T>, T> T mapToValue(V valueObject) {
        return valueObject == null ? null : valueObject.getValue();
    }

    static <V extends ValueObject<T>, T> V mapFromValueOBject(T value, @TargetType Class<V> valueObjectClass) {
        if (value == null) {
            return null;
        }

        try {
            Constructor<V> constructor = valueObjectClass.getDeclaredConstructor(value.getClass());
            return constructor.newInstance(value);
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
