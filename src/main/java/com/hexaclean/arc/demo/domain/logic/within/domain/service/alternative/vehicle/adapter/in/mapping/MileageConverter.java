package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.in.mapping;

import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.MileageUnit;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.MileageUnitValue;
import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.metadata.Type;

public class MileageConverter extends CustomConverter<String, MileageUnit> {
    public MileageUnit convert(String source, Type<? extends MileageUnit> destinationType) {
        return new MileageUnit(MileageUnitValue.valueOf(source));
    }
}
