package com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data;

import com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data.dto.EquipmentDto;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data.dto.VehicleDto;
import com.clean.arc.demo.app.vehicle.domain.model.*;
import com.daimler.dcp.clean.arc.demo.app.vehicle.domain.model.*;
import com.daimler.dcp.clean.arc.demo.vehicle.domain.model.*;
import com.hexaclean.arc.demo.app.vehicle.domain.model.*;

import java.util.stream.Collectors;

public class VehicleToVehicleDtoMapper {

    public VehicleMasterData mapVehicleDtoToVehicleMasterData(VehicleDto dto) {
        return new VehicleMasterData(
                dto.getEquipmentListDto().getEquipmentList().stream().map(this::mapEquipmentDbEntityToEquipment).collect(Collectors.toList()),
                new VehicleModel(dto.getBaumusterDescription(), dto.getBaumuster()),
                new SerialNumber(dto.getSerialNumber()),
                new MileageUnit(MileageUnitValue.valueOf(dto.getMileageUnit())));
    }

    private Equipment mapEquipmentDbEntityToEquipment(EquipmentDto dto) {
        return new Equipment(new EquipmentCode(dto.getCode()), dto.getLabel());
    }
}
