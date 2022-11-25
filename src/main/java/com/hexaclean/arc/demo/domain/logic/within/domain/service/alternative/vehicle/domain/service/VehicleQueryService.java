package com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.service;

import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.dto.VehicleMasterDataDomainDto;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.factory.VehicleMasterDataFactory;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.LicensePlate;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.usecase.in.VehicleQuery;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.usecase.out.VehicleDbQuery;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.domain.logic.within.domain.service.alternative.vehicle.usecase.out.FetchVehicleMasterData;
import org.springframework.stereotype.Service;

@Service
public class VehicleQueryService implements VehicleQuery {

    private VehicleDbQuery vehicleDbQuery;
    private FetchVehicleMasterData fetchVehicleMasterData;
    private Has2GSupportDetectorService has2GSupportDetectorService;
    private VehicleMasterDataFactory vehicleMasterDataFactory;

    public VehicleQueryService(VehicleDbQuery vehicleDbQuery, FetchVehicleMasterData fetchVehicleMasterData, Has2GSupportDetectorService has2GSupportDetectorService, VehicleMasterDataFactory vehicleMasterDataFactory) {
        this.vehicleDbQuery = vehicleDbQuery;
        this.fetchVehicleMasterData = fetchVehicleMasterData;
        this.has2GSupportDetectorService = has2GSupportDetectorService;
        this.vehicleMasterDataFactory = vehicleMasterDataFactory;
    }

    public Vehicle findByVin(Vin vin) {
        Vehicle vehicle = vehicleDbQuery.findVehicleByVin(vin);
        enrichWithVehicleMasterData(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle findByLicensePlate(LicensePlate licensePlate) {
        Vehicle vehicle = vehicleDbQuery.findVehicleByLicensePlate(licensePlate);
        enrichWithVehicleMasterData(vehicle);
        return vehicle;
    }

    private void enrichWithVehicleMasterData(Vehicle vehicle) {
        VehicleMasterDataDomainDto domainDto = fetchVehicleMasterData.fetch(vehicle.getVin());
        vehicle.addVehicleMasterData(vehicleMasterDataFactory.create(
                domainDto, has2GSupportDetectorService.determineHas2GSupport(domainDto.equipmentList())));
    }
}
