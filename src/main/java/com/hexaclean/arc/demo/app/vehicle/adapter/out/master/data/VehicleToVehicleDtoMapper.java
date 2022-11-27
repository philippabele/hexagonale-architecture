package com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data;


import com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data.dto.EquipmentDto;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data.dto.VehicleDataDto;
import com.hexaclean.arc.demo.app.vehicle.domain.dto.VehicleMasterDataDomainDto;
import com.hexaclean.arc.demo.app.vehicle.domain.model.MileageUnit;
import com.hexaclean.arc.demo.app.vehicle.domain.model.MileageUnitValue;
import com.hexaclean.arc.demo.app.vehicle.domain.model.SerialNumber;
import com.hexaclean.arc.demo.app.vehicle.domain.model.VehicleModel;

import java.util.stream.Collectors;

public class VehicleToVehicleDtoMapper {

    public VehicleMasterDataDomainDto mapVehicleDtoToVehicleMasterData(VehicleDataDto dto) {
        return new VehicleMasterDataDomainDto(
                dto.getEquipmentListDto().getEquipmentList().stream().map(this::mapEquipmentDbEntityToEquipment).collect(Collectors.toList()),
                new VehicleModel(dto.getBaumusterDescription(), dto.getBaumuster()),
                new MileageUnit(MileageUnitValue.valueOf(dto.getMileageUnit())),
                new SerialNumber(dto.getSerialNumber()));
    }

    private String mapEquipmentDbEntityToEquipment(EquipmentDto dto) {
        return dto.getCode();
    }
}
