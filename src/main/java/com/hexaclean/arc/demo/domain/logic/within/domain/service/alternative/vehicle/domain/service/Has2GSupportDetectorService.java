package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.service;

import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.dto.EquipmentDomainDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class Has2GSupportDetectorService {

    public boolean determineHas2GSupport(List<EquipmentDomainDto> equipmentList) {
        return equipmentList.stream()
                .filter(equipment -> equipment.code().value().equals("CZ471") || equipment.code().value().equals("BU081"))
                .findAny().isPresent();
    }

}
