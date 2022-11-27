package com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data;

import com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data.dto.EquipmentDto;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data.dto.EquipmentListDto;
import com.hexaclean.arc.demo.app.vehicle.domain.model.MileageUnitValue;
import com.hexaclean.arc.demo.app.vehicle.domain.model.VehicleMasterData;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.app.vehicle.usecase.out.FetchVehicleMasterData;
import com.hexaclean.arc.demo.app.vehicle.adapter.out.master.data.dto.VehicleDataDto;

import java.util.ArrayList;
import java.util.List;

public class VehicleMasterDataServiceClient implements FetchVehicleMasterData {

    private VehicleToVehicleDtoMapper mapper;

    private static final String VEHICLE_MODEL_DESCRIPTION_TEST_VALUE = "E30 Limousine";
    private static final String VEHICLE_MODEL_TYPE_TEST_VALUE = "3er";
    private static final String SERIAL_NUMBER_TEST_VALUE = "0123456789";
    private static final String VIN = "WP0ZZZ99ZTS392155";

    public VehicleMasterDataServiceClient(VehicleToVehicleDtoMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public VehicleMasterData fetch(Vin vin) {
        return mapper.mapVehicleDtoToVehicleMasterData(createExpectedVehicleDto());
    }

    private VehicleDataDto createExpectedVehicleDto() {
        EquipmentListDto equipmentListDto = new EquipmentListDto();
        equipmentListDto.setEquipmentList(createEquipmentListDto());
        VehicleDataDto vehicleDto = new VehicleDataDto();
        vehicleDto.setBaumuster(VEHICLE_MODEL_TYPE_TEST_VALUE);
        vehicleDto.setBaumusterDescription(VEHICLE_MODEL_DESCRIPTION_TEST_VALUE);
        vehicleDto.setMileageUnit(MileageUnitValue.KM.toString());
        vehicleDto.setVinOrFin(VIN);
        vehicleDto.setSerialNumber(SERIAL_NUMBER_TEST_VALUE);
        vehicleDto.setEquipmentListDto(equipmentListDto);
        return vehicleDto;
    }

    private List<EquipmentDto> createEquipmentListDto() {
        List<EquipmentDto> list = new ArrayList<>();
        list.add(new EquipmentDto("CU897", "Live Traffic Assistent"));
        list.add(new EquipmentDto("DK564", "Visual Park Assistent"));
        list.add(new EquipmentDto("KL457", "Sports Chassis M Deluxe"));
        return list;
    }
}
