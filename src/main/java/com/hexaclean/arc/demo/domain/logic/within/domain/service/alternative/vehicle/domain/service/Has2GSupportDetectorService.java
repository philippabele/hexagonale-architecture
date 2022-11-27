package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
class Has2GSupportDetectorService {

    public boolean determineHas2GSupport(List<String> equipmentList) {
        return equipmentList.stream()
                .filter(equipmentCode -> equipmentCode.equals("GS200"))
                .findAny().isPresent();
    }

}
