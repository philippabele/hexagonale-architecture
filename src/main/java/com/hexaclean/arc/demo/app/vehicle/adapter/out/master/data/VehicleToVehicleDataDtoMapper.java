package com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data;


import com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data.dto.EquipmentDto;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data.dto.VehicleDataDto;
import com.hexaclean.arc.demo.app.vehicle.domain.model.*;

import java.util.stream.Collectors;

public class VehicleToVehicleDataDtoMapper {

    public VehicleMasterData mapVehicleDtoToVehicleMasterData(VehicleDataDto dto) {
        return new VehicleMasterData(
                new VehicleModel(dto.getBaumusterDescription(), dto.getBaumuster()),
                new SerialNumber(dto.getSerialNumber()),
                new MileageUnit(MileageUnitValue.valueOf(dto.getMileageUnit())),
                dto.getEquipmentListDto().getEquipmentList()
                        .stream().map(e -> new Equipment(new EquipmentCode(e.getCode()), e.getLabel()))
                        .collect(Collectors.toList()));
    }

    private String mapEquipmentDbEntityToEquipment(EquipmentDto dto) {
        return dto.getCode();
    }
}
