package com.hexaclean.arc.demo.app.parts.catalogue.appservice;

import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.ExplosionChart;
import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.PartsCategoryCode;
import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.vehicle.Vehicle;
import com.hexaclean.arc.demo.app.parts.catalogue.domain.service.ExplosionChartDomainService;
import com.hexaclean.arc.demo.app.parts.catalogue.usecase.in.ExplosionChartQuery;
import com.hexaclean.arc.demo.app.parts.catalogue.usecase.out.FetchExplosionChart;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleQuery;
import org.springframework.stereotype.Component;

@Component
public class ExplosionChartApplicationService implements ExplosionChartQuery {

    private FetchExplosionChart fetchExplosionChart;
    private VehicleQuery vehicleQuery;
    private VehicleToOriginVehicleMapper vehicleToOriginVehicleMapper;
    private ExplosionChartDomainService explosionChartDomainService;

    public ExplosionChartApplicationService(FetchExplosionChart fetchExplosionChart,
                                            VehicleQuery vehicleQuery,
                                            VehicleToOriginVehicleMapper vehicleToOriginVehicleMapper,
                                            ExplosionChartDomainService explosionChartDomainService) {
        this.fetchExplosionChart = fetchExplosionChart;
        this.vehicleQuery = vehicleQuery;
        this.vehicleToOriginVehicleMapper = vehicleToOriginVehicleMapper;
        this.explosionChartDomainService = explosionChartDomainService;
    }

    @Override
    public ExplosionChart read(PartsCategoryCode partsCategoryCode, String vin) {
        Vehicle vehicle = vehicleToOriginVehicleMapper.mapOriginVehicleToVehicle(vehicleQuery.findByVin(new Vin(vin)));
        ExplosionChart explosionChart = fetchExplosionChart.fetch(partsCategoryCode, vehicle.vehicleModel(), vehicle.has2GSupport());
        explosionChartDomainService.doSomeIdependentBusinessLogic(explosionChart);
        explosionChart.doSomeIdependentBusinessLogic();
        return explosionChart;
    }

}
