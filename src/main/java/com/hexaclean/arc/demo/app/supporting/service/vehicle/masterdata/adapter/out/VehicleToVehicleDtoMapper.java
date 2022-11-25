package com.hexaclean.arc.demo.app.supporting.service.vehicle.masterdata.adapter.out;

import com.clean.arc.demo.app.supporting.service.vehicle.masterdata.model.*;
import com.daimler.dcp.clean.arc.demo.app.masterdata.model.*;
import com.hexaclean.arc.demo.app.supporting.service.vehicle.masterdata.adapter.out.dto.EquipmentDto;
import com.hexaclean.arc.demo.app.supporting.service.vehicle.masterdata.adapter.out.dto.VehicleDto;
import com.daimler.dcp.clean.arc.demo.app.supporting.service.vehicle.masterdata.model.*;
import com.daimler.dcp.clean.arc.demo.supporting.service.vehicle.masterdata.model.*;
import com.hexaclean.arc.demo.app.supporting.service.vehicle.masterdata.model.*;

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