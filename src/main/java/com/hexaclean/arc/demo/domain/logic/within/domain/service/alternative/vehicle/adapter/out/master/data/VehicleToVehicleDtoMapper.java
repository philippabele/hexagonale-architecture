package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.out.master.data;

import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.out.master.data.dto.EquipmentDto;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.dto.EquipmentCodeDomainDto;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.dto.EquipmentDomainDto;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.dto.VehicleMasterDataDomainDto;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.MileageUnit;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.SerialNumber;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.VehicleModel;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.adapter.out.master.data.dto.VehicleDto;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.MileageUnitValue;

import java.util.stream.Collectors;

public class VehicleToVehicleDtoMapper {

    public VehicleMasterDataDomainDto mapVehicleDtoToVehicleMasterData(VehicleDto dto) {
        return new VehicleMasterDataDomainDto(
                dto.getEquipmentListDto().getEquipmentList().stream().map(this::mapEquipmentDbEntityToEquipment).collect(Collectors.toList()),
                new VehicleModel(dto.getBaumusterDescription(), dto.getBaumuster()),
                new MileageUnit(MileageUnitValue.valueOf(dto.getMileageUnit())),
                new SerialNumber(dto.getSerialNumber()));
    }

    private EquipmentDomainDto mapEquipmentDbEntityToEquipment(EquipmentDto dto) {
        return new EquipmentDomainDto(new EquipmentCodeDomainDto(dto.getCode()), dto.getLabel());
    }
}
